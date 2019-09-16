package com.github.sigureruri.configitem.config

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.Plugin

class Config(private val PLUGIN: Plugin) {

    /** ConfigのFileConfiguration */
    private var config: FileConfiguration? = null

    // init
    init {
        load()
    }

    /**
     * ConfigのLoad
     * configがNullではない場合はReloadされる。
     */
    fun load() {
        PLUGIN.saveDefaultConfig()
        if (config != null) {
            PLUGIN.reloadConfig()
        }
        config = PLUGIN.config;
    }

}
