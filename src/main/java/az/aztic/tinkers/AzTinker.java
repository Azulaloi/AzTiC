package az.aztic.tinkers;

import az.aztic.AzTiC;
import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;

import java.util.List;


/**
 * Created by Azulaloi on 7/18/2017.
 */
@Mod.EventBusSubscriber(modid = AzTiC.MODID)
public class AzTinker {
    static List<ToolCore> tools = Lists.newLinkedList();
    static List<ToolPart> toolparts = Lists.newLinkedList();
//    static List<IModifier> modifiers = Lists.newLinkedList();
//    static List<Pair<Item, ToolPart>> toolPartPatterns = Lists.newLinkedList();

//    public static ToolCore assets.aztic.textures.items.cutlass; //I am dumb
    public static Cutlass cutlass;
    public static ToolPart fullGuard;

    public static void preInit(FMLPreInitializationEvent event){
    }


    public static void pseudoInit(){
        // 1.11 method

        fullGuard = new ToolPart(Material.VALUE_Ingot * 3);
        fullGuard.setUnlocalizedName("fullguard");
        fullGuard.setRegistryName("fullguard");
        GameRegistry.register(fullGuard); //Does tinkers need it to be done like this?
        TinkerRegistry.registerToolPart(fullGuard);
        //Register model
        toolparts.add(fullGuard);


        cutlass = new Cutlass();
        cutlass.setUnlocalizedName("cutlass");
        cutlass.setRegistryName("cutlass");
        GameRegistry.register(cutlass);
        TinkerRegistry.registerToolForgeCrafting(cutlass);
//        if (aztic.proxy instanceof ClientProxy){
////            ModelRegisterUtil.registerToolModel(tool);
////            ((ClientProxy) aztic.proxy).registerModel(assets.aztic.textures.items.cutlass);
//        }
        AzTiC.proxy.registerModel(cutlass);
        tools.add(cutlass);
    }

    public static void init(FMLInitializationEvent event){

    }
    public static void postInit(FMLPostInitializationEvent event){
    }


    @SubscribeEvent
    public static void magnetar(RegistryEvent.Register<Item> e){ //This is how it has to be done in 1.12, so I'm keeping it for when I update
//        fullGuard = new ToolPart(Material.VALUE_Ingot * 3);
//        fullGuard.setUnlocalizedName("fullguard");
//        fullGuard.setRegistryName("fullguard");
//        e.getRegistry().register(fullGuard); //Does tinkers need it to be done like this?
//        TinkerRegistry.registerToolPart(fullGuard);
//        //Register model
//        toolparts.add(fullGuard);

//        assets.aztic.textures.items.cutlass = new Cutlass();
//        assets.aztic.textures.items.cutlass.setUnlocalizedName("assets.aztic.textures.items.cutlass");
//        assets.aztic.textures.items.cutlass.setRegistryName("assets.aztic.textures.items.cutlass");
//        e.getRegistry().register(assets.aztic.textures.items.cutlass);
//        TinkerRegistry.registerToolForgeCrafting(assets.aztic.textures.items.cutlass);
//        tools.add(assets.aztic.textures.items.cutlass);
//        Register model

//        for (final ToolPart p : toolparts){
//            for (final ToolCore tool : tools){
//                for (final PartMaterialType m : tool.getRequiredComponents()){
//                    if (m.getPossibleParts().contains(p)){
//                        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), p));
//                    }
//                }
//            }
//        }
    }
}
