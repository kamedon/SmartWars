package com.kamedon.smartwars.domain.entity.unit

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Pools
import com.kamedon.smartwars.domain.entity.common.BaseObject
import com.kamedon.smartwars.domain.entity.common.Team
import com.kamedon.smartwars.domain.entity.weapon.Weapon

/**
 * Created by kamei.hidetoshi on 2016/07/23.
 */
open abstract class WarUnit() : BaseObject() {
    companion object {
        val SPAN_SEARCH_TIME = 1f
    }

    var hp: Float = 100f
    lateinit var weapon: Weapon
    lateinit var team: Team

    var halfWidth: Float = 0f
    var halfHeight: Float = 0f

    /*
     * 時間
     */
    var weaponTime: Float = 0f
    var searchTime: Float = 0f
    //

    var velocity = 2f
    var target: WarUnit? = null
    val isAlive: Boolean
        get() = hp > 0

    fun createFromPool(): WarUnit {
        val cloneUnit = Pools.get(this.javaClass, 300).obtain()
        cloneUnit.reset()
        return cloneUnit.copy(this)
    }

    open fun reset(): WarUnit {
        weaponTime = 0f
        searchTime = 0f
        target = null
        rotation = 0f
        return this
    }

    open fun copy(baseUnit: WarUnit): WarUnit {
        hp = baseUnit.hp
        weapon = baseUnit.weapon
        image = baseUnit.image
        velocity = baseUnit.velocity
        init()
        return this
    }


    fun init() {
        width = image.originalWidth.toFloat()
        height = image.originalHeight.toFloat()
        halfWidth = width / 2f
        halfHeight = height / 2f
        originX = image.originalWidth / 2f
        originY = image.originalHeight / 2f
    }

    fun searchTarget(enemy: WarUnits, delta: Float) {
        searchTime += delta
        if (searchTime > SPAN_SEARCH_TIME) {
            target = null
            enemy.near(this)?.let {
                target = it as WarUnit
            }
            searchTime = 0f
        }
    }

    fun attack(delta: Float) {
        if (isAlive) {
            weaponTime += delta
            target?.let {
                if (weapon.canShoot(Vector2.len2(x - it.x, y - it.y), weaponTime)) {
                    weapon.shoot(this, it).let {
                        bullet ->
                        team.add(bullet)
                    }
                    weaponTime = 0f
                }
            }

        }
    }

    fun damage(power: Float) {
        hp -= power
    }

    /**
     * 固有のスキルをする
     */
    open fun ability(delta: Float) {
    }

    fun die() {
        remove()
        Pools.free(this)
    }


}

