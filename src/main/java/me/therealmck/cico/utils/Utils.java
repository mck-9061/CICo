package me.therealmck.cico.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Utils {
    public ItemStack newItemWithNameAndLore(Material material, int amount, String name, List<String> lore, short colour) {
        ItemStack item = new ItemStack(material, amount, colour);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
