package com.kamedon.smartwars.domain.service

import com.kamedon.smartwars.domain.entity.bullet.Bullets
import com.kamedon.smartwars.domain.entity.unit.WarUnits

/**
 * Created by kamei.hidetoshi on 2016/07/23.
 */
class BattleService {
    companion object {
        fun damagePhase(units: WarUnits, bullets: Bullets) {
            bullets.lockForEach {
                bullet ->
                units.lockForEach {
                    unit ->
                    if (bullet.isCollide(unit)) {
                        if (bullet.damageTo(unit)) {
                            bullet.remove()
                            return
                        }
                    }
                }
            }
        }

        fun strategyPhase(from: WarUnits, to: WarUnits, delta: Float) {
            from.forEach {
                it.searchTarget(to, delta)
                it.ability(delta)
                it.attack(delta)
                it.act(delta)
            }
        }
    }
}