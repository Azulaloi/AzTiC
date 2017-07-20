package az.aztic;

import az.aztic.tinkers.AzTinker;
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
@Mod(modid= AzTiC.MODID, name = AzTiC.MODNAME, version = AzTiC.MODVERSION,
        dependencies = "required-after:tconstruct@[1.11.2-2.7.1.505,);"
                + "required-after:mantle@[1.11.2-1.2.0.27,);", useMetadata = false)

public class AzTiC {
    public static final String MODID = "aztic";
    public static final String MODNAME = "AzTiC";
    public static final String MODVERSION = "0.0";

    public static final Logger logger = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "az.aztic.ClientProxy", serverSide = "az.aztic.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        if (Loader.isModLoaded("tconstruct")){
            AzTinker.pseudoInit();
//            AzTinker.preInit(event);
        }

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        if (Loader.isModLoaded("tconstruct")){
//            AzTinker.pseudoInit();
            proxy.tinkerGui();
//            if (proxy instanceof ClientProxy){
//                ((ClientProxy) proxy).tinkerGui(); //buetifial
//            }
//            if (event.getSide() == Side.CLIENT){
//                ClientProxy.tinkerGui();
//            }
//            AzTinker.init(event);
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        if (Loader.isModLoaded("tconstruct")){
//            aztic.proxy.registerModel(assets.aztic.textures.items.cutlass);
//            proxy.tinkerGui();
//            AzTinker.postInit(event);
        }
    }


}
