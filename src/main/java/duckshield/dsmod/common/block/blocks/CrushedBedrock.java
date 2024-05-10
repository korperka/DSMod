package duckshield.dsmod.common.block.blocks;

import duckshield.dsmod.common.block.ModBlock;
import duckshield.dsmod.common.block.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class CrushedBedrock extends ModBlock {
    public CrushedBedrock(String name) {
        super(name, Material.ROCK);

        setHardness(6);
        setResistance(8);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.AIR;
    }
}
