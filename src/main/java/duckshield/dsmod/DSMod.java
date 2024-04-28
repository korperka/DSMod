package duckshield.dsmod;

import duckshield.dsmod.common.core.proxy.IProxy;
import duckshield.dsmod.common.lib.LibMisc;
import duckshield.dsmod.common.sounds.ModSounds;
import duckshield.dsmod.common.world.gen.ModOresGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LibMisc.MOD_ID, name = LibMisc.MOD_NAME, version = LibMisc.VERSION)
public class DSMod
{
    @Mod.Instance(LibMisc.MOD_ID)
    public static DSMod instance;

    @SidedProxy(serverSide = LibMisc.PROXY_SERVER, clientSide = LibMisc.PROXY_CLIENT)
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModOresGen(), 3);

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
