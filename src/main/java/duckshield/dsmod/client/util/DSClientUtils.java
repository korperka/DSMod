package duckshield.dsmod.client.util;

import duckshield.dsmod.client.particle.particles.SmokeParticle;
import duckshield.dsmod.client.particle.particles.SolarSmashParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class DSClientUtils {
    public static void spawnSolarSmash(World world, BlockPos pos, float scale) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new SolarSmashParticle(world, pos.getX(), pos.getY(), pos.getZ(), scale));
    }

    public static void spawnSmokeParticle(World world, BlockPos pos, float scale) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new SmokeParticle(world, pos.getX(), pos.getY(), pos.getZ(), scale));
    }

    public static void randomSpawnParticles(int count, BlockPos pos, EnumParticleTypes particle) {
        for (int i = 0; i < count; i++) {
            double offsetX = new Random().nextGaussian() * 0.5;
            double offsetY = new Random().nextGaussian() * 0.5;
            double offsetZ = new Random().nextGaussian() * 0.5;

            double x = pos.getX() + 0.5 + offsetX;
            double y = pos.getY() + 0.5 + offsetY;
            double z = pos.getZ() + 0.5 + offsetZ;

            Minecraft.getMinecraft().effectRenderer.spawnEffectParticle(particle.getParticleID(), x, y, z, 0, 0, 0);
        }
    }

    public static boolean checkPlayerSize(double width, double height) {
        return width > 3 || height > 3 || width < 0.4 || height < 0.4;
    }
}
