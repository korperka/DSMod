package duckshield.dsmod.client.core.proxy;

import duckshield.dsmod.common.core.proxy.IProxy;
import duckshield.dsmod.common.sounds.ModSounds;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {}

    @Override
    public void init(FMLInitializationEvent event) {
        ModSounds.registerSounds();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {}
}
