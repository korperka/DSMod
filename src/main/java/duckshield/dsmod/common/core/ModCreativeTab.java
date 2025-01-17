package duckshield.dsmod.common.core;

import duckshield.dsmod.client.lib.LibResources;
import duckshield.dsmod.common.item.ModItems;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class ModCreativeTab extends CreativeTabs {
    public static final ModCreativeTab INSTANCE = new ModCreativeTab();
    NonNullList<ItemStack> list;

    public ModCreativeTab() {
        super(LibMisc.MOD_ID);
        setBackgroundImageName(LibResources.GUI_CREATIVE);
    }

    @Nonnull
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.SHIELDIUM_INGOT);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

    @Override
    public void displayAllRelevantItems(@Nonnull NonNullList<ItemStack> list) {
        this.list = list;

        ModItems.ITEMS.forEach(this::addItem);
    }

    private void addItem(Item item) {
        item.getSubItems(this, list);
    }
}
