package duckshield.dsmod.client.particle.particles;

import duckshield.dsmod.client.lib.LibResources;
import duckshield.dsmod.client.particle.ModParticle;
import net.minecraft.world.World;

public class SmokeParticle extends ModParticle {
    public SmokeParticle(World parWorld, double parX, double parY, double parZ, float scale) {
        super(new TextureDefinition(LibResources.SMOKE_PARTICLE, true, 10), parWorld, parX, parY, parZ);

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
