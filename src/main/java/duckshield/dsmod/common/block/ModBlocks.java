package duckshield.dsmod.common.block;

import duckshield.dsmod.common.block.blocks.BlockRefractor;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = LibMisc.MOD_ID)
public class ModBlocks {
    public static final ArrayList<Block> BLOCKS = new ArrayList<>();

    //TODO: я молодец и крутой и вообще офигенный но надо ещё добавить остальные руды, а ещё сделать совместимость с Alchemistry (т.к мод чисто для серва, то можно сделать через крафт твикер, но лучше в моде)
    public static final Block SHIELDIUM_ORE = new ModOreBlock("shieldium_ore",3).setHardness(3).setResistance(5);
    public static final Block LUXONIUM_ORE_MARS = new ModOreBlock("luxonium_ore_mars", 4).setHardness(5).setResistance(7);
    public static final Block LUXONIUM_ORE_MERCURY = new ModOreBlock("luxonium_ore_mercury", 4).setHardness(5).setResistance(7);
    public static final Block LUXONIUM_ORE_VENUS = new ModOreBlock("luxonium_ore_venus", 4).setHardness(5).setResistance(7);
    public static final Block TACHYONIUM_ORE = new ModOreBlock("tachyonium_ore", 5).setHardness(6).setResistance(8);
    public static final Block REFRACTOR = new BlockRefractor("refractor");

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();

        BLOCKS.forEach(r::register);
    }
}
