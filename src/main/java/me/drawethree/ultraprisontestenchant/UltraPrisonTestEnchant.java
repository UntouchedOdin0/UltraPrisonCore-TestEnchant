package me.drawethree.ultraprisontestenchant;

import dev.drawethree.ultraprisoncore.UltraPrisonCore;
import dev.drawethree.ultraprisoncore.enchants.api.UltraPrisonEnchantsAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class of our plugin. Before creating a plugin, please make sure you have UltraPrisonCore and spigot in your classpath!
 */
public final class UltraPrisonTestEnchant extends JavaPlugin {

    private TestEnchant enchant;

    private UltraPrisonEnchantsAPI api;

    @Override
    public void onEnable() {

        //Firstly check if we have UltraPrisonCore loaded

        if (Bukkit.getPluginManager().getPlugin("UltraPrisonCore") == null) {
            this.getLogger().warning("Unable to hook into UltraPrisonCore! Disabling...");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }


        //Create our custom enchant
        this.enchant = new TestEnchant();

        this.api = UltraPrisonCore.getInstance().getEnchants().getApi();

        //Register it
        this.api.registerEnchant(this.enchant);

        //You are done. Have fun with your custom enchants! :)

    }

    @Override
    public void onDisable() {
        // Unregistering of enchant. Not needed, but good to have.
        this.api.unregisterEnchant(this.enchant);
    }
}
