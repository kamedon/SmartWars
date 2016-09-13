package com.kamedon.smartwars.domain.entity.unit

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group

/**
 * Created by kamei.hidetoshi on 2016/07/23.
 */
class WarUnits : Group() {
    fun add(unit: WarUnit) {
        addActor(unit)
    }

    operator fun get(index: Int) = children[index]!!

    inline fun forEach(f: (WarUnit) -> Unit) {
        children.forEach {
            f(it as WarUnit)
        }
    }

    inline fun lockForEach(f: (WarUnit) -> Unit) {
        if (children.size == 0) return
        children.begin().forEach {
            actor ->
            if (actor != null) {
                f(actor as WarUnit)
            }
        }
        children.end()
    }

    fun near(actor: Actor): Actor? {
        val size = children.size
        if (size > 0) {
            if (size == 1) {
                return children[0]
            } else {
                var nearUnit = children[0]
                var nearDistance = Vector2.len2(actor.x - nearUnit.x, actor.y - nearUnit.y)
                var distance = 0f
                val count = size - 1
                var unit: Actor
                for (i in 1..count) {
                    unit = children[i]
                    distance = Vector2.len2(actor.x - unit.x, actor.y - unit.y)
                    if (nearDistance > distance) {
                        nearDistance = distance
                        nearUnit = unit
                    }
                }
                return nearUnit
            }
        }
        return null
    }
}
