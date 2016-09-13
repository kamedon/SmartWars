package com.kamedon.smartwars.domain.entity.ship

/**
 * Created by kamei.hidetoshi on 2016/07/26.
 */
class Scout() : Ship() {

    init {
        hp = 500f
        velocity = 0f
    }

    override fun act(delta: Float) {
        super.act(delta)
        rotation += 1
    }
}