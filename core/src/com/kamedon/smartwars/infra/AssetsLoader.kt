package com.kamedon.smartwars.infra

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader

/**
 * Created by kamei.hidetoshi on 2016/07/23.
 */
class AssetsLoader(val asset: AssetManager) {

    val fontPath: String = "font/font.ttf"

    fun loadFont(size: Int) {
        val resolver = InternalFileHandleResolver();
        asset.setLoader(FreeTypeFontGenerator::class.java, FreeTypeFontGeneratorLoader(resolver));
        asset.setLoader(BitmapFont::class.java, ".ttf", FreetypeFontLoader(resolver));
        val size1Params = FreetypeFontLoader.FreeTypeFontLoaderParameter();
        size1Params.fontFileName = fontPath;
        size1Params.fontParameters.size = size;
        asset.load(fontPath, BitmapFont::class.java, size1Params);
    }

    fun loadCustomFont(char: String, size: Int): BitmapFont? {
        val generator = FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        val parameter = FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = char
        parameter.size = size;
        val font = generator.generateFont(parameter);
        generator.dispose();
        return font
    }

    fun unLoadFont() {
        asset.unload(fontPath)
    }

    fun getFont(): BitmapFont {
        return asset.get(fontPath, BitmapFont::class.java)
    }

    fun loadBg() {
        asset.load("bg/bg_01.jpg", Texture::class.java)
    }

    fun getBg(): Texture {
        return asset.get("bg/bg_01.jpg", Texture::class.java)
    }

    fun loadUnits() {
        asset.load("unit/pack.atlas", TextureAtlas::class.java)
    }

    fun getUnits(): TextureAtlas {
        return asset.get("unit/pack.atlas", TextureAtlas::class.java)
    }

    fun finishLoading() {
        asset.finishLoading()
    }

    fun dispose() {
        asset.dispose()
    }
}

