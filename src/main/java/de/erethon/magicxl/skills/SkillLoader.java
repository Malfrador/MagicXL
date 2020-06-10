package de.erethon.magicxl.skills;

import de.erethon.commons.chat.MessageUtil;
import de.erethon.magicxl.MagicXL;
import org.bukkit.Bukkit;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillLoader {

    MagicXL plugin = MagicXL.getInstance();
    URL[] skillURL;

    public void loadSkills() {
        MessageUtil.log("Loading skill classes...");
    }

    public void loadSkill(String filename) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        File javasrcfile = new File(plugin.getDataFolder() + "/skills/" + filename + ".java");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager( null, null, null );
        Iterable<? extends JavaFileObject> units;
        units = fileManager.getJavaFileObjectsFromFiles( Arrays.asList( javasrcfile ) );
        List<String> options = new ArrayList<>(Arrays.asList("-classpath", plugin.getDataFolder().getParent() + "/MagicXL.jar"));
        MessageUtil.log(options.toString());
        JavaCompiler.CompilationTask task = compiler.getTask( null, fileManager, null, options, null, units );
        task.call();
        File compiled = new File(plugin.getDataFolder() + "/skills/" + filename + ".class");
        compiled.renameTo(new File(plugin.getDataFolder() + "/skills/compiled/de/erethon/magicxl/skills/loaded/" + filename + ".class"));

        URL classUrl;
        classUrl = new URL(plugin.getDataFolder().toURI().toURL() + "skills/compiled/");
        URL[] classUrls = { classUrl };
        URLClassLoader ucl = new URLClassLoader(classUrls);
        MessageUtil.log("URL: " + classUrl.toString());
        Class c = ucl.loadClass("de.erethon.magicxl.skills.loaded." + filename);
    }

}
