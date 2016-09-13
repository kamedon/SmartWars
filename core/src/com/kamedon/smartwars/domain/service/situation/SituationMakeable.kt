package com.kamedon.smartwars.domain.service.situation

import com.kamedon.smartwars.domain.entity.common.Team

/**
 * Created by kamei.hidetoshi on 2016/07/26.
 */
interface SituationMakeable {
    fun makeAlly(): Team
    fun makeEnemy(): Team
}

