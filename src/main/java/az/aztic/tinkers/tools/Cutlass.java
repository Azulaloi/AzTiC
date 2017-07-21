package az.aztic.tinkers.tools;

import az.aztic.tinkers.AzTinker;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.SwordCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.TinkerTools;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Azulaloi on 7/20/2017
 */
public class Cutlass extends SwordCore{
    public static final float DURABILITY_MODIFIER = 1.1f;

    public Cutlass(){
          super(PartMaterialType.handle(TinkerTools.toolRod),
                PartMaterialType.head(TinkerTools.swordBlade),
//                PartMaterialType.extra(TinkerTools.toughBinding));
                PartMaterialType.extra(AzTinker.fullGuard));

        this.addCategory(Category.WEAPON);

        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @Override
            @SideOnly(Side.CLIENT)
            public float apply(@Nonnull ItemStack stack, World worldIn, EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    @Nonnull
    @Override
    public EnumAction getItemUseAction(ItemStack stack) { return EnumAction.BLOCK; }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void reducedDamageBlocked(LivingHurtEvent event) {
        if(event.getSource().isUnblockable() ||
           event.getSource().isMagicDamage() ||
           event.getSource().isExplosion() ||
           event.getSource().isProjectile() ||
           event.isCanceled()) {
            return;
        }
        if(!shouldBlockDamage(event.getEntityLiving())) {
            return;
        }

        EntityPlayer player = (EntityPlayer) event.getEntityLiving();
        ItemStack cutlass = player.getActiveItemStack();

        // got hit by something: reduce damage
        int damage = event.getAmount() < 2f ? 1 : Math.round(event.getAmount() / 2f);
        // reduce damage. After this event the damage will be halved again because we're blocking so we have to factor this in
        event.setAmount(event.getAmount() * 0.7f);

        ToolHelper.damageTool(cutlass, damage, player);
    }

    protected boolean shouldBlockDamage(Entity entity) {
        if(!(entity instanceof EntityPlayer)) {
            return false;
        }
        EntityPlayer player = (EntityPlayer) entity;

        if(!player.isActiveItemStackBlocking() || player.getActiveItemStack().getItem() != this) { return false; }

        return !ToolHelper.isBroken(player.getActiveItemStack());
    }

    @Override
    public float damagePotential(){ return 0.9f; }

    @Override
    public float damageCutoff() { return 12.5f; }

    @Override
    public double attackSpeed(){ return 1.8d; }

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

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack itemStackIn = playerIn.getHeldItem(hand);
        if(playerIn.getHeldItemMainhand() == itemStackIn){
            if (!ToolHelper.isBroken(itemStackIn)){
                playerIn.setActiveHand(hand);
                return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
            }
        }
        return ActionResult.newResult(EnumActionResult.FAIL, itemStackIn);
    }

    @Override
    public float getRepairModifierForPart(int index) {
        return DURABILITY_MODIFIER;
    }

    //Faster than broadsword, slower than rapier
    //Alt ability is block
    //A little less durable than broadsword
    //Slightly more damage than broadsword
    //Cannot be dual wielded
}
