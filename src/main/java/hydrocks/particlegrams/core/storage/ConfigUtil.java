package hydrocks.particlegrams.core.storage;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ConfigUtil {
    private final File file;
    private final FileConfiguration config;

    public ConfigUtil(String path, boolean uuid, Player player, String filename) {
        String uID = "";

        if (player != null) {
            uID = player.getUniqueId().toString();
        }

        if (uuid) {
            this.file = new File(path + File.separator + filename, uID + ".yml");
        } else {
            this.file = new File(path + File.separator, filename + ".yml");
        }
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (Exception ignore) {
            Bukkit.getLogger().info("");
        }
    }


    public File getFile() {
        return this.file;
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

}
