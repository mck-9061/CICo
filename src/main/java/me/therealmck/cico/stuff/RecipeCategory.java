package me.therealmck.cico.stuff;

import me.therealmck.cico.Main;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

public class RecipeCategory {
    private String name;
    private List<NPC> npcs = new ArrayList<>();
    private String permission;
    private List<Recipe> recipes = new ArrayList<>();

    public RecipeCategory(String name) {
        this.name = name;
        ConfigurationSection section = Main.cicoConfig.getConfigurationSection(name);
        List<String> npcNames = section.getStringList("NPCs");

        for (NPC npc : CitizensAPI.getNPCRegistry()) {
            if (npcNames.contains(npc.getName())) {
                npcs.add(npc);
            }
        }

        this.permission = section.getString("permission");

        for (String key : section.getConfigurationSection("recipes").getKeys(false)) {
            recipes.add(new Recipe(this, key));
        }
    }

    public String getName() {
        return name;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public String getPermission() {
        return permission;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
