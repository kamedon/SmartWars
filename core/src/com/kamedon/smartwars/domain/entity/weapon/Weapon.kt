package com.kamedon.smartwars.domain.entity.weapon

import com.kamedon.smartwars.domain.entity.bullet.Bullet
import com.kamedon.smartwars.domain.entity.factory.bullet.BulletFactory
import com.kamedon.smartwars.domain.entity.unit.WarUnit

/**
 * Created by kamei.hidetoshi on 2016/07/24.
 */
//rangeは２乗の値
open abstract class Weapon(val range2: Float, val reloadTime: Float, val factory: BulletFactory) {
    fun shoot(self: WarUnit, target: WarUnit): Bullet = factory.produce(self, target)

    open fun canShoot(distance: Float, runtime: Float): Boolean
            = (reloadTime <= runtime) && distance <= range2

}
