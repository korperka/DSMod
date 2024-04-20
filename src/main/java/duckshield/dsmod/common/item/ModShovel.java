package duckshield.dsmod.common.item;

import duckshield.dsmod.client.render.IModelRegister;
import duckshield.dsmod.common.core.DSModCreativeTab;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModShovel extends ItemSpade implements IModelRegister {
    public ModShovel(String name, ToolMaterial material) {
        super(material);

        setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
        setUnlocalizedName(name);
        setCreativeTab(DSModCreativeTab.INSTANCE);

        ModItems.ITEMS.add(this);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
