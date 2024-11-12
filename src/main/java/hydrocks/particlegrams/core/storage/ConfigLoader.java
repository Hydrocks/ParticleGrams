package hydrocks.particlegrams.core.storage;


import hydrocks.particlegrams.ParticleGrams;

import java.util.List;
import java.util.Map;

public class ConfigLoader {
    public static ConfigUtil configFile;
    public static List<String> configFileComments = List.of(
            "Configuration for Particle-Grams",
            "",
            "Version: " + ParticleGrams.pluginVersion,
            "Author: " + ParticleGrams.pluginAuthor + "\n",
            "> Configurable settings for the plugin < \n",
            "Permission for a player to be parsed as a staff member"
    );

    public static List<Map.Entry<String, List<String>>> configFileData = List.of(
            Map.entry("%staff permission:rank.mod", configFileComments),
            Map.entry("%reload permission:pg.reload", List.of(
                    "Permission required to perform /pg reload"
            ))
    );



    /**
     * Loads the main Config File.
     */
    public ConfigLoader() {
        configFile = new ConfigUtil("plugins/ParticleGrams/", false, null, "PG-Config");
        this.doComments();
        configFile.save();
        this.loadDefaults();
    }

    private void doComments() {
        // Loop through the Config Options
        configFileData.forEach(data -> {
            String key = data.getKey();

            if (key.contains("%")) {
                String[] splitKey = key.split(":");

                final String permissionName = splitKey[0].replaceAll("%", "");
                final String permissionVar = splitKey[1];

                final List<String> permissionDescription = data.getValue();

                // Set the main comment
                if (configFile.getConfig().getInlineComments(permissionName).isEmpty())
                    configFile.getConfig().setInlineComments(permissionName, List.of("Default: " + permissionVar + "\n"));

                // Set the description of the var
                if (configFile.getConfig().getComments(permissionName).isEmpty())
                    configFile.getConfig().setComments(permissionName, permissionDescription);
            }
        });
    }


    /**
     * Loads the defaults for the config file.
     */
    private void loadDefaults() {
        if (configFile != null) {
            // Set the config comments

            for (Map.Entry<String, List<String>> mapData : configFileData) {

                String s = mapData.getKey();

                if (s.contains("%")) {
                    String data = s.split("%")[1];

                    // Get the data from the string and check the config
                    String key = data.split(":")[0];
                    String val = data.split(":")[1];

                    if (!configFile.getConfig().contains(key)) {
                        configFile.getConfig().set(key, val);
                    }
                }
            }

            configFile.save();
        }
    }

}
