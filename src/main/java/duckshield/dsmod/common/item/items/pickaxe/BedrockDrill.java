package duckshield.dsmod.common.item.items.pickaxe;

import duckshield.dsmod.common.block.ModBlocks;
import duckshield.dsmod.common.item.ModItems;
import duckshield.dsmod.common.item.ModPickaxe;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class BedrockDrill extends ModPickaxe {
    public BedrockDrill(String name) {
        super(name, ModItems.DRILL_MATERIAL);
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        return false;
    }

    @Override
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        Vec3d lookVec = playerIn.getLookVec();
        double reach = playerIn.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue();

        RayTraceResult lookingAt = playerIn.world.rayTraceBlocks(playerIn.getPositionEyes(1), playerIn.getPositionEyes(1).addVector(lookVec.x * reach, lookVec.y * reach, lookVec.z * reach));

        if (lookingAt != null && lookingAt.typeOfHit == RayTraceResult.Type.BLOCK) {
            BlockPos pos = lookingAt.getBlockPos();
            IBlockState currentBlockState = worldIn.getBlockState(pos);

            if (currentBlockState.getBlock() == Blocks.BEDROCK) {
                worldIn.setBlockState(pos, ModBlocks.CRUSHED_BEDROCK.getDefaultState());

                worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

                playerIn.getHeldItem(handIn).damageItem(1, playerIn);

                return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
            }
        }

        return ActionResult.newResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
