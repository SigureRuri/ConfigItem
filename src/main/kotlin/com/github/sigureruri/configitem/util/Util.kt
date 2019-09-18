package com.github.sigureruri.configitem.util

import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Util {

    companion object {
        fun addItemToPlayer(player: Player, item: ItemStack) {
            if (player.inventory.firstEmpty() == -1) {
                player.world.dropItem(player.location, item)
            } else {
                player.inventory.addItem(item)
            }
        }
    }

}
