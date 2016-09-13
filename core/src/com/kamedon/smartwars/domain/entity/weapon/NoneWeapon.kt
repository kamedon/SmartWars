package com.kamedon.smartwars.domain.entity.weapon

import com.kamedon.smartwars.domain.entity.bullet.Beam
import com.kamedon.smartwars.domain.entity.factory.bullet.SimpleBulletFactory

/**
 * Created by kamei.hidetoshi on 2016/07/26.
 */
class NoneWeapon() : Weapon(0f, 0f, SimpleBulletFactory(Beam())) {

    override fun canShoot(distance: Float, runtime: Float): Boolean {
        return false
    }

}
