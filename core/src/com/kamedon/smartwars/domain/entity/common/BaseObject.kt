package com.kamedon.smartwars.domain.entity.common

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.Actor
import com.kamedon.smartwars.util.extensions.centerX
import com.kamedon.smartwars.util.extensions.centerY

/**
 * Created by kamei.hidetoshi on 2016/07/22.
 */
open class BaseObject : Actor() {

    lateinit var image: TextureAtlas.AtlasRegion

    override fun draw(batch: Batch?, parentAlpha: Float) {
        batch?.setColor(color.r, color.g, color.b, color.a * parentAlpha)
        batch?.draw(image, centerX, centerY, originX, originY, width, height, scaleX, scaleY, rotation);
    }
}
