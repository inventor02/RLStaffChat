package me.georgepeppard.rlstaffchat.commands;

import me.georgepeppard.rlstaffchat.RLStaffChat;
import me.georgepeppard.rlstaffchat.utils.MessageFormatUtil;
import me.shawlaf.cmdlib.AbstractCommand;
import me.shawlaf.cmdlib.Arguments;
import me.shawlaf.cmdlib.Sender;
import me.shawlaf.cmdlib.info.Command;
import org.bukkit.plugin.Plugin;

@Command(
        name = "rlstaffchat"
)
public class InfoCommand extends AbstractCommand {
    public InfoCommand(Plugin plugin) {
        super(plugin);

        asynchronous = true;
    }

    @Override
    public void execute(Sender sender, Arguments arguments) {
        sender.sendMessage(MessageFormatUtil.formatInfoMessage("RLStaffChat v" + RLStaffChat.getInstance().getDescription().getVersion() + " by George Peppard (https://georgepeppard.me/)"));
        sender.sendMessage(MessageFormatUtil.formatInfoMessage("Licensed under the GNU General Public License v3.0"));
        sender.sendMessage(MessageFormatUtil.formatInfoMessage("Uses shawlaf's CommandAPI (which is awesome by the way) under the MIT license: https://github.com/shawlaf/CommandAPI"));
    }
}
