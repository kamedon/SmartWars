package com.kamedon.smartwars.domain.service.situation

import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.kamedon.smartwars.SmartWarsGame
import com.kamedon.smartwars.domain.entity.factory.unit.SimpleUnitFactory
import com.kamedon.smartwars.domain.entity.ship.Scout
import com.kamedon.smartwars.domain.entity.ship.Ship
import com.kamedon.smartwars.domain.entity.unit.WarUnit
import com.kamedon.smartwars.domain.entity.weapon.NoneWeapon

/**
 * Created by kamei.hidetoshi on 2016/07/26.
 */
abstract class SituationService(val game: SmartWarsGame) : SituationMakeable {

    val width = game.camera.width
    val height = game.camera.height
    val halfHeight = game.camera.height / 2
    val halfWidth = game.camera.width / 2

    val unitImages by lazy {
        game.loader.getUnits()
    }

    fun createShip(count: Int, unit: WarUnit, image: TextureAtlas.AtlasRegion, weapon: NoneWeapon, f: (Int, Ship) -> Unit) {
        val factory = SimpleUnitFactory(unit)
        val scout = Scout()
        scout.image = image
        scout.weapon = weapon
        scout.factory = factory
        for (i in 0..count) {
            f(i, scout.createFromPool() as Ship)
        }
    }

}
