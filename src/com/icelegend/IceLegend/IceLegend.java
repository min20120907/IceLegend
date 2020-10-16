package com.icelegend.IceLegend;
import org.bukkit.plugin.java.JavaPlugin;

public class IceLegend extends JavaPlugin{
    @Override
    public void onEnable() {
        // Register our command "kit" (set an instance of your command class as executor)
        this.getCommand("ice").setExecutor(new CommandIceLegend());
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
