package com.kamedon.smartwars.domain.entity.factory.bullet

import com.kamedon.smartwars.domain.entity.bullet.Bullet
import com.kamedon.smartwars.domain.entity.unit.WarUnit

/**
 * Created by kamei.hidetoshi on 2016/07/28.
 */
abstract class BulletFactory(val bulletModel: Bullet) {
    abstract fun produce(self: WarUnit, target: WarUnit): Bullet
}
