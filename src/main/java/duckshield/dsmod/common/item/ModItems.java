package duckshield.dsmod.common.item;

import duckshield.dsmod.common.item.items.axe.LuxoniumAxe;
import duckshield.dsmod.common.item.items.pickaxe.LuxoniumPickaxe;
import duckshield.dsmod.common.item.items.shovel.LuxoniumShovel;
import duckshield.dsmod.common.item.items.sword.LuxoniumSword;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public class ModItems {
    public static final Item.ToolMaterial SHIELDIUM_TOOL_MATERIAL = EnumHelper.addToolMaterial("SHIELDIUM", 4, 2561, 10, 4, 10);
    public static final Item.ToolMaterial LUXONIUM_TOOL_MATERIAL = EnumHelper.addToolMaterial("LUXONIUM", 5, 6122, 12, 6, 10);

    public static final ArrayList<Item> ITEMS = new ArrayList<>();

    public static final ModItem SHIELDIUM_INGOT = new ModItem("shieldium_ingot");
    public static final ModItem SHIELDIUM_STICK = new ModItem("shieldium_stick");

    public static final ModSword SHIELDIUM_SWORD = new ModSword("shieldium_sword", SHIELDIUM_TOOL_MATERIAL);
    public static final ModPickaxe SHIELDIUM_PICKAXE = new ModPickaxe("shieldium_pickaxe", SHIELDIUM_TOOL_MATERIAL);
    public static final ModAxe SHIELDIUM_AXE = new ModAxe("shieldium_axe", SHIELDIUM_TOOL_MATERIAL);
    public static final ModShovel SHIELDIUM_SHOVEL = new ModShovel("shieldium_shovel", SHIELDIUM_TOOL_MATERIAL);

    public static final LuxoniumSword LUXONIUM_SWORD = new LuxoniumSword("luxonium_sword");
    public static final LuxoniumPickaxe LUXONIUM_PICKAXE = new LuxoniumPickaxe("luxonium_pickaxe");
    public static final LuxoniumShovel LUXONIUM_SHOVEL = new LuxoniumShovel("luxonium_shovel");
    public static final LuxoniumAxe LUXONIUM_AXE = new LuxoniumAxe("luxonium_axe");
    public static final ModItem LUXONIUM_INGOT = new ModItem("luxonium_ingot");

    public static final ModItem TACHYONIUM = new ModItem("tachyonium");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();

        ITEMS.forEach(r::register);
    }
}
