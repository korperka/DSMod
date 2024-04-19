package duckshield.dsmod.common.item;

import duckshield.dsmod.client.lib.LibResources;
import duckshield.dsmod.client.render.IModelRegister;
import duckshield.dsmod.common.core.DSModCreativeTab;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ModItem extends Item implements IModelRegister {
    public ModItem(String name) {
        setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
        setUnlocalizedName(name);
        setCreativeTab(DSModCreativeTab.INSTANCE);

        ModItems.ITEMS.add(this);
    }

    @Nonnull
    @Override
    public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) {
        return super.getUnlocalizedNameInefficiently(par1ItemStack).replaceAll("item\\.", "item." + LibResources.PREFIX_MOD);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
