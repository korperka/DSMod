package duckshield.dsmod.common.core;

import duckshield.dsmod.client.lib.LibResources;
import duckshield.dsmod.common.item.ModItems;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class DSModCreativeTab extends CreativeTabs {
    public static final DSModCreativeTab INSTANCE = new DSModCreativeTab();
    NonNullList<ItemStack> list;

    public DSModCreativeTab() {
        super(LibMisc.MOD_ID);
        setBackgroundImageName(LibResources.GUI_CREATIVE);
    }

    @Nonnull
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.ARROW);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public void displayAllRelevantItems(@Nonnull NonNullList<ItemStack> list) {
        this.list = list;

        //addItem(var)
    }

    private void addItem(Item item) {
        item.getSubItems(this, list);
    }
}
