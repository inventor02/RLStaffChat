package me.georgepeppard.rlstaffchat.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageFormatUtil {
    public static String formatInfoMessage(String message) {
        return ChatColor.WHITE + "" + ChatColor.BOLD + "RLStaffChat " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + ">> " + ChatColor.GRAY + message;
    }

    public static String formatStaffChatMessage(Player from, String message) {
        return ChatColor.RED + "" + ChatColor.BOLD + "[STAFF] " + ChatColor.BOLD + from.getDisplayName() + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + " >> " + ChatColor.WHITE + message;
    }

    public static String formatStaffChatReply(Player from, Player to, String message) {
        return ChatColor.RED + "" + ChatColor.BOLD + "[STAFF] " + ChatColor.BOLD + from.getDisplayName() + ChatColor.GRAY + " -> " + ChatColor.BOLD + to.getDisplayName() + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + " >> " + ChatColor.WHITE + message;
    }

    public static String formatAdminChatMessage(Player from, String message) {
        return ChatColor.DARK_RED + "" + ChatColor.BOLD + "[ADMIN] " + ChatColor.BOLD + from.getDisplayName() + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + " >> " + ChatColor.WHITE + message;
    }

    public static String formatAdminChatReply(Player from, Player to, String message) {
        return ChatColor.DARK_RED + "" + ChatColor.BOLD + "[ADMIN] " + ChatColor.BOLD + from.getDisplayName() + ChatColor.GRAY + " -> " + ChatColor.BOLD + to.getDisplayName() + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + " >> " + ChatColor.WHITE + message;
    }
}
