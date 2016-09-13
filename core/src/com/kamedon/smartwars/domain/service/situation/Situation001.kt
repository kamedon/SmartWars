package com.kamedon.smartwars.domain.service.situation

import com.badlogic.gdx.graphics.Color
import com.kamedon.smartwars.SmartWarsGame
import com.kamedon.smartwars.domain.entity.bullet.Beam
import com.kamedon.smartwars.domain.entity.common.Team
import com.kamedon.smartwars.domain.entity.factory.bullet.SimpleBulletFactory
import com.kamedon.smartwars.domain.entity.unit.Viper
import com.kamedon.smartwars.domain.entity.weapon.BeamRifle
import com.kamedon.smartwars.domain.entity.weapon.NoneWeapon

/**
 * Created by kamei.hidetoshi on 2016/07/26.
 */
class Situation001(game: SmartWarsGame) : SituationService(game) {
    val count = 5

    override fun makeAlly(): Team {
        val team = Team(Color.WHITE)
        val bullet = Beam()
        bullet.image = unitImages.findRegion("bullet")!!
        val factory = SimpleBulletFactory(bullet)
        val unit = Viper()
        unit.image = unitImages.findRegions("unit")[0]
        unit.weapon = BeamRifle(factory)

        val weapon = NoneWeapon()
        createShip(count, unit, unitImages.findRegions("ship")[0], weapon) {
            i, ship ->
            ship.setPosition(ship.halfWidth, ((height-ship.height) * i / count) + ship.halfHeight)
            team.add(ship)
        }
        return team
    }


    override fun makeEnemy(): Team {
        val team = Team(Color.RED)
        val unit = Viper()
        val bullet = Beam()
        bullet.image = unitImages.findRegion("bullet")!!
        val factory = SimpleBulletFactory(bullet)
        unit.image = unitImages.findRegions("unit")[0]
        unit.weapon = BeamRifle(factory)
        val weapon = NoneWeapon()
        createShip(count, unit, unitImages.findRegions("ship")[0], weapon) {
            i, ship ->
            ship.setPosition(width - ship.halfWidth, ((height-ship.height) * i / count) + ship.halfHeight)
            team.add(ship)
        }
        return team
    }

}
