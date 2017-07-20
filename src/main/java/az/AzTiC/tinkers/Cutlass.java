package az.AzTiC.tinkers;

import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.IToolPart;
import slimeknights.tconstruct.library.tools.SwordCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.List;

/**
 * Created by Azulaloi on 7/18/2017.
 */
public class Cutlass extends SwordCore {
//    public static final float DURABILITY_MODIFIER = 0.9f;

    public Cutlass() {
//        super(PartMaterialType.head(TinkerTools.swordBlade), PartMaterialType.handle(TinkerTools.toolRod), PartMaterialType.extra(TinkerTools.toughBinding));
//        super(TinkerTools.toolRod, TinkerTools.swordBlade, TinkerTools.toughBinding);
//          super(PartMaterialType.handle(TinkerTools.toolRod),
//                PartMaterialType.head(TinkerTools.swordBlade),
//                PartMaterialType.extra(TinkerTools.toughBinding)); //whatever
//                PartMaterialType.extra(AzTinker.fullGuard));

        super(PartMaterialType.handle(TinkerTools.toolRod),
                PartMaterialType.head(TinkerTools.swordBlade),
                PartMaterialType.extra(TinkerTools.wideGuard));

//        addCategory(Category.WEAPON);
        this.addCategory(Category.WEAPON);
//        setUnlocalizedName("cutlass");
//        setRegistryName("cutlass");
    }

    @Override
    public float damagePotential() {
        return 1.0f;
    }
    //Broadsword value is 1.1f

    @Override
    public double attackSpeed() {
        return 1.9d;
    }
    //Vanilla value is 1.6d
    //Rapier is 3
    //Longsword is 1.4

//    @Override
//    public ToolNBT buildTagData(List<Material> materials) {
//        ToolNBT data = buildDefaultTag(materials);
//        // 2 base damage, like vanilla swords
//        data.attack += 1f;
//        data.durability *= DURABILITY_MODIFIER;
//        return data;
//    }
    @Override
    public ToolNBT buildTagData(List<Material> materials) {
        HandleMaterialStats handle = materials.get(0).getStatsOrUnknown(MaterialTypes.HANDLE);
        HeadMaterialStats head = materials.get(1).getStatsOrUnknown(MaterialTypes.HEAD);
        ExtraMaterialStats guard = materials.get(2).getStatsOrUnknown(MaterialTypes.EXTRA);

        ToolNBT data = new ToolNBT();
        data.head(head);
        data.extra(guard);
        data.handle(handle);

    //    data.attack *= 1.3f;
        data.attack += 1f;

        // triple durability!
//        data.durability *= DURABILITY_MODIFIER;

        return data;
    }
}
