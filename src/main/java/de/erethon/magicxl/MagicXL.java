package de.erethon.magicxl;

import de.erethon.commons.chat.MessageUtil;
import de.erethon.commons.compatibility.Internals;
import de.erethon.commons.javaplugin.DREPlugin;
import de.erethon.commons.javaplugin.DREPluginSettings;
import de.erethon.magicxl.commands.LoadCommand;
import de.erethon.magicxl.elements.ElementManager;
import de.erethon.magicxl.player.EPlayerCache;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class MagicXL extends DREPlugin {

    public static File PLAYERS;
    public static File COMPILED;

    private static MagicXL plugin;
    private ElementManager elementManager;
    private EPlayerCache playerCache;

    public MagicXL() {
        settings = DREPluginSettings.builder()
                .spigot(true)
                .economy(true)
                .metrics(true)
                .internals(Internals.v1_13_R2, Internals.v1_14_R1, Internals.v1_15_R1)
                .build();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if (!compat.isSpigot() || !settings.getInternals().contains(compat.getInternals())) {
            MessageUtil.log(this, "&4This plugin requires Spigot 1.13.2-1.15.2 to work. It is not compatible with CraftBukkit and older versions.");
            manager.disablePlugin(this);
            return;
        }
        plugin = this;
        elementManager = new ElementManager();
        playerCache = new EPlayerCache();
        plugin.getCommand("mxl").setExecutor(new LoadCommand());

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        PLAYERS = new File(getDataFolder(), "playerdata");
        if (!PLAYERS.exists()) {
            PLAYERS.mkdir();
        }
        COMPILED = new File(getDataFolder(), "skills/compiled");
        if (!COMPILED.exists()) {
            COMPILED.mkdir();
        }
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);
        HandlerList.unregisterAll(this);
    }

    public static MagicXL getInstance() {
        return plugin;
    }

    public ElementManager getElementManager() {
        return elementManager;
    }

    public EPlayerCache getPlayerCache() {
        return playerCache;
    }
}
