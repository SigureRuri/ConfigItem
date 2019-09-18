package com.github.sigureruri.configitem.command

import com.github.sigureruri.configitem.ConfigItem
import com.github.sigureruri.configitem.message.command.GiveCommand
import com.github.sigureruri.configitem.util.Util
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GiveCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        val player: Player
        if (sender is Player) {
            player = sender;
        } else {
            return false
        }

        val subCommand1 = if (args.size <= 1) "" else args[1]

        if (ConfigItem.pluginConfig.itemExists(subCommand1)) {
            Util.addItemToPlayer(player, ConfigItem.pluginConfig.getItem(subCommand1))
            player.playSound(player.location, Sound.ENTITY_ITEM_PICKUP, 1.toFloat(), 1.toFloat())
            return true
        } else {
            player.sendMessage(GiveCommand.ITEM_NOT_FOUND)
            return false;
        }

    }

}
