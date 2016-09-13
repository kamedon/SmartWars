package com.kamedon.smartwars.presentation.screen

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.utils.viewport.Viewport
import com.kamedon.smartwars.SmartWarsGame
import com.kamedon.smartwars.infra.AssetsLoader

/**
 * Created by kamei.hidetoshi on 2016/07/22.
 */
open abstract class BaseScreen(val game: SmartWarsGame) : Screen {
    val assetLoader: AssetsLoader by lazy {
        AssetsLoader(game.asset)
    }
    val uiViewPoint: Viewport by lazy {
        game.camera.uiViewport
    }

    val gameViewPoint: Viewport by lazy {
        game.camera.gameViewport
    }

    val gameCamera: Camera by lazy {
        game.camera.gameCamera
    }

    val uiCamera: Camera by lazy {
        game.camera.uiCamera
    }

    val width: Float by lazy {
        game.camera.width
    }

    val centerWidth: Float by lazy {
        game.camera.width / 2
    }

    val height: Float by lazy {
        game.camera.height
    }

    val centerHeight: Float by lazy {
        game.camera.height / 2
    }

    fun nextScreen(screen: BaseScreen) {
        game.screen = screen
    }

}
