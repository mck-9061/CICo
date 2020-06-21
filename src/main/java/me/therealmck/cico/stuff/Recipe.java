package me.therealmck.cico.stuff;

import jdk.internal.jline.internal.Nullable;
import me.therealmck.cico.Main;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private RecipeCategory category;
    private List<ItemStack> itemsIn = new ArrayList<>();
    private ItemStack itemOut;
    private List<String> commands;
    private int chance;

    public Recipe(RecipeCategory category, String name) {
        this.name = name;
        this.category = category;

        ConfigurationSection section = Main.cicoConfig.getConfigurationSection(category.getName()+".recipes."+name);

        this.itemOut = null;
        try {
            this.itemOut = section.getItemStack("output-item");
        } catch (Exception e) {
            this.itemOut = null;
        }

        this.commands = section.getStringList("output-commands");
        this.chance = section.getInt("chance");

        ConfigurationSection itemsIn = section.getConfigurationSection("input-items");

        for (String key : itemsIn.getKeys(false)) {
            this.itemsIn.add(itemsIn.getItemStack(key));
        }
    }

    public String getName() {
        return name;
    }

    public RecipeCategory getCategory() {
        return category;
    }

    public List<ItemStack> getItemsIn() {
        return itemsIn;
    }

    public @Nullable ItemStack getItemOut() {
        return itemOut;
    }

    public List<String> getCommands() {
        return commands;
    }

    public int getChance() {
        return chance;
    }
}
