package az.aztic.tinkers.tools;

import az.aztic.tinkers.AzTinker;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.SwordCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.List;

/**
 * Created by Azulaloi on 7/20/2017
 */
public class Cutlass extends SwordCore{
    public Cutlass(){
          super(PartMaterialType.handle(TinkerTools.toolRod),
                PartMaterialType.head(TinkerTools.swordBlade),
//                PartMaterialType.extra(TinkerTools.toughBinding));
                PartMaterialType.extra(AzTinker.fullGuard));

        this.addCategory(Category.WEAPON);
    }

    @Override
    public float damagePotential(){ return 1.1f; } //Broadsword value

    @Override
    public double attackSpeed(){ return 1.6d; } //Vanilla value

    @Override
    public ToolNBT buildTagData(List<Material> materials){
        HandleMaterialStats handle = materials.get(0).getStatsOrUnknown(MaterialTypes.HANDLE);
        HeadMaterialStats head = materials.get(1).getStatsOrUnknown(MaterialTypes.HEAD);
        ExtraMaterialStats extra = materials.get(2).getStatsOrUnknown(MaterialTypes.EXTRA);

        ToolNBT data = new ToolNBT();
        data.head(head);
        data.extra(extra);
        data.handle(handle);

        return data;
    }
}
