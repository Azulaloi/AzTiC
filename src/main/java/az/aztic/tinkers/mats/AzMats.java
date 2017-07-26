package az.aztic.tinkers.mats;

import az.aztic.AzTiC;
import az.aztic.util.AzUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import scala.xml.PrettyPrinter;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.events.MaterialEvent;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import static az.aztic.AzTiC.proxy;
import static slimeknights.tconstruct.library.utils.HarvestLevels.COBALT;

/**
 * Created by Azulaloi on 7/25/2017
 */
@Mod.EventBusSubscriber(modid = AzTiC.MODID)
public class AzMats {

    public static FluidMolten azFluid;

    public static BlockMolten azFluidMolten;

    public static Item azulAlloyIngot;

    public static MaterialIntegration azulalloyint;

//    public static ItemBlock azFluidItemBlock;

    public static int BLUE = 0x4c90ff;

    @SubscribeEvent
    public static void items(RegistryEvent.Register<Item> event){
//        ItemBlock itemBlock = (ItemBlock) new ItemBlock(azFluidMolten).setRegistryName(azFluidMolten.getRegistryName());
//        azFluidItemBlock = (ItemBlock) new ItemBlock(azFluidMolten).setRegistryName(AzTiC.MODID, "molten_azfluid");
//
//        event.getRegistry().register(azFluidItemBlock);
        Item azulAlloyIngot = new Item().setRegistryName("azulalloyingot").setUnlocalizedName(AzUtil.unlocalizedWithID("azulalloyingot"));

        event.getRegistry().register(azulAlloyIngot);
        proxy.registerItemModel(azulAlloyIngot);
    }

    @SubscribeEvent
    public static void blocks(RegistryEvent.Register<Block> event){
        azFluidMolten = new BlockMolten(azFluid);
        azFluidMolten.setUnlocalizedName(AzUtil.unlocalizedWithID("molten_azulalloy"));
        azFluidMolten.setRegistryName(AzTiC.MODID, "molten_azulalloy");
        event.getRegistry().register(azFluidMolten);
        proxy.initFluidModel(azFluid);
    }

    public static void preInit(){


        azFluid = new FluidMolten("molten_azulalloy", BLUE);
        azFluid.setUnlocalizedName(AzUtil.unlocalizedWithID("molten_azulalloy"));
        FluidRegistry.registerFluid(azFluid);
        FluidRegistry.addBucketForFluid(azFluid);

        Material azulalloymat = new Material("azulalloy", BLUE);
        TinkerRegistry.addMaterialStats(azulalloymat,
                                        new HeadMaterialStats(780, 12.00f, 4.10f, COBALT),
                                        new HandleMaterialStats(0.90f, 100),
                                        new ExtraMaterialStats(300),
                                        new BowMaterialStats(0.75f, 1.3f, 3f));
        azulalloyint = new MaterialIntegration(azulalloymat, azFluid, "AzulAlloy");
        azulalloyint.setRepresentativeItem("azulAlloyIngot");
        azulalloyint.preInit();
//        MaterialEvent.MaterialRegisterEvent
    }

    public static void init(){
//        OreDictionary.registerOre("azulAlloyIngot", new ItemStack(azulAlloyIngot));
        OreDictionary.registerOre("ingotAzulAlloy", azulAlloyIngot);
        azulalloyint.integrateRecipes();
    }
}
