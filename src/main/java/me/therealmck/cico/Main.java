package me.therealmck.cico;

import me.therealmck.cico.commands.CicoCommand;
import me.therealmck.cico.stuff.RecipeCategory;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    public static File cicoFile;
    public static FileConfiguration cicoConfig;
    public static File langFile;
    public static FileConfiguration langConfig;
    public static Plugin instance;

    public static List<RecipeCategory> currentCategories = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        createCicoConfig();
        createLangConfig();

        getCommand("cico").setExecutor(new CicoCommand());

        for (String key : cicoConfig.getKeys(false)) {
            currentCategories.add(new RecipeCategory(key));
        }

    }

    private void createCicoConfig() {
        cicoFile = new File(getDataFolder(), "recipes.yml");
        if (!cicoFile.exists()) {
            cicoFile.getParentFile().mkdirs();
            saveResource("recipes.yml", false);
        }

        cicoConfig = new YamlConfiguration();
        try {
            cicoConfig.load(cicoFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void saveCicoConfig() {
        try {
            cicoConfig.save(cicoFile);
        } catch (Exception e) {e.printStackTrace();}
    }


    private void createLangConfig() {
        langFile = new File(getDataFolder(), "language.yml");
        if (!langFile.exists()) {
            langFile.getParentFile().mkdirs();
            saveResource("language.yml", false);
        }

        langConfig = new YamlConfiguration();
        try {
            langConfig.load(cicoFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void saveLangConfig() {
        try {
            langConfig.save(langFile);
        } catch (Exception e) {e.printStackTrace();}
    }


}
