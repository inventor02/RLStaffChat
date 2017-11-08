package me.georgepeppard.rlstaffchat;

import me.georgepeppard.rlstaffchat.commands.*;
import me.georgepeppard.rlstaffchat.managers.StaffChatManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RLStaffChat extends JavaPlugin {
    private static RLStaffChat instance = null;

    @Override
    public void onEnable() {
        getLogger().info("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        getLogger().info("Loading RLStaffChat. Please read the following notices.");
        getLogger().info("Copyright (C) 2017 George Peppard (https://georgepeppard.me/)");
        getLogger().info("This program is free software: you can redistribute it and/or modify");
        getLogger().info("it under the terms of the GNU General Public License as published by");
        getLogger().info("the Free Software Foundation, either version 3 of the License, or");
        getLogger().info("(at your option) any later version.");
        getLogger().info("");
        getLogger().info("This program is distributed in the hope that it will be useful,");
        getLogger().info("but WITHOUT ANY WARRANTY; without even the implied warranty of");
        getLogger().info("MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the");
        getLogger().info("GNU General Public License for more details.");
        getLogger().info("");
        getLogger().info("You should have recieved a copy of the GNU General Public License");
        getLogger().info("with this program. If not, see <https://www.gnu.org/licenses/>.");
        getLogger().info("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");

        instance = this; // Set the instance of the plugin in onEnable, so we use Spigot's version.

        getLogger().info("Initializing StaffChatManager...");
        try {
            StaffChatManager.init();
        } catch(Exception e) {
            getLogger().severe("[SCM] Houston, we have a problem (please report to the developer): " + e.getMessage());
        }

        getLogger().info("Initializing commands...");
        try {
            initCommands();
        } catch(Exception e) {
            getLogger().severe("[CMD] Houston, we have a problem (please report to the developer): " + e.getMessage());
        }
    }

    public static RLStaffChat getInstance() {
        return instance;
    }

    private void initCommands() {
        new InfoCommand(instance);

        new StaffChatCommand(instance);
        new StaffChatReplyCommand(instance);

        new AdminChatCommand(instance);
        new AdminChatReplyCommand(instance);
    }
}
