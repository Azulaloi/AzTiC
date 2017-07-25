package az.aztic.util;

import az.aztic.AzTiC;
import az.aztic.Config;
import org.apache.logging.log4j.Level;

/**
 * Created by Azulaloi on 7/20/2017
 */
public class AzUtil {
    public static String unlocalizedWithID(String name){
        return(AzTiC.MODID + "." + name);
    }

    public static void verboseLog(org.apache.logging.log4j.Level level, String message){
        if (Config.verboseLogging){
            AzTiC.logger.log(level, message);
        }
    }

    public static void verboseLog(String message){
        if (Config.verboseLogging){
            AzTiC.logger.log(Level.INFO, message);
        }
    }
}
