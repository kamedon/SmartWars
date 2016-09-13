package com.kamedon.smartwars.infra

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.utils.viewport.FitViewport

/**
 * Created by kamei.hidetoshi on 2016/07/22.
 */
class CameraManager(val width: Float) {
    val height: Float
    val gameCamera: OrthographicCamera
    val uiCamera: OrthographicCamera
    val gameViewport: FitViewport
    val uiViewport: FitViewport
    val displayRect: Rectangle

    init {
        var displayRate = width / Gdx.graphics.width;
        height = Gdx.graphics.height * displayRate;
        displayRect = Rectangle(0f, 0f, width, height);
        gameCamera = OrthographicCamera(width, height);
        gameCamera.setToOrtho(false, width, height);
        uiCamera = OrthographicCamera();
        gameViewport = FitViewport(width, height, gameCamera);
        uiViewport = FitViewport(width, height, uiCamera);
    }

}
