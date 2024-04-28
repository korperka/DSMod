package duckshield.dsmod.common.item.items.sword;

import duckshield.dsmod.client.util.DSClientUtils;
import duckshield.dsmod.common.item.ModItems;
import duckshield.dsmod.common.item.ModSword;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class LuxoniumSword extends ModSword {
    public LuxoniumSword(String name) {
        super(name, ModItems.LUXONIUM_TOOL_MATERIAL);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (player.getCooledAttackStrength(1) >= 1) {
            World world = player.getEntityWorld();
            BlockPos entityPos = entity.getPosition();

            world.playSound(null, entity.getPosition(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.MASTER, 1, 1);

            AxisAlignedBB boundingBox = entity.getEntityBoundingBox();
            double particleYOffset = boundingBox.maxY - boundingBox.minY;
            double targetScale = Math.max(particleYOffset, Math.max(boundingBox.maxX - boundingBox.minX, boundingBox.maxZ - boundingBox.minZ));
            DSClientUtils.spawnSolarSmash(world, entity.getPosition().add(0, particleYOffset, 0), (float) targetScale * 6);

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
