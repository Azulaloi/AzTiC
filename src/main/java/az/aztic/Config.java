package az.aztic;

import az.aztic.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.io.File;

/**
 * Created by Azulaloi on 7/21/2017
 */
public class Config {
    public static boolean loadCutlass = true;
    public static boolean loadShears = true;

    public static void initConfig(){
        Configuration config = CommonProxy.config;
        try{
            config.load();
            readConfig(config);
        } catch (Exception exception) {
            AzTiC.logger.log(Level.ERROR, "PROBLEMS OVER HERE", exception);
        } finally {
            if (config.hasChanged()){
                config.save();
            }
        }
    }

    private static void readConfig(Configuration config){
        config.addCustomCategoryComment("Tools", "I love you");
        loadCutlass = config.getBoolean("Load Cutlass", "Tools", loadCutlass, "Set to false to disable the Cutlass.");
        loadShears = config.getBoolean("Load Shears", "Tools", loadShears, "Set to false to disable the Shears.");

        if (!loadCutlass && !loadShears) {AzTiC.logger.log(Level.WARN, "All AzTiC content is disabled in the config!");}
    }
}
