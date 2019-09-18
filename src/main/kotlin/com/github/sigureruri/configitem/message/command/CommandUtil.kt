package com.github.sigureruri.configitem.message.command

import org.bukkit.ChatColor

object CommandUtil {

    val CONSOLE = "${ChatColor.RED}" + "このコマンドはコンソールからの使用はできません。"

    val USAGE = "${ChatColor.GOLD}" + "/configitem" +
            "${ChatColor.WHITE}" + " - " +
            "${ChatColor.AQUA}" + "Helpを表示します。" +
            "\n" +
            "${ChatColor.GOLD}" + "/configitem put mainhand" +
            "${ChatColor.WHITE}" + " - " +
            "${ChatColor.AQUA}" + "MainHandに所持しているアイテムをConfigに書き込みます。" +
            "\n" +
            "${ChatColor.GOLD}" + "/configitem get <name>" +
            "${ChatColor.WHITE}" + " - " +
            "${ChatColor.AQUA}" + "指定した名前のアイテムのItemStackを表示します。" +
            "\n" +
            "${ChatColor.GOLD}" + "/configitem give <name>" +
            "${ChatColor.WHITE}" + " - " +
            "${ChatColor.AQUA}" + "指定した名前のアイテムを入手します。"

    val PERMISSION_MESSAGE = "${ChatColor.RED}" + "You don't have permission!"

}
