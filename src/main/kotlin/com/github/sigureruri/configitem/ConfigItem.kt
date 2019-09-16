package com.github.sigureruri.configitem

import com.github.sigureruri.configitem.config.Config
import org.bukkit.plugin.java.JavaPlugin

class ConfigItem : JavaPlugin() {

    /** ConfigItemのConfig */
    lateinit var pluginConfig: Config;

    override fun onEnable() {
        pluginConfig = Config(this)

    }

    override fun onDisable() {
    }
}
