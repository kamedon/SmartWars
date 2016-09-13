package com.kamedon.smartwars.domain.entity.factory.bullet

import com.kamedon.smartwars.domain.entity.bullet.Bullet
import com.kamedon.smartwars.domain.entity.unit.WarUnit

/**
 * Created by kamei.hidetoshi on 2016/07/28.
 */
class SimpleBulletFactory(bullet: Bullet) : BulletFactory(bullet) {
    override fun produce(self: WarUnit, target: WarUnit): Bullet {
        val bullet = bulletModel.createFromPool()
        bullet.fromTo(self, target)
        return bullet
    }

}
