package com.github.sigureruri.configitem.command

import com.github.sigureruri.configitem.ConfigItem
import com.github.sigureruri.configitem.message.command.CommandUtil
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class ConfigItemCommand : TabExecutor {



    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        val player: Player
        if (sender is Player) {
            player = sender;
        } else {
            sender.sendMessage(CommandUtil.CONSOLE)
            return true;
        }

        val subCommand: String = if (args.isEmpty()) "" else args[0]

        if (subCommandMap[subCommand] != null) {
            if (player.hasPermission("configitem.command.$subCommand")) {
                subCommandMap[subCommand]?.onCommand(sender, command, label, args)
            } else {
                sendPermissionMessageToPlayer(player)
            }
            return true
        }

        sendUsageToPlayer(player)
        return true;
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): MutableList<String> {

        val player: Player
        if (sender is Player) {
            player = sender
        } else {
            return arrayListOf()
        }

        val list = arrayListOf<String>()

        if (args.size == 1) {
            subCommandMap.forEach {
                if (player.hasPermission("configitem.command.$it")) {
                    if (args[0].isEmpty()) {
                        list.add(it.key)
                    } else {
                        if (it.key.startsWith(args[0].toLowerCase())) list.add(it.key)
                    }
                }
            }
        } else if (args.size == 2) {
            if (args[0].equals("get", true)
                    || args[0].equals("give", true)
                    || args[0].equals("remove", true)) {
                ConfigItem.pluginConfig.getKeys()?.forEach {
                    if (player.hasPermission("configitem.command.$it")) {
                        if (args[1].isEmpty()) {
                            list.add(it)
                        } else {
                            if (it.startsWith(args[1].toLowerCase())) list.add(it)
                        }
                    }
                }
            } else if (args[0].equals("put", true)) {
                // TODO この辺の処理もどうにかする
                if (player.hasPermission("configitem.command.put")) {
                    if (args[1].isEmpty()) {
                        list.add("mainhand")
                    } else {
                        if ("mainhand".startsWith(args[1].toLowerCase())) list.add("mainhand")
                    }
                }
            }
        }

        return list
    }

    companion object {

        // SubCommandの一覧
        private val subCommandMap = hashMapOf(
                "put" to PutCommand()
                ,"get" to GetCommand()
                ,"give" to GiveCommand()
                ,"remove" to RemoveCommand())

        fun sendUsageToPlayer(player: Player) {

            // TODO Permissionごとに対応させる
            if (player.isOp) player.sendMessage(CommandUtil.USAGE)
            else player.sendMessage(CommandUtil.PERMISSION_MESSAGE)

        }
        fun sendPermissionMessageToPlayer(player: Player) {
            player.sendMessage(CommandUtil.PERMISSION_MESSAGE)
        }
    }

}
