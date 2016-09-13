package com.kamedon.smartwars.domain.service

import com.kamedon.smartwars.domain.entity.unit.WarUnit

/**
 * Created by kamei.hidetoshi on 2016/07/26.
 */
interface UnitProducible {
    fun produce(): WarUnit

    fun canProduce(factoryTime: Float): Boolean
}
