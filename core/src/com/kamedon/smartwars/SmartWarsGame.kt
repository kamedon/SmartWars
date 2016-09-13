package com.kamedon.smartwars

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.GL20
import com.kamedon.smartwars.domain.service.situation.Situation001
import com.kamedon.smartwars.infra.AssetsLoader
import com.kamedon.smartwars.infra.CameraManager
import com.kamedon.smartwars.presentation.screen.BattleScreen

class SmartWarsGame : Game() {
    lateinit var camera: CameraManager;
    lateinit var asset: AssetManager
    lateinit var loader: AssetsLoader

    override fun create() {
        camera = CameraManager(960f);
        asset = AssetManager()
        loader = AssetsLoader(asset)
        loader.loadBg()
        loader.loadUnits()
        loader.loadFont(30)
        loader.finishLoading()
        setScreen(BattleScreen(this, Situation001(this)))
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        super.render()
    }

    override fun dispose() {
        super.dispose()
        asset.dispose()
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        camera.gameViewport.update(width, height)
        camera.uiViewport.update(width, height)
    }
}
