package duckshield.dsmod.common.item.items.axe;

import duckshield.dsmod.client.util.DSClientUtils;
import duckshield.dsmod.common.item.ModAxe;
import duckshield.dsmod.common.item.ModItems;
import duckshield.dsmod.common.sounds.ModSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class LuxoniumAxe extends ModAxe {
    public LuxoniumAxe(String name) {
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

            stack.damageItem(1, entityLiving);

            return true;
        }

        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (player.getCooledAttackStrength(1) >= 1) {
            World world = player.getEntityWorld();
            BlockPos entityPos = entity.getPosition();

            world.playSound(null, entity.getPosition(), ModSounds.LUXONIUM_IGNITE, SoundCategory.PLAYERS, 3, 1);

            AxisAlignedBB boundingBox = entity.getEntityBoundingBox();
            double particleYOffset = boundingBox.maxY - boundingBox.minY;
            double targetScale = Math.max(particleYOffset, Math.max(boundingBox.maxX - boundingBox.minX, boundingBox.maxZ - boundingBox.minZ));
            DSClientUtils.spawnSolarSmash(world, entity.getPosition().add(0, particleYOffset, 0), (float) targetScale * 7.5f);

            world.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(entityPos.getX() - 5, entityPos.getY() - 5, entityPos.getZ() - 5, entityPos.getX() + 5, entityPos.getY() + 5, entityPos.getZ() + 5)).forEach(entityLiving -> {
                if(entityLiving != entity) {
                    float damage = (ModItems.LUXONIUM_TOOL_MATERIAL == null) ? 3 : ModItems.LUXONIUM_TOOL_MATERIAL.getAttackDamage() / 2;
                    entityLiving.attackEntityFrom(DamageSource.MAGIC, damage);
                }

                entityLiving.setFire(5);
            });
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}
