package duckshield.dsmod.client.particle.particles;

import duckshield.dsmod.client.lib.LibResources;
import duckshield.dsmod.client.particle.ModParticle;
import net.minecraft.world.World;

public class SolarSmashParticle extends ModParticle {
    public SolarSmashParticle(World parWorld, double parX, double parY, double parZ, float scale) {
        super(new TextureDefinition(LibResources.LUXONIUM_IGNITE_PARTICLE, true, 7), parWorld, parX, parY, parZ);

        setScale(scale);
        setMaxAge(10);
        setCanCollide(false);
    }

    @Override
    public void onUpdate() {
        setGravity(0);

        super.onUpdate();
    }
}
