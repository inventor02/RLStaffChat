package me.georgepeppard.rlstaffchat;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import me.georgepeppard.rlstaffchat.commands.*;
import me.georgepeppard.rlstaffchat.managers.StaffChatManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class RLStaffChat extends JavaPlugin {
    private static RLStaffChat instance = null;

    private File configf;
    private FileConfiguration config;

    @Override
    public void onEnable() {
        getLogger().info("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        getLogger().info("Loading RLStaffChat v" + getDescription().getVersion() + ". Please read the following notices.");
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

        getLogger().info("Initializing configurations...");
        try {
            createFiles();
        } catch(Exception e) {
            getLogger().severe("[CFG] Houston, we have a problem (please report to the developer): " + e.getMessage());
        }

        if(getConfig().getBoolean("enable-sentry")) {
            getLogger().info("Initializing error reporting (you're awesome!)...");

            Sentry.init();
            Sentry.getContext().addExtra("minecraft-server-version", getServer().getVersion());
            Sentry.getContext().addExtra("plugin-version", getDescription().getVersion());
        } else {
            getLogger().info("Skipping error reporting initialization. Please consider enabling this in the config.yml, all we collect is the error itself, your Minecraft server version and the plugin version.");
        }

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

        if(getConfig().getBoolean("enable-admin-chat")) {
            new AdminChatCommand(instance);
            new AdminChatReplyCommand(instance);
        }
    }

    private void createFiles() {
        configf = new File(getDataFolder(), "config.yml");

        if(!configf.exists()) {
            getLogger().info("[CFG] config.yml not found - never fear, Mr Java is here! Creating.");

            configf.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        config = new YamlConfiguration();

        try {
            getLogger().info("[CFG] Awesome, we found the config.yml. Loading.");

            config.load(configf);
        } catch(Exception e) {
            getLogger().severe("[CFG] Houston, we have a problem (please report to the developer): " + e.getMessage());
        }
    }
}
