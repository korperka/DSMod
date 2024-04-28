package duckshield.dsmod.client.util;

import duckshield.dsmod.client.particle.particles.SolarSmashParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DSClientUtils {
    public static void spawnSolarSmash(World world, BlockPos pos, float scale) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new SolarSmashParticle(world, pos.getX(), pos.getY(), pos.getZ(), scale));
    }
}
