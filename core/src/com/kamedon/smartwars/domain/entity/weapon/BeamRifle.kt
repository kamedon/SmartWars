package com.kamedon.smartwars.domain.entity.weapon

import com.kamedon.smartwars.domain.entity.factory.bullet.SimpleBulletFactory

/**
 * Created by kamei.hidetoshi on 2016/07/24.
 */
class BeamRifle(factory: SimpleBulletFactory) : Weapon(1000000f, 1f, factory) {
}
