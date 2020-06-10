package de.erethon.magicxl.player;

import de.erethon.commons.config.DREConfig;
import de.erethon.magicxl.MagicXL;
import de.erethon.magicxl.elements.Element;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class EPlayerData extends DREConfig {

    public static final int CONFIG_VERSION = 4;
    MagicXL plugin = MagicXL.getInstance();


    private Map<Element, Integer> levels = plugin.getElementManager().generateStarting();

    public EPlayerData(File file) {
        super(file, CONFIG_VERSION);

        if (initialize) {
            initialize();
        }
        load();
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {
        config.set("test", levels);
        try {
            config.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
