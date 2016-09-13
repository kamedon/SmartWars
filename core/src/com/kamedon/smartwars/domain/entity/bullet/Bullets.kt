package com.kamedon.smartwars.domain.entity.bullet

import com.badlogic.gdx.scenes.scene2d.Group

/**
 * Created by kamei.hidetoshi on 2016/07/23.
 */

class Bullets : Group() {
    fun add(bullet: Bullet) {
        addActor(bullet)
    }

    inline fun lockForEach(f: (Bullet) -> Unit) {
        if (children.size == 0) return
        children.begin().forEach {
            actor ->
            if (actor != null) {
                f(actor as Bullet)
            }
        }
        children.end()
    }

    fun forEach(f: (Bullet) -> Unit) {
        children.forEach {
            if (it != null) {
                f(it as Bullet)
            }
        }
    }

}