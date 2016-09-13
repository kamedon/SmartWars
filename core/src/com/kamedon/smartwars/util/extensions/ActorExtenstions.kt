package com.kamedon.smartwars.util.extensions

import com.badlogic.gdx.scenes.scene2d.Actor

/**
 * Created by kamei.hidetoshi on 2016/07/24.
 */

val Actor.centerX: Float
    get() = x - originX
val Actor.centerY: Float
    get() = y - originY
