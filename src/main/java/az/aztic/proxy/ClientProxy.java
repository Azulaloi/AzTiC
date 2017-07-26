package az.aztic.proxy;

import az.aztic.AzTiC;
import az.aztic.Config;
import az.aztic.tinkers.AzTinker;
import az.aztic.util.AzUtil;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.shared.FluidsClientProxy;
import slimeknights.tconstruct.tools.TinkerModifiers;
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
        if (Config.loadCutlass) {
            ToolBuildGuiInfo cutlassInfo = new ToolBuildGuiInfo(AzTinker.cutlass);
            cutlassInfo.addSlotPosition(33 - 20, 42 + 20);
            cutlassInfo.addSlotPosition(33 + 20, 42 - 20);
            cutlassInfo.addSlotPosition(33, 42);
            TinkerRegistryClient.addToolBuilding(cutlassInfo);
        }

        if (Config.loadShears) {
            ToolBuildGuiInfo shearsInfo = new ToolBuildGuiInfo(AzTinker.shears);
            shearsInfo.addSlotPosition(33 - 20, 42 + 20);
            shearsInfo.addSlotPosition(33 + 20, 42 - 20);
            shearsInfo.addSlotPosition(33, 42);
            TinkerRegistryClient.addToolBuilding(shearsInfo);
        }
    }

    @Override
    public void registerToolModel(ToolCore tool){
        ModelRegisterUtil.registerToolModel(tool);
    }

    @Override
    public void registerToolPartModel(ToolPart part){
        ModelRegisterUtil.registerPartModel(part);
    }

    @Override
    public void registerToolModifierModel(IModifier mod){
        ModelRegisterUtil.registerModifierModel(mod, new ResourceLocation(AzTiC.MODID, "models/item/modifiers/" + mod.getIdentifier()));
    }

    @Override
    public void initFluidModel(Fluid fluid){
        Block block = fluid.getBlock();
        if (block != null) {
            AzUtil.FluidMappingMischief mapper = new AzUtil.FluidMappingMischief(fluid);
            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }

    @Override
    public void registerItemModel(Item item){
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }
}
