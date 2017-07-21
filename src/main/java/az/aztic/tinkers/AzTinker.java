package az.aztic.tinkers;

import az.aztic.AzTiC;
import az.aztic.tinkers.tools.Cutlass;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.TinkerRegistry;

/**
 * Created by Azulaloi on 7/20/2017
 */

@Mod.EventBusSubscriber(modid = AzTiC.MODID)
public class AzTinker {
    public static Cutlass cutlass;

    @SubscribeEvent
    public static void initialize(RegistryEvent.Register<Item> event){
        cutlass = new Cutlass();
        cutlass.setUnlocalizedName("cutlass");
        cutlass.setRegistryName("cutlass");
        event.getRegistry().register(cutlass);
        TinkerRegistry.registerTool(cutlass);
    }
}
