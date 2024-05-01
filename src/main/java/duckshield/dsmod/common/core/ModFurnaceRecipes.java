package duckshield.dsmod.common.core;

import duckshield.dsmod.common.block.ModBlocks;
import duckshield.dsmod.common.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ModFurnaceRecipes {
    public static void registerRecipes() {
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.LUXONIUM_ORE_MARS, new ItemStack(ModItems.LUXONIUM_INGOT), 1);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.LUXONIUM_ORE_VENUS, new ItemStack(ModItems.LUXONIUM_INGOT), 1);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.LUXONIUM_ORE_MERCURY, new ItemStack(ModItems.LUXONIUM_INGOT), 1);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.TARDONIUM_ORE_MARS, new ItemStack(ModItems.TARDONIUM_INGOT), 1);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.TARDONIUM_ORE_VENUS, new ItemStack(ModItems.TARDONIUM_INGOT), 1);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.TARDONIUM_ORE_MERCURY, new ItemStack(ModItems.TARDONIUM_INGOT), 1);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.TACHYONIUM_ORE, new ItemStack(ModItems.TACHYONIUM), 1);
        FurnaceRecipes.instance().addSmeltingRecipeForBlock(ModBlocks.SHIELDIUM_ORE, new ItemStack(ModItems.SHIELDIUM_INGOT), 1);
    }
}
