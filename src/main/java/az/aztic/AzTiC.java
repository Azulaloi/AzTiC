package az.aztic;

<<<<<<< HEAD
import az.aztic.tinkers.AzTinker;
import net.minecraftforge.fml.common.Loader;
=======
import az.aztic.proxy.CommonProxy;
>>>>>>> 30bc503... 1.12
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Azulaloi on 7/20/2017
 */

@Mod(modid= AzTiC.MODID, name = AzTiC.MODNAME, version = AzTiC.MODVERSION,
     dependencies = "required-after:tconstruct@[1.12-2.7.1.9,);" +
                    "required-after:mantle@[1.12-1.3.0.16,);")

public class AzTiC {
    public static final String MODID = "aztic";
    public static final String MODNAME = "AzTiC";
    public static final String MODVERSION = "0.0";

    public static final Logger logger = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "az.aztic.proxy.ClientProxy",
                serverSide = "az.aztic.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
		
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
