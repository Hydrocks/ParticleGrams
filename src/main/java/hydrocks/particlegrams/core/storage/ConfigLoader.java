package hydrocks.hydroac.config;


import hydrocks.hydroac.JudgementAC;

import java.util.List;

public class ConfigLoader {
    public static ConfigUtil configFile;
    public static List<String> configFileComments = List.of(
            "Configuration for Judgement",
            "",
            "Version: " + JudgementAC.pluginVersion,
            "Author: " + JudgementAC.pluginAuthor + "\n",
            "> Configurable settings for the plugin < \n",
            "Permission for a player to be parsed as a staff member"
    );

    public static List<String> configFileData = List.of(
            "%staff permission:rank.helper",
            "%reload permission:hac.reload.use",
            "%flag notifications:hac.flag.see",
            "%test kill-aura permission:rank.mod",
            "%min speed flags:3",
            "%speed flags to ban:5",
            "%speed interval:3",
            "%cps to flag:18",
            "%min reach flags:2",
            "%reach check interval:2",
            "%min reach amount:4.0",
            "%max reach amount:8.0",
            "%cancel reach hit:false"
    );



    /**
     * Loads the main Config File.
     */
    public ConfigLoader() {
        configFile = new ConfigUtil("plugins/JudgementAC/", false, null, "Judgement-Config");
        this.doComments();
        configFile.save();
        this.loadDefaults();
    }

    private void doComments() {
        if (configFile.getConfig().getInlineComments("staff permission").isEmpty()) configFile.getConfig().setInlineComments("staff permission", List.of("Default: rank.helper\n"));
        if (configFile.getConfig().getComments("staff permission").isEmpty()) configFile.getConfig().setComments("staff permission", configFileComments);

        if (configFile.getConfig().getInlineComments("reload permission").isEmpty()) configFile.getConfig().setInlineComments("reload permission", List.of("Default: hac.reload.use\n"));
        if (configFile.getConfig().getComments("reload permission").isEmpty()) configFile.getConfig().setComments("reload permission", List.of(
                "Permission required to perform /judgement reload"
        ));

        if (configFile.getConfig().getInlineComments("flag notifications").isEmpty()) configFile.getConfig().setInlineComments("flag notifications", List.of("Default: hac.flag.see\n"));
        if (configFile.getConfig().getComments("flag notifications").isEmpty()) configFile.getConfig().setComments("flag notifications", List.of(
                "Permission required to see Judgement flags"
        ));

        if (configFile.getConfig().getInlineComments("test kill-aura permission").isEmpty()) configFile.getConfig().setInlineComments("test kill-aura permission", List.of("Default: rank.mod\n"));
        if (configFile.getConfig().getComments("test kill-aura permission").isEmpty()) configFile.getConfig().setComments("test kill-aura permission", List.of(
                "Permission required to perform /testka <player>"
        ));

        // Speed
        if (configFile.getConfig().getInlineComments("min speed flags").isEmpty()) configFile.getConfig().setInlineComments("min speed flags", List.of("Default: 3\n"));
        if (configFile.getConfig().getComments("min speed flags").isEmpty()) configFile.getConfig().setComments("min speed flags", List.of(
                "Amount of Speed flags required to flag online staff"
        ));
        if (configFile.getConfig().getInlineComments("speed flags to ban").isEmpty()) configFile.getConfig().setInlineComments("speed flags to ban", List.of("Default: 5\n"));
        if (configFile.getConfig().getComments("speed flags to ban").isEmpty()) configFile.getConfig().setComments("speed flags to ban", List.of(
                "Amount of flags required to get the player banned."
        ));
        if (configFile.getConfig().getInlineComments("speed interval").isEmpty()) configFile.getConfig().setInlineComments("speed interval", List.of("Default: 3\n"));
        if (configFile.getConfig().getComments("speed interval").isEmpty()) configFile.getConfig().setComments("speed interval", List.of(
                "Interval in seconds between speed checks for a player to get banned."
        ));

        // CPS
        if (configFile.getConfig().getInlineComments("cps to flag").isEmpty()) configFile.getConfig().setInlineComments("cps to flag", List.of("Default: 18\n"));
        if (configFile.getConfig().getComments("cps to flag").isEmpty()) configFile.getConfig().setComments("cps to flag", List.of(
                "Minimum CPS to flag online staff"
        ));

        // Reach
        if (configFile.getConfig().getInlineComments("min reach flags").isEmpty()) configFile.getConfig().setInlineComments("min reach flags", List.of("Default: 2\n"));
        if (configFile.getConfig().getComments("min reach flags").isEmpty()) configFile.getConfig().setComments("min reach flags", List.of(
                "Amount of Reach flags required to flag online staff"
        ));
        if (configFile.getConfig().getInlineComments("reach check interval").isEmpty()) configFile.getConfig().setInlineComments("reach check interval", List.of("Default: 2\n"));
        if (configFile.getConfig().getComments("reach check interval").isEmpty()) configFile.getConfig().setComments("reach check interval", List.of(
                "Seconds between checking reach flags"
        ));

        if (configFile.getConfig().getInlineComments("min reach amount").isEmpty()) configFile.getConfig().setInlineComments("min reach amount", List.of("Default: 4.0"));
        if (configFile.getConfig().getComments("min reach amount").isEmpty()) configFile.getConfig().setComments("min reach amount", List.of(
                "Minimum and Maximum distance to flag reach"
        ));
        if (configFile.getConfig().getInlineComments("max reach amount").isEmpty()) configFile.getConfig().setInlineComments("max reach amount", List.of("Default: 8.0\n"));

        if (configFile.getConfig().getInlineComments("cancel reach hit").isEmpty()) configFile.getConfig().setInlineComments("cancel reach hit", List.of("Default: false\n"));
        if (configFile.getConfig().getComments("cancel reach hit").isEmpty()) configFile.getConfig().setComments("cancel reach hit", List.of(
                "Cancels the damage event If the hit is flagged"
        ));

    }


    /**
     * Loads the defaults for the config file.
     */
    private void loadDefaults() {
        if (configFile != null) {
            // Set the config comments

            for (String s : configFileData) {
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
