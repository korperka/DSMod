package duckshield.dsmod.common.core.proxy;

import duckshield.dsmod.common.sounds.ModSounds;
import duckshield.dsmod.common.world.gen.ModOresGen;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ServerProxy implements IProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Override
    public void init(FMLInitializationEvent event) {
        ModSounds.registerSounds();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {}
}
