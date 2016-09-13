package com.kamedon.smartwars.domain.entity.stage

import com.badlogic.gdx.utils.viewport.Viewport
import com.kamedon.smartwars.domain.entity.common.Team
import com.kamedon.smartwars.domain.service.BattleService

/**
 * Created by kamei.hidetoshi on 2016/07/22.
 */
class BattleStage(viewport: Viewport, val ally: Team, val enemy: Team) : BaseStage(viewport) {
    init {
        addActor(enemy)
        addActor(ally)
    }

    /**
     *  弾とユニットのダメージ解決判定
     */
    fun damagePhase() {
        BattleService.damagePhase(ally.units, enemy.bullets)
        BattleService.damagePhase(enemy.units, ally.bullets)
    }

    /**
     *  ユニットの次の行動をきめる
     */
    fun strategyPhase(delta: Float) {
        BattleService.strategyPhase(ally.units, enemy.units, delta)
        BattleService.strategyPhase(enemy.units, ally.units, delta)
    }

    fun  actBullet(delta: Float) {
        ally.bullets.act(delta)
        enemy.bullets.act(delta)
    }
}
