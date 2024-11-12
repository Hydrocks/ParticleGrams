package hydrocks.particlegrams.core.storage;

import org.bukkit.Bukkit;

import static hydrocks.particlegrams.core.storage.ConfigLoader.configFile;
public class ConfigData {
    public static String staffPermissions = "rank.mod";
    public static String reloadPermission = "pg.reload";

    /**
     * Loads the Data from the Config
     */
    public static void loadConfigData() {
        new ConfigLoader();

        if (configFile != null) {
            try {
                // Permissions
                staffPermissions = configFile.getConfig().getString("staff permission");
                reloadPermission = configFile.getConfig().getString("reload permission");

            } catch (Exception ignore) {
                Bukkit.getLogger().severe("[PARTICLE-GRAMS] ERROR OCCURRED TRYING TO SET CONFIG");
            }
        }
    }
}
