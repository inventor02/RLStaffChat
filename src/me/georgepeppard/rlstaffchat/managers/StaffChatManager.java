package me.georgepeppard.rlstaffchat.managers;

import me.georgepeppard.rlstaffchat.RLStaffChat;
import me.georgepeppard.rlstaffchat.enums.MessageType;
import me.georgepeppard.rlstaffchat.utils.MessageFormatUtil;
import org.bukkit.entity.Player;

public class StaffChatManager {
    private static StaffChatManager instance;

    /**
     * Initializes the StaffChatManager.
     */
    public static void init() {
        instance = new StaffChatManager();
    }

    /**
     * Gets the instance of StaffChatManager.
     *
     * @return me.georgepeppard.rlstaffchat.managers.StaffChatManager
     */
    public static StaffChatManager getInstance() {
        return instance;
    }

    /**
     * Checks to see if a player can see messages in staff chat.
     *
     * @param player The player to check.
     * @return boolean
     */
    public boolean canSeeStaffChat(Player player) {
        return player.hasPermission(MessageType.STAFF_CHAT.getSeePermission());
    }

    /**
     * Checks to see if a player can send messages to staff chat.
     *
     * @param player The player to check.
     * @return boolean
     */
    public boolean canSendToStaffChat(Player player) {
        return player.hasPermission(MessageType.STAFF_CHAT.getSendPermission());
    }

    /**
     * Checks to see if a player can reply directly to messages sent to staff chat.
     *
     * @param player The player to check.
     * @return boolean
     */
    public boolean canReplyToStaffChat(Player player) {
        return player.hasPermission(MessageType.STAFF_CHAT.getReplyPermission());
    }

    /**
     * Checks to see if a player can see messages in staff chat.
     *
     * @param player The player to check.
     * @return boolean
     */
    public boolean canSeeAdminChat(Player player) {
        return player.hasPermission(MessageType.ADMIN_CHAT.getSeePermission());
    }

    /**
     * Checks to see if a player can send messages to staff chat.
     *
     * @param player The player to check.
     * @return boolean
     */
    public boolean canSendToAdminChat(Player player) {
        return player.hasPermission(MessageType.ADMIN_CHAT.getSendPermission());
    }

    /**
     * Checks to see if a player can reply directly to messages sent to staff chat.
     *
     * @param player The player to check.
     * @return boolean
     */
    public boolean canReplyToAdminChat(Player player) {
        return player.hasPermission(MessageType.ADMIN_CHAT.getReplyPermission());
    }

    /**
     * Sends a message in staff chat.
     *
     * @param from The player who sent the message.
     * @param message The message to be sent.
     */
    public void sendStaffChatMessage(Player from, String message) {
        // Iterate through all online players.
        for(Player player : RLStaffChat.getInstance().getServer().getOnlinePlayers()) {
            // Check to see if the player has permission to see staff chat messages, and that they aren't the original sender.
            if(canSeeStaffChat(player) && from != player) {
                player.sendMessage(MessageFormatUtil.formatStaffChatMessage(from, message));
            }
        }

        // Send a copy of the message to the player who sent it.
        from.sendMessage(MessageFormatUtil.formatStaffChatMessage(from, message));
    }

    /**
     * Sends a message reply in staff chat.
     *
     * @param from The player who sent the message.
     * @param to The recipient of the message.
     * @param message The message to be sent.
     */
    public void sendStaffChatMessageReply(Player from, Player to, String message) {
        // Iterate through all online players.
        for(Player player : RLStaffChat.getInstance().getServer().getOnlinePlayers()) {
            // Check to see if the player has permission to see staff chat messages, and that they aren't the original sender or recipient.
            if(canSeeStaffChat(player) && from != player && to != player) {
                player.sendMessage(MessageFormatUtil.formatStaffChatReply(from, to, message));
            }
        }

        // Send the message to the recipient.
        to.sendMessage(MessageFormatUtil.formatStaffChatReply(from, to, message));

        // Send the message to the sender.
        from.sendMessage(MessageFormatUtil.formatStaffChatReply(from, to, message));
    }

    /**
     * Sends a message in admin chat.
     *
     * @param from The player who sent the message.
     * @param message The message to be sent.
     */
    public void sendAdminChatMessage(Player from, String message) {
        // Iterate through all online players.
        for(Player player : RLStaffChat.getInstance().getServer().getOnlinePlayers()) {
            // Check to see if the player has permission to see admin chat messages, and that they aren't the original sender.
            if(canSeeAdminChat(player) && from != player) {
                player.sendMessage(MessageFormatUtil.formatAdminChatMessage(from, message));
            }
        }

        // Send a copy of the message to the player who sent it.
        from.sendMessage(MessageFormatUtil.formatAdminChatMessage(from, message));
    }

    /**
     * Sends a message reply in admin chat.
     *
     * @param from The player who sent the message.
     * @param to The recipient of the message.
     * @param message The message to be sent.
     */
    public void sendAdminChatMessageReply(Player from, Player to, String message) {
        // Iterate through all online players.
        for(Player player : RLStaffChat.getInstance().getServer().getOnlinePlayers()) {
            // Check to see if the player has permission to see admin chat messages, and that they aren't the original sender or recipient.
            if(canSeeAdminChat(player) && from != player && to != player) {
                player.sendMessage(MessageFormatUtil.formatAdminChatReply(from, to, message));
            }
        }

        // Send the message to the recipient.
        to.sendMessage(MessageFormatUtil.formatAdminChatReply(from, to, message));

        // Send the message to the sender.
        from.sendMessage(MessageFormatUtil.formatAdminChatReply(from, to, message));
    }
}
