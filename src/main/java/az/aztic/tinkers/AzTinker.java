package az.aztic.tinkers;

import az.aztic.AzTiC;
import az.aztic.tinkers.tools.Cutlass;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.TinkerRegistry;

import static az.aztic.AzTiC.proxy;

/**
 * Created by Azulaloi on 7/20/2017
 */

@Mod.EventBusSubscriber(modid = AzTiC.MODID)
public class AzTinker {
    public static Cutlass cutlass;

    @SubscribeEvent
    public static void initialize(RegistryEvent.Register<Item> event){
        /* TOOLS */

        //I'm not sure what order this should be in.
        cutlass = new Cutlass();                        //Instantiate static
        cutlass.setUnlocalizedName("cutlass");          //Unlocalized name
        cutlass.setRegistryName("cutlass");             //Registry name
        event.getRegistry().register(cutlass);          //Register as an item
        proxy.registerModel(cutlass);                   //Register item model
        TinkerRegistry.registerToolForgeCrafting(cutlass);

        /* END TOOLS */
    }
}
