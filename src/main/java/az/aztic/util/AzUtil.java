package az.aztic.util;

import az.aztic.AzTiC;

/**
 * Created by Azulaloi on 7/20/2017
 */
public class AzUtil {
    public static String unlocalizedWithID(String name){
        return(AzTiC.MODID + "." + name);
    }
}
