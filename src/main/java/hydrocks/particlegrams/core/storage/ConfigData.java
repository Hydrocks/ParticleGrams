package hydrocks.hydroac.config;

import hydrocks.hydroac.methods.FetchMethods;
import hydrocks.hydroac.methods.Math;
import org.bukkit.Bukkit;
import static hydrocks.hydroac.config.ConfigLoader.configFile;
import static hydrocks.hydroac.config.ConfigLoader.configFileData;

public class ConfigData {
    public static String staffPermissions = "rank.helper";
    public static String reloadPermission = "hac.reload.use";
    public static String flagNotification = "hac.flag.see";
    public static String testKAPermission = "rank.mod";
    public static int minSpeedFlags = 3;
    public static int speedFlagsToBan = 5;
    public static int speedInterval = 3;
    public static int cpsFlag = 18;
    public static int minReachFlags = 2;
    public static int reachInterval = 2;
    public static double minReachAmount = 4;
    public static double maxReachAmount = 8;
    public static boolean cancelReachHit = false;

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
                flagNotification = configFile.getConfig().getString("flag notifications");
                testKAPermission = configFile.getConfig().getString("test kill-aura permission");

                // Speed
                minSpeedFlags = FetchMethods.getIntFromString(configFile.getConfig().getString("min speed flags"));
                speedFlagsToBan = FetchMethods.getIntFromString(configFile.getConfig().getString("speed flags to ban"));
                speedInterval = FetchMethods.getIntFromString(configFile.getConfig().getString("speed interval"));

                // CPS
                cpsFlag = FetchMethods.getIntFromString(configFile.getConfig().getString("cps to flag"));

                // Reach
                minReachFlags = FetchMethods.getIntFromString(configFile.getConfig().getString("min reach flags"));
                reachInterval = FetchMethods.getIntFromString(configFile.getConfig().getString("reach check interval"));
                minReachAmount = FetchMethods.getDoubleFromString(configFile.getConfig().getString("min reach amount"));
                maxReachAmount = FetchMethods.getDoubleFromString(configFile.getConfig().getString("max reach amount"));
                cancelReachHit = FetchMethods.getBooleanFromString(configFile.getConfig().getString("cancel reach hit"));

            } catch (Exception ignore) {
            }
        }
    }
}
