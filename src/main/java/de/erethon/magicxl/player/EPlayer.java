package de.erethon.magicxl.player;

import de.erethon.magicxl.MagicXL;
import de.erethon.magicxl.elements.Element;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Map;
import java.util.UUID;

public class EPlayer {

    MagicXL plugin = MagicXL.getInstance();

    private Player player;
    private UUID uuid;
    private EPlayerData data;


    public EPlayer(Player player) {
        this.player = player;
        uuid = player.getUniqueId();
        loadPlayerData(EPlayerCache.getFile(uuid));
    }

    public void loadPlayerData(File file) {
        data = new EPlayerData(file);
    }

}
