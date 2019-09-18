package com.github.sigureruri.configitem

import com.github.sigureruri.configitem.command.ConfigItemCommand
import com.github.sigureruri.configitem.config.Config
import com.github.sigureruri.configitem.message.ConfigItem
import org.bukkit.plugin.java.JavaPlugin

class ConfigItem : JavaPlugin() {

    companion object {
        lateinit var pluginConfig: Config
    }

    override fun onEnable() {
        pluginConfig = Config(this)
        getCommand("configitem")?.setExecutor(ConfigItemCommand())
        logger.info(ConfigItem.ENABLE)
    }

    override fun onDisable() {
        logger.info(ConfigItem.DISABLE)
    }
}
