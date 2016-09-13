package com.kamedon.smartwars.domain.entity.bullet

import com.badlogic.gdx.utils.Pools
import com.kamedon.smartwars.domain.entity.common.BaseObject
import com.kamedon.smartwars.domain.entity.common.Team
import com.kamedon.smartwars.domain.entity.unit.WarUnit

/**
 * Created by kamei.hidetoshi on 2016/07/23.
 */
abstract class Bullet() : BaseObject() {
    var power: Float = 2f
    var velocity = 2f
    var aliveTime = 2f
    lateinit var team: Team
    var halfHeight: Float = 0f
    var halfWidth: Float = 0f

    fun damageTo(unit: WarUnit): Boolean {
        unit.damage(power)
        if (!unit.isAlive) {
            unit.die()
        }
        return true
    }

    abstract fun isCollide(unit: WarUnit): Boolean

    fun createFromPool(): Bullet {
        val cloneBullet = Pools.obtain(this.javaClass)
        cloneBullet.reset()
        return cloneBullet.copy(this)
    }

    open fun reset(): Bullet {
        runtime = 0f
        return this
    }

    fun copy(baseBullet: Bullet): Bullet {
        power = baseBullet.power
        image = baseBullet.image
        velocity = baseBullet.velocity
        init()
        return this
    }


    fun init() {
        width = image.originalWidth.toFloat()
        height = image.originalHeight.toFloat()
        originX = image.originalWidth / 2f
        originY = image.originalHeight / 2f
        halfWidth = width / 2f
        halfHeight = height / 2f
    }

    var runtime: Float = 0f

    override fun act(delta: Float) {
        runtime += delta
        if (isAlive()) {
            move(delta, runtime)
        } else {
            die()
        }
    }

    abstract fun move(delta: Float, runtime: Float)

    private fun die() {
        remove()
        Pools.free(this)
    }

    fun isAlive(runtime: Float) = runtime <= aliveTime
    fun isAlive() = isAlive(runtime)


    abstract fun fromTo(self: WarUnit, target: WarUnit)

}
