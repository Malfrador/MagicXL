package de.erethon.magicxl.commands;

import de.erethon.commons.chat.MessageUtil;
import de.erethon.commons.command.DRECommand;
import de.erethon.magicxl.skills.SkillLoader;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

public class LoadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            new SkillLoader().loadSkill("test");
            MessageUtil.log("Success!");
            return true;
        } catch (IOException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return false;
        }
    }
}
