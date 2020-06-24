package me.therealmck.cico.listeners;

import me.therealmck.cico.Main;
import me.therealmck.cico.stuff.RecipeFactory;
import me.therealmck.cico.utils.MessageHelper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminInterfaceListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        MessageHelper lang = new MessageHelper();

        if (Main.activeFactories.containsKey((Player) event.getWhoClicked()) && event.getView().getTitle().equals(lang.getAdminInterfaceName())) {
            List<Integer> slotsAllowed = Arrays.asList(4, 11 ,15, 22, 26);

            if (!slotsAllowed.contains(event.getRawSlot())) event.setCancelled(true);
            else if (event.getRawSlot() == 26) {
                List<ItemStack> itemsIn = new ArrayList<>();

                itemsIn.add(event.getView().getTopInventory().getItem(4).clone());
                itemsIn.add(event.getView().getTopInventory().getItem(11).clone());
                itemsIn.add(event.getView().getTopInventory().getItem(15).clone());
                itemsIn.add(event.getView().getTopInventory().getItem(22).clone());

                for (ItemStack item : itemsIn) {
                    if (item == null || item.getType().equals(Material.AIR)) return;
                }

                RecipeFactory factory = Main.activeFactories.get((Player) event.getWhoClicked());

                factory.setItemsIn(itemsIn);

                factory.getCategory().addRecipe(factory.build());

                Main.activeFactories.remove((Player) event.getWhoClicked());
            }
        }
    }
}
