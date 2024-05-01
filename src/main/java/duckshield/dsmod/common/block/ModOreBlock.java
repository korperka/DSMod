package duckshield.dsmod.common.block;

import duckshield.dsmod.client.core.handler.ModelHandler;
import duckshield.dsmod.client.render.IModelRegister;
import duckshield.dsmod.common.core.ModCreativeTab;
import duckshield.dsmod.common.item.ModItems;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class ModOreBlock extends BlockOre implements IModelRegister {
    private final Item item;

    public ModOreBlock(String name, int harvestLevel) {
        setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
        setUnlocalizedName(name);
        setCreativeTab(ModCreativeTab.INSTANCE);
        setHarvestLevel("pickaxe", harvestLevel);

        item = new ItemBlock(this).setRegistryName(getRegistryName());

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(item);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels() {
        if(Item.getItemFromBlock(this) != Items.AIR) {
            ModelHandler.registerBlockToState(this, 0, getDefaultState());
        }
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean eventReceived(IBlockState state, World world, BlockPos pos, int id, int param) {
        super.eventReceived(state, world, pos, id, param);
        TileEntity tileentity = world.getTileEntity(pos);
        return tileentity != null && tileentity.receiveClientEvent(id, param);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return this == ModBlocks.TACHYONIUM_ORE ? ModItems.TACHYONIUM : item;
    }
}
