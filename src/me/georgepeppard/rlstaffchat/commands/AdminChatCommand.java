package me.georgepeppard.rlstaffchat.commands;

import me.georgepeppard.rlstaffchat.enums.MessageType;
import me.georgepeppard.rlstaffchat.managers.StaffChatManager;
import me.shawlaf.cmdlib.AbstractCommand;
import me.shawlaf.cmdlib.Arguments;
import me.shawlaf.cmdlib.Sender;
import me.shawlaf.cmdlib.info.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@Command(
        name = "admin",
        aliases = {"a", "ac", "adminchat", "achat"},
        canBeUsedBy = {Player.class},
        requiredArguments = 1,
        usage = "[message]"
)
public class AdminChatCommand extends AbstractCommand {
    public AdminChatCommand(Plugin plugin) {
        super(plugin);

        this.asynchronous = true;
    }

    @Override
    public String permission() {
        return MessageType.ADMIN_CHAT.getSendPermission();
    }

    @Override
    public void execute(Sender sender, Arguments arguments) {
        // Invoke the StaffChatManager to distribute the message.
        StaffChatManager.getInstance().sendAdminChatMessage(sender.castPlayer(), arguments.join());
    }
}
