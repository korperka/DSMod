package duckshield.dsmod.common.item.items.shovel;

import duckshield.dsmod.common.item.ModItems;
import duckshield.dsmod.common.item.ModShovel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class LuxoniumShovel extends ModShovel {
    public LuxoniumShovel(String name) {
        super(name, ModItems.LUXONIUM_TOOL_MATERIAL);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        ItemStack smeltedItem = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(state.getBlock()));
        smeltedItem.setCount(1);

        if(smeltedItem != ItemStack.EMPTY) {
            worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 0.1, 0);
            worldIn.setBlockToAir(pos);

            if(!worldIn.isRemote) {
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), smeltedItem));
            }

            return true;
        }

        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
