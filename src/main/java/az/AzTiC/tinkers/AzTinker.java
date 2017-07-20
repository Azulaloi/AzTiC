package az.AzTiC.tinkers;

import az.AzTiC.AzTiC;
import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.tuple.Pair;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IPattern;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerMaterials;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.List;
import java.util.Locale;

/**
 * Created by Azulaloi on 7/18/2017.
 */
@Mod.EventBusSubscriber(modid = AzTiC.MODID)
public class AzTinker {
    //"Dear Addon Developers, if you're looking at this super cool and easy to use registry system, you can't use it."
    //You tease.
    static List<ToolCore> tools = Lists.newLinkedList();
    static List<ToolPart> toolparts = Lists.newLinkedList();
//    static List<IModifier> modifiers = Lists.newLinkedList();
//    static List<Pair<Item, ToolPart>> toolPartPatterns = Lists.newLinkedList();

//    public static ToolCore cutlass; //I am dumb
    public static Cutlass cutlass;
    public static ToolPart fullGuard;

    public static void preInit(FMLPreInitializationEvent event){
        /**
        Fun fact: I'm retarded.

         //        Material.UNKNOWN.addStats(new ExtraMaterialStats(350));

//        fullGuard = registerToolPart(new ToolPart(Material.VALUE_Ingot * 3), "full_guard");
        //I'm not sure why I have to do this, since it's already a ToolPart

//        fullGuard.setRegistryName("fullguard");
//        fullGuard.setUnlocalizedName("fullguard");

        fullGuard = new ToolPart(Material.VALUE_Ingot * 3);
        registerItem(fullGuard, "fullguard");
        TinkerRegistry.registerToolPart(fullGuard);
        //Register Model
        toolparts.add(fullGuard);

//        TinkerRegistry.addMaterialStats(TinkerMaterials.iron, new ExtraMaterialStats(250));
//
        for (ToolPart p : toolparts){
            for (ToolCore tool : tools){
                for (PartMaterialType m : tool.getRequiredComponents()){
                    if (m.getPossibleParts().contains(p)){
                        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), p));
                    }
                }
            }
        }

//        cutlass = registerTool(new Cutlass(), "cutlass");

        cutlass = new Cutlass();
        registerTool(cutlass, "cutlass");
        TinkerRegistry.registerToolForgeCrafting(cutlass);
        //Register model


//        for(Pair<Item, ToolPart> toolPartPattern: toolPartPatterns){
//            registerStencil(toolPartPattern.getLeft(), toolPartPattern.getRight());
//        }
         **/
    }


    public static void init(FMLInitializationEvent event){
        //ROUND 3 - IT'S AZULALOI VS TINKER'S CONSTRUCT, DUELING IN INIT
        //WILL AZULALOI REMEMBER NOT TO USE 1.12 FUNCTIONS?
        //PROBABLY NOT

        cutlass = new Cutlass();
        cutlass.setUnlocalizedName("cutlass");
        cutlass.setRegistryName("cutlass");
        GameRegistry.register(cutlass);
        TinkerRegistry.registerToolForgeCrafting(cutlass);

    }


    public static void postInit(FMLPostInitializationEvent event){



    }

    @SubscribeEvent
    public static void magnetar(RegistryEvent.Register<Item> e){ //Magnetars are a type of star, kind of like Pulsars. It's a joke because I HATE PULSARS
//        fullGuard = new ToolPart(Material.VALUE_Ingot * 3);
//        fullGuard.setUnlocalizedName("fullguard");
//        fullGuard.setRegistryName("fullguard");
//        e.getRegistry().register(fullGuard); //Does tinkers need it to be done like this?
//        TinkerRegistry.registerToolPart(fullGuard);
//        //Register model - that's going to be difficult, isn't it? Dynamic item meshing?
//        toolparts.add(fullGuard);
//        //It runs, so far...





//        cutlass = new Cutlass(); //It no longer runs
//        registerTool(cutlass, "cutlass");
//        cutlass.setUnlocalizedName("cutlass");
//        cutlass.setRegistryName("cutlass"); //maybe the possible parts are null because the item can't register because it has a null name? //nope
//        e.getRegistry().register(cutlass); //REEEEEEEEEEE
//        TinkerRegistry.registerToolForgeCrafting(cutlass);
//        tools.add(cutlass); //does it matter that the for loop is above this?
//        Register model



//        for (final ToolPart p : toolparts){ //for loop is now below
//            for (final ToolCore tool : tools){
//                for (final PartMaterialType m : tool.getRequiredComponents()){
//                    if (m.getPossibleParts().contains(p)){
//                        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), p));
//                    }
//                }
//            }
//        }
    }

    /**
    Fun fact: I'm still retarded.

     //It's an addon, so it's fine.
    //Probably.
    private static <T extends ToolCore> T registerTool(T item, String unlocName) {
        tools.add(item);
        return registerItem(item, unlocName);
    }

    private static ToolPart registerToolPart(ToolPart part, String name) {
        return registerToolPart(part, name, TinkerTools.pattern);
    }

    private static <T extends Item & IPattern> ToolPart registerToolPart(ToolPart part, String name, T pattern) {
        ToolPart ret = registerItem(part, name);

        if(pattern != null) {
            toolPartPatterns.add(Pair.<Item, ToolPart>of(pattern, ret));
        }

        toolparts.add(ret);

        return ret;
    }

    //IT'S AN ADDON, IT'S FINE
    private static <T extends Item> T registerItem(T item, String name) {
        if(!name.equals(name.toLowerCase(Locale.US))) {
            throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Item: %s", name));
        }

        item.setUnlocalizedName(AzTiC.MODID + "name");
        item.setRegistryName("name");
        GameRegistry.register(item);
        return item;
    }

    //IF TINKERS HAD AN API I WOULDN'T HAVE TO DO THIS
    private static void registerStencil(Item pattern, ToolPart toolPart) {
        for(ToolCore toolCore : TinkerRegistry.getTools()) {
            for(PartMaterialType partMaterialType : toolCore.getRequiredComponents()) {
                if(partMaterialType.getPossibleParts().contains(toolPart)) {
                    ItemStack stencil = new ItemStack(pattern);
                    Pattern.setTagForPart(stencil, toolPart);
                    TinkerRegistry.registerStencilTableCrafting(stencil);
                    return;
                }
            }
        }
    }
     **/
}
