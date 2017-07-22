package az.aztic.proxy;

import az.aztic.AzTiC;
import az.aztic.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;

import java.io.File;

/**
 * Created by Azulaloi on 7/20/2017
 */
public class CommonProxy {
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event){
        File directory = event.getSuggestedConfigurationFile();
        config = new Configuration(new File(directory.getPath()));
        Config.initConfig();

//        Config instantConfig = new Config(AzTiC.MODVERSION);
//        instantConfig.initConfig();
    }

    public void init(FMLInitializationEvent event){

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerToolModel(ToolCore tool){
        //Do nothing, fool!
        //Is this truly better than simply checking the side
        //and calling this function from somewhere else, to avoid
        //this blank function?
    }

    public void registerToolPartModel(ToolPart part){}
}
