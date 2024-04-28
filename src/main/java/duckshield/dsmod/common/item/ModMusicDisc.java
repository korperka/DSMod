package duckshield.dsmod.common.item;

import duckshield.dsmod.client.render.IModelRegister;
import duckshield.dsmod.common.core.DSModCreativeTab;
import duckshield.dsmod.common.lib.LibMisc;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModMusicDisc extends ItemRecord implements IModelRegister
{
    public String artistName;

    public String songName;

    protected ModMusicDisc(String songName, SoundEvent event, String artist)
    {
        super(songName, event);
        this.artistName = artist;
        this.songName = songName;

        setRegistryName(new ResourceLocation(LibMisc.MOD_ID, songName));
        setUnlocalizedName(songName);

        setCreativeTab(DSModCreativeTab.INSTANCE);

        ModItems.ITEMS.add(this);
    }

    @Override
    public String getRecordNameLocal()
    {
        return this.artistName + " - " + I18n.format("item.tooltip." + this.songName);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}