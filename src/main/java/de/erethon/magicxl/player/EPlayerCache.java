package de.erethon.magicxl.player;

import de.erethon.magicxl.MagicXL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class EPlayerCache {

    MagicXL plugin = MagicXL.getInstance();


    private Set<EPlayer> ePlayers = new HashSet<>();

    public EPlayerCache() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ePlayers.add(new EPlayer(player));
        }
    }

    public Set<EPlayer> getEPlayers() {
        return ePlayers;
    }

    public static File getFile(UUID uuid) {
        return new File(MagicXL.PLAYERS, uuid.toString() + ".yml");
    }

}
