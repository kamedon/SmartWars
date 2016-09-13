package com.kamedon.smartwars.presentation.screen

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.kamedon.smartwars.SmartWarsGame
import com.kamedon.smartwars.domain.entity.stage.BattleStage
import com.kamedon.smartwars.domain.service.situation.SituationMakeable

/**
 * Created by kamei.hidetoshi on 2016/07/22.
 */
class BattleScreen(game: SmartWarsGame, val situation: SituationMakeable) : BaseScreen(game) {

    lateinit var stage: BattleStage
    lateinit var background: Texture
    val batch = SpriteBatch()


    override fun show() {
        stage = BattleStage(gameViewPoint, situation.makeAlly(), situation.makeEnemy())
        background = assetLoader.getBg()
    }


    override fun pause() {
    }

    override fun resize(width: Int, height: Int) {
        game.camera.gameViewport.update(width, height)
        game.camera.uiViewport.update(width, height)
    }

    override fun hide() {
    }

    override fun render(delta: Float) {
        gameCamera.update()
        uiCamera.update()
        batch.projectionMatrix = uiCamera.combined
        batch.begin()
        batch.draw(background, -centerWidth, -centerHeight, width, height)
        batch.end()

        //ダメージ解決
        stage.damagePhase()
        //次に狙うUnitを探す
        stage.strategyPhase(delta)
        //ユニットの行動
        stage.actBullet(delta)
        stage.draw()
    }

    override fun resume() {
    }

    override fun dispose() {
        batch.dispose()
    }
}
