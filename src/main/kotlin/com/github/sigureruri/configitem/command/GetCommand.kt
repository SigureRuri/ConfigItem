package com.github.sigureruri.configitem.command

import com.github.sigureruri.configitem.ConfigItem
import com.github.sigureruri.configitem.message.command.GetCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GetCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        val player: Player
        if (sender is Player) {
            player = sender;
        } else {
            return false
        }

        val subCommand1 = if (args.size <= 1) "" else args[1]

        if (ConfigItem.pluginConfig.itemExists(subCommand1)) {
            player.sendMessage(ConfigItem.pluginConfig.getItem(subCommand1).toString())
            return true
        } else {
            player.sendMessage(GetCommand.ITEM_NOT_FOUND)
            return false
        }

    }

}
