package az.aztic.proxy;

import az.aztic.tinkers.AzTinker;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;

/**
 * Created by Azulaloi on 7/20/2017
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
        toolBuildGui();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }

    public void toolBuildGui(){
        //Cutlass
        ToolBuildGuiInfo cutlassInfo = new ToolBuildGuiInfo(AzTinker.cutlass);
        cutlassInfo.addSlotPosition(33 - 20, 42 + 20);
        cutlassInfo.addSlotPosition(33 + 20, 42 - 20);
        cutlassInfo.addSlotPosition(33, 42);
        TinkerRegistryClient.addToolBuilding(cutlassInfo);
        //End Cutlass
    }

    @Override
    public void registerToolModel(ToolCore tool){
        ModelRegisterUtil.registerToolModel(tool);
    }

    @Override
    public void registerToolPartModel(ToolPart part){
        ModelRegisterUtil.registerPartModel(part);
    }
}
