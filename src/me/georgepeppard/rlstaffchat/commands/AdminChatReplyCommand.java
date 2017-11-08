package me.georgepeppard.rlstaffchat.commands;

import me.georgepeppard.rlstaffchat.enums.MessageType;
import me.georgepeppard.rlstaffchat.managers.StaffChatManager;
import me.georgepeppard.rlstaffchat.utils.MessageFormatUtil;
import me.shawlaf.cmdlib.AbstractCommand;
import me.shawlaf.cmdlib.Arguments;
import me.shawlaf.cmdlib.Sender;
import me.shawlaf.cmdlib.info.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@Command(
        name = "adminreply",
        aliases = {"ar", "acr", "adminchatreply", "achatreply"},
        canBeUsedBy = {Player.class},
        requiredArguments = 2,
        usage = "[player] [message]"
)
public class AdminChatReplyCommand extends AbstractCommand {
    public AdminChatReplyCommand(Plugin plugin) {
        super(plugin);

        this.asynchronous = true;
    }

    @Override
    public String permission() {
        return MessageType.ADMIN_CHAT.getReplyPermission();
    }

    @Override
    public void execute(Sender sender, Arguments arguments) {
        // Check to see if the player actually exists to avoid errors from meanie users.
        if(Bukkit.getPlayer(arguments.get(0)) == null) {
            sender.sendMessage(MessageFormatUtil.formatInfoMessage(ChatColor.RED + "Player not found."));
            return;
        }

        // Get the player to send the reply to.
        Player to = arguments.nextAs(Bukkit::getPlayer);

        // Invoke the StaffChatManager to distribute the message.
        StaffChatManager.getInstance().sendAdminChatMessageReply(sender.castPlayer(), to, arguments.join());
    }
}
