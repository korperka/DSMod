package duckshield.dsmod.common.sounds;

import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModSounds {
    public static SoundEvent LUXONIUM_IGNITE;
    public static SoundEvent BABKA;

    public static void registerSounds() {
        LUXONIUM_IGNITE = registerSound("item.luxonium_sword.ignite");
        BABKA = registerSound("record.babka");
    }

    public static SoundEvent registerSound(String name) {
        ResourceLocation resourceLocation = new ResourceLocation(LibMisc.MOD_ID, name);
        SoundEvent event = new SoundEvent(resourceLocation).setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
