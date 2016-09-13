package com.kamedon.smartwars.domain.entity.common

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.Group
import com.kamedon.smartwars.domain.entity.bullet.Bullet
import com.kamedon.smartwars.domain.entity.bullet.Bullets
import com.kamedon.smartwars.domain.entity.unit.WarUnit
import com.kamedon.smartwars.domain.entity.unit.WarUnits

/**
 * Created by kamei.hidetoshi on 2016/07/23.
 */
class Team(val baseColor: Color) : Group() {
    val bullets: Bullets = Bullets()
    val units: WarUnits = WarUnits()

    init {
        addActor(units)
        addActor(bullets)
    }

    fun add(bullet: Bullet) {
        bullet.team = this
        bullet.color = baseColor
        bullets.add(bullet)
    }

    fun add(unit: WarUnit) {
        unit.team = this
        unit.color = baseColor
        units.add(unit)
    }

}
