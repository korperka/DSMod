package duckshield.dsmod.common.world.gen;

import duckshield.dsmod.common.block.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModOresGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if(world.provider.getDimension() == 0) {
            generateOverworld(random, chunkX, chunkZ, world);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world) {
        generateOre(ModBlocks.SHIELDIUM_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 16, random.nextInt(3) + 3, 10);
    }

    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int veinSize, int chance) {
        int deltaY = maxY - minY;

        for(int i = 0; i < chance; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, veinSize);
            generator.generate(world, random, pos);
        }
    }
}
