package az.aztic;

import az.aztic.tinkers.AzTinker;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.tools.ToolCore;

/**
 * Created by Azulaloi on 7/20/2017.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerModel(ToolCore tool){
        ModelRegisterUtil.registerToolModel(tool);
    }

    @Override
    public void tinkerGui(){
        ToolBuildGuiInfo cutlassInfo = new ToolBuildGuiInfo(AzTinker.cutlass);
        cutlassInfo.addSlotPosition(33 - 20, 42 + 20);
        cutlassInfo.addSlotPosition(33 + 20, 42 - 20);
        cutlassInfo.addSlotPosition(33, 42);
        TinkerRegistryClient.addToolBuilding(cutlassInfo);
    }
}
