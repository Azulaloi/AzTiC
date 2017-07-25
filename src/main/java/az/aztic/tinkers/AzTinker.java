package az.aztic.tinkers;

import az.aztic.AzTiC;
import az.aztic.Config;
import az.aztic.tinkers.tools.Cutlass;
import az.aztic.tinkers.tools.Shears;
import az.aztic.util.AzUtil;
import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.List;

import static az.aztic.AzTiC.proxy;
import static az.aztic.util.AzUtil.unlocalizedWithID;

/**
 * Created by Azulaloi on 7/20/2017
 */

@Mod.EventBusSubscriber(modid = AzTiC.MODID)
public class AzTinker {
    static List<ToolCore> tools = Lists.newLinkedList();
    static List<ToolPart> toolparts = Lists.newLinkedList();

    public static ToolPart fullGuard;

    public static Cutlass cutlass;
    public static Shears shears;

    @SubscribeEvent
    public static void initialize(RegistryEvent.Register<Item> event){
        /* PARTS */

        if (Config.loadCutlass) {
            fullGuard = new ToolPart(Material.VALUE_Ingot * 3);
            fullGuard.setUnlocalizedName(unlocalizedWithID("fullguard"));
            fullGuard.setRegistryName("fullguard");
            event.getRegistry().register(fullGuard);
            TinkerRegistry.registerToolPart(fullGuard);
            proxy.registerToolPartModel(fullGuard);
            toolparts.add(fullGuard);
        }

        /* END PARTS */

        /* TOOLS */

        //I'm not sure what order this should be in.
        if (Config.loadCutlass) {
            cutlass = new Cutlass();                            //Instantiate static
            cutlass.setUnlocalizedName(unlocalizedWithID("cutlass"));              //Unlocalized name
            cutlass.setRegistryName("cutlass");                 //Registry name
            event.getRegistry().register(cutlass);              //Register as an item
            proxy.registerToolModel(cutlass);                       //Register item model
            TinkerRegistry.registerToolForgeCrafting(cutlass);  //Register crafting entry (Needs GUI definition in ClientProxy)
            tools.add(cutlass);

            proxy.registerToolModifierModel(TinkerModifiers.modNecrotic);
        }

        if (Config.loadShears) {
            shears = new Shears();
            shears.setUnlocalizedName(unlocalizedWithID("shears"));
            shears.setRegistryName("shears");
            event.getRegistry().register(shears);
            proxy.registerToolModel(shears);
            TinkerRegistry.registerToolStationCrafting(shears);
            tools.add(shears);
        }

        /* END TOOLS */

        for (final ToolPart p : toolparts){
            for (final ToolCore tool : tools){
                for (final PartMaterialType m : tool.getRequiredComponents()){
                    if (m.getPossibleParts().contains(p)){
                        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), p));
                    }
                }
            }
        }
    }
}
