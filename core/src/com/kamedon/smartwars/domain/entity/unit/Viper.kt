package com.kamedon.smartwars.domain.entity.unit

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Vector2
import com.kamedon.smartwars.util.extensions.centerX
import com.kamedon.smartwars.util.extensions.centerY

/**
 * Created by kamei.hidetoshi on 2016/07/24.
 */
class Viper() : WarUnit() {
    init {
        hp = 100f
        velocity = 3.0f
    }

    override fun act(delta: Float) {
        target?.let {
            val vector = Vector2(it.centerX - centerX, it.centerY - centerY)
            val d = vector.angle()
            val rad = vector.angleRad()
            moveBy(velocity * MathUtils.cos(rad), velocity * MathUtils.sin(rad))
            rotation = d - 90
        }
    }


}
