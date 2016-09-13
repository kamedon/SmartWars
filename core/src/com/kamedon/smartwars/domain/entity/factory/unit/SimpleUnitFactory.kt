package com.kamedon.smartwars.domain.entity.factory.unit

import com.kamedon.smartwars.domain.entity.unit.WarUnit

/**
 * Created by kamei.hidetoshi on 2016/07/27.
 */
class SimpleUnitFactory(val unitModel: WarUnit, spanTime: Float = 3f) : UnitFactory(spanTime) {
    override fun canProduce(factoryTime: Float): Boolean {
        return factoryTime >= spanTime
    }

    override fun produce(): WarUnit = unitModel.createFromPool()
}
