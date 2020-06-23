package me.therealmck.cico.stuff;

// Used to build a Recipe before all the details have been gotten

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RecipeFactory {
    private String name;
    private RecipeCategory category;
    private List<ItemStack> itemsIn = new ArrayList<>();
    private ItemStack itemOut;
    private List<String> commands;
    private int chance;

    public RecipeFactory() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeCategory getCategory() {
        return category;
    }

    public void setCategory(RecipeCategory category) {
        this.category = category;
    }

    public List<ItemStack> getItemsIn() {
        return itemsIn;
    }

    public void setItemsIn(List<ItemStack> itemsIn) {
        this.itemsIn = itemsIn;
    }

    public ItemStack getItemOut() {
        return itemOut;
    }

    public void setItemOut(ItemStack itemOut) {
        this.itemOut = itemOut;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public Recipe build() {
        return new Recipe(name, category, itemsIn, itemOut, commands, chance);
    }
}
