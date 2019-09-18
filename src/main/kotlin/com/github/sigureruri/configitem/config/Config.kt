package com.github.sigureruri.configitem.config

import org.bukkit.Material
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin

class Config(private val PLUGIN: Plugin) {

    /** ConfigのFileConfiguration */
    lateinit var config: FileConfiguration

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
        PLUGIN.reloadConfig()
        config = PLUGIN.config;
    }

    fun addItem(itemStack: ItemStack) {

        val path = if (itemStack.hasItemMeta() && itemStack.itemMeta!!.hasDisplayName()) itemStack.itemMeta!!.displayName
                .replace("§", "&")
                .replace(" ", "")
        else itemStack.type.name

        config.set(path, itemStack)
        PLUGIN.saveConfig()
    }

    fun removeItem(name: String) {
        config.set(name, null)
        PLUGIN.saveConfig()
    }

    fun getItem(name: String): ItemStack {
        if (config.getItemStack(name) != null) {
            return config.getItemStack(name)!!
        } else {
            return ItemStack(Material.AIR)
        }
    }

    fun itemExists(name: String): Boolean {
        return config.isItemStack(name)
    }

    fun getKeys(): MutableSet<String> {
        return config.getKeys(false)
    }
}
