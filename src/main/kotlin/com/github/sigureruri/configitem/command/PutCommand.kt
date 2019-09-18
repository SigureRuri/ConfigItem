package com.github.sigureruri.configitem.command

import com.github.sigureruri.configitem.ConfigItem
import com.github.sigureruri.configitem.message.command.PutCommand
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class PutCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        val player: Player
        if (sender is Player) {
            player = sender;
        } else {
            return false
        }

        val subCommand1 = if (args.size <= 1) "" else args[1]

        if (subCommand1.equals("MainHand", true) && args.size == 2) {

            // MainHandにアイテムを持っていれば
            if (player.inventory.itemInMainHand.type != Material.AIR) {
                ConfigItem.pluginConfig.addItem(player.inventory.itemInMainHand)
                player.sendMessage(PutCommand.SAVE)
                return true
            }

            // 手に何も所持していない状態
            player.sendMessage(PutCommand.DONT_HAVE_ITEM_IN_MAIN_HAND)
            return false
        }

        ConfigItemCommand.sendUsageToPlayer(player)
        return false
    }

}
