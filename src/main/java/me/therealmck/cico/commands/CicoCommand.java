package me.therealmck.cico.commands;

import me.therealmck.cico.Main;
import me.therealmck.cico.stuff.RecipeCategory;
import me.therealmck.cico.stuff.RecipeFactory;
import me.therealmck.cico.utils.MessageHelper;
import me.therealmck.cico.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CicoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        MessageHelper lang = new MessageHelper();

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command can only be ran as a player.");
            return true;
        }

        if (args.length < 4) {
            return false;
        } else if (args[0].equals("admin") && commandSender.hasPermission("cico.admincraft")) {
            RecipeCategory toAddTo = null;

            for (RecipeCategory category : Main.currentCategories) {
                if (args[1].equals(category.getName())) {
                    toAddTo = category;
                }
            }

            if (toAddTo == null) {
                commandSender.sendMessage(lang.getBadCategory());
                return false;
            }

            int chance = 100;

            try {
                chance = Integer.parseInt(args[2]);
            } catch (Exception e) {
                commandSender.sendMessage(lang.getBadChance());
                chance = 100;
            }

            if (chance > 100 || chance < 0) {
                commandSender.sendMessage(lang.getBadChance());
                chance = 100;
            }


            String result = "";

            List<String> results = Arrays.asList(args);
            results.remove(0);
            results.remove(1);
            results.remove(2);

            for (String st : results) result += st+" ";


            Inventory gui = Bukkit.createInventory((Player) commandSender, 27, lang.getAdminInterfaceName());

            List<Integer> otherSlots = Arrays.asList(4, 11, 15, 22);
            Utils utils = new Utils();

            for (int i = 0; i < 27; i++) {
                if (otherSlots.contains(i)) continue;
                else gui.setItem(i, utils.newItemWithNameAndLore(Material.STAINED_GLASS_PANE, 1, " ", Collections.singletonList(" "), (short) 7));
            }

            gui.setItem(26, utils.newItemWithNameAndLore(Material.CONCRETE, 1, "Confirm", Collections.singletonList(" "), (short) 13));

            RecipeFactory factory = new RecipeFactory();
            factory.setCategory(toAddTo);
            factory.setChance(chance);


            if (result.equals("item")) {
                try {
                    factory.setItemOut(((Player) commandSender).getInventory().getItemInMainHand());
                    factory.setCommands(new ArrayList<>());
                } catch (Exception e) {

                }
            } else {
                factory.setCommands(new ArrayList<>());
                factory.addCommand(result);
                factory.setItemOut(null);
            }

            String latestKey = toAddTo.getRecipes().get(toAddTo.getRecipes().size()).getName();
            int latestN = Integer.parseInt(latestKey.split("-")[1]);

            factory.setName("recipe-"+(latestN+1));

            ((Player) commandSender).openInventory(gui);

            Main.activeFactories.put((Player) commandSender, factory);




        }


        return true;
    }
}
