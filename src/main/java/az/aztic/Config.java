package az.aztic;

import az.aztic.proxy.CommonProxy;
import az.aztic.util.AzUtil;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.io.File;

/**
 * Created by Azulaloi on 7/21/2017
 */
public class Config {
//    static String Version = "0.0";
//    static boolean isVersion = true;

    public static boolean loadCutlass = true;
    public static boolean loadShears = true;
    public static boolean verboseLogging = false;

//    public Config(String version){
//        Version = version;
//    }

    public static void initConfig(){
        Configuration config = CommonProxy.config;
        try{
            config.load();
            readConfig(config);
            AzUtil.verboseLog("Config loaded");
        } catch (Exception exception) {
            AzTiC.logger.log(Level.ERROR, "PROBLEMS OVER HERE", exception);
        } finally {
            if (config.hasChanged()){
                config.save();
                AzUtil.verboseLog("Config has changed, saving");
            }
        }
    }

    private static void readConfig(Configuration config){
//        if (!(config.get("Version","Identifier", Version).getString().equals(Version))){
//            //THEN PROBLEMS
//        }

//        config.addCustomCategoryComment("Tools", "Tools");
        loadCutlass = config.getBoolean("Load Cutlass", "Tools", loadCutlass, "Set to false to disable the Cutlass.");
        loadShears = config.getBoolean("Load Shears", "Tools", loadShears, "Set to false to disable the Shears.");

        if (!loadCutlass && !loadShears) {AzTiC.logger.log(Level.WARN, "All AzTiC content is disabled in the config!");}

        verboseLogging = config.getBoolean("Verbose Logging", "Debug", verboseLogging, "Set to true for more log info.");
    }
}
