package az.aztic.tinkers.tools;

import com.google.common.collect.ImmutableSet;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.IShearable;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.AoeToolCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.List;
import java.util.Random;

/**
 * Created by Azulaloi on 7/21/2017
 */
public class Shears extends AoeToolCore {

    public static final ImmutableSet<net.minecraft.block.material.Material> effective_materials_shears =
            ImmutableSet.of(net.minecraft.block.material.Material.WEB,
                            net.minecraft.block.material.Material.PLANTS,
                            net.minecraft.block.material.Material.VINE,
                            net.minecraft.block.material.Material.LEAVES,
                            net.minecraft.block.material.Material.GOURD,
                            net.minecraft.block.material.Material.CACTUS);


    public Shears(){
        super(PartMaterialType.head(TinkerTools.knifeBlade),
              PartMaterialType.head(TinkerTools.knifeBlade),
              PartMaterialType.extra(TinkerTools.binding));

        addCategory(Category.HARVEST);
    }

    protected void breakBlock(ItemStack stack, EntityPlayer player, BlockPos pos, BlockPos refPos){
        if(ToolHelper.shearBlock(stack, player.getEntityWorld(), player, pos)){
            return;
        }
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase entity, EnumHand hand){
        if (entity.world.isRemote){
            return false;
        }
        if (entity instanceof IShearable){
            IShearable target = (IShearable)entity;
            BlockPos pos = new BlockPos(entity);
            if (target.isShearable(itemStack, entity.world, pos)){
                List<ItemStack> drops = target.onSheared(itemStack,
                                                         player.getEntityWorld(),
                                                         pos,
                                                         EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemStack));
                Random rand = entity.world.rand;
                for (ItemStack item : drops){
                    EntityItem entityItem = entity.entityDropItem(item, 1.0F);
                    if(entityItem != null){
                        entityItem.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                        entityItem.motionY += rand.nextFloat() * 0.05F;
                        entityItem.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    }
                }
                ToolHelper.damageTool(itemStack, 1, player);

                return true;
            }
        }
        return false;
    }

    @Override
    protected ToolNBT buildTagData(List<Material> materials) {
        return buildDefaultTag(materials);
    }

    @Override
    public float damagePotential() {
        return 1.0F;
    }

    @Override
    public double attackSpeed() {
        return 1;
    }
}
