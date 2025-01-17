package duckshield.dsmod.common.item;

import duckshield.dsmod.client.render.IModelRegister;
import duckshield.dsmod.common.core.ModCreativeTab;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModAxe extends ItemAxe implements IModelRegister {
    protected ModAxe(String name, ToolMaterial material) {
        super(material, material.getAttackDamage() * 2, -3.1f);

        setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
        setUnlocalizedName(name);
        setCreativeTab(ModCreativeTab.INSTANCE);

        ModItems.ITEMS.add(this);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
