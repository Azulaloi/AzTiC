package az.AzTiC;

import az.AzTiC.tinkers.AzTinker;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Azulaloi on 7/18/2017.
 */
@Mod(modid= AzTiC.MODID, name = AzTiC.MODNAME, version = AzTiC.MODVERSION, useMetadata = false)
public class AzTiC {
    public static final String MODID = "aztic";
    public static final String MODNAME = "AzTiC";
    public static final String MODVERSION = "0.0";

    public static final Logger logger = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "az.AzTiC.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        if (Loader.isModLoaded("tconstruct")){
            AzTinker.preInit(event);
        }

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        if (Loader.isModLoaded("tconstruct")){
            AzTinker.init(event);
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        if (Loader.isModLoaded("tconstruct")){
            AzTinker.postInit(event);
        }
    }


}
