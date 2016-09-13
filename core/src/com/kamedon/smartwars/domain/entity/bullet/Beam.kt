package com.kamedon.smartwars.domain.entity.bullet

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.kamedon.smartwars.domain.entity.unit.WarUnit

/**
 * Created by kamei.hidetoshi on 2016/07/24.
 */
class Beam() : Bullet() {

    var targetRad: Float = 0f

    init {
        this.power = 20f
        this.velocity = 4f
        this.aliveTime = 2f
    }

    override fun isCollide(unit: WarUnit): Boolean {
        var r = unit.halfWidth + halfWidth
        return (Vector2.len2(unit.x - x, unit.y - y) < r * r)
    }

    override fun fromTo(self: WarUnit, target: WarUnit) {
        setPosition(self.x, self.y)
        targetRad = MathUtils.atan2(target.y - self.y, target.x - self.x)
    }

    override fun move(delta: Float, runtime: Float) {
        x += velocity * MathUtils.cos(targetRad)
        y += velocity * MathUtils.sin(targetRad)
    }
}
