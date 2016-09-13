package com.kamedon.smartwars.domain.entity.ship

import com.kamedon.smartwars.domain.entity.unit.WarUnit
import com.kamedon.smartwars.domain.service.UnitProducible

/**
 * Created by kamei.hidetoshi on 2016/07/26.
 */
abstract class Ship() : WarUnit(), UnitProducible {
    var factoryTime = 0f
    lateinit var factory: UnitProducible

    override fun ability(delta: Float) {
        factoryTime += delta
        if (factory.canProduce(factoryTime)) {
            val unit = factory.produce()
            unit.setPosition(x, y)
            team.add(unit)
            factoryTime = 0f
        }
    }

    override fun copy(baseUnit: WarUnit): WarUnit {
        super.copy(baseUnit)
        val ship = baseUnit as Ship
        factory = ship.factory
        factoryTime = 0f
        return this
    }

    override fun canProduce(factoryTime: Float): Boolean = factory.canProduce(factoryTime)

    override fun produce(): WarUnit = factory.produce()


}