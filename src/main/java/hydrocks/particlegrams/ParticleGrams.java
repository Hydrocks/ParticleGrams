package hydrocks.particlegrams;

import hydrocks.particlegrams.core.storage.ConfigData;
import hydrocks.particlegrams.core.storage.ConfigLoader;
import hydrocks.particlegrams.core.storage.ConfigUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDate;
import java.time.LocalTime;

public final class ParticleGrams extends JavaPlugin {
    public static LocalDate nowDate;
    public static LocalTime nowTime;

    public static String pluginVersion = "1.0.0";
    public static String pluginAuthor = "Hydrocks";

    public static ParticleGrams instance;
    public static ConfigUtil util;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        new ConfigLoader();
        ConfigData.loadConfigData();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
