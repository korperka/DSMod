package duckshield.dsmod.common.item.items.pickaxe;

import duckshield.dsmod.common.item.ModItems;
import duckshield.dsmod.common.item.ModPickaxe;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.ParametersAreNonnullByDefault;

public class LuxoniumPickaxe extends ModPickaxe {
    public LuxoniumPickaxe(String name) {
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
