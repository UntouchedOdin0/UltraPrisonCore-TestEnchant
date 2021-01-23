package me.drawethree.ultraprisontestenchant;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class of our plugin. Before creating a plugin, please make sure you have UltraPrisonCore and spigot in your classpath!
 */
public final class UltraPrisonTestEnchant extends JavaPlugin {

    private TestEnchant enchant;

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

        //Register it
        this.enchant.register();

        //You are done. Have fun with your custom enchants! :)

    }

    @Override
    public void onDisable() {
        //You do not have to unregister the enchant. UltraPrisonCore will handle that for you :)
    }
}
