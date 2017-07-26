package az.aztic.tinkers.mats;

import az.aztic.AzTiC;
import az.aztic.util.AzUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import static az.aztic.AzTiC.proxy;

/**
 * Created by Azulaloi on 7/25/2017
 */
@Mod.EventBusSubscriber(modid = AzTiC.MODID)
public class AzMats {

    public static FluidMolten azFluid;

    public static BlockMolten azFluidMolten;

//    public static ItemBlock azFluidItemBlock;

    public static int BLUE = 0x4c90ff;

    @SubscribeEvent
    public static void items(RegistryEvent.Register<Item> event){
//        ItemBlock itemBlock = (ItemBlock) new ItemBlock(azFluidMolten).setRegistryName(azFluidMolten.getRegistryName());
//        azFluidItemBlock = (ItemBlock) new ItemBlock(azFluidMolten).setRegistryName(AzTiC.MODID, "molten_azfluid");
//
//        event.getRegistry().register(azFluidItemBlock);
    }

    @SubscribeEvent
    public static void blocks(RegistryEvent.Register<Block> event){
        azFluidMolten = new BlockMolten(azFluid);
        azFluidMolten.setUnlocalizedName(AzUtil.unlocalizedWithID("molten_azfluid"));
        azFluidMolten.setRegistryName(AzTiC.MODID, "molten_azfluid");
        event.getRegistry().register(azFluidMolten);
        proxy.initFluidModel(azFluid);
    }

    public static void preInit(){
        azFluid = new FluidMolten("azfluid", BLUE);
        azFluid.setUnlocalizedName(AzUtil.unlocalizedWithID("azfluid"));
        FluidRegistry.registerFluid(azFluid);
    }
}
