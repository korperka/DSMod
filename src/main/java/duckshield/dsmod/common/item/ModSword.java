package duckshield.dsmod.common.item;

import duckshield.dsmod.client.render.IModelRegister;
import duckshield.dsmod.common.core.ModCreativeTab;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModSword extends ItemSword implements IModelRegister {
    public ModSword(String name, ToolMaterial material) {
        super(material);

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
