package az.aztic.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;

/**
 * Created by Azulaloi on 7/20/2017
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event){

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
