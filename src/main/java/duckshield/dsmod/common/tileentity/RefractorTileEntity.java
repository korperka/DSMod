package duckshield.dsmod.common.tileentity;

import com.artemis.artemislib.util.attributes.ArtemisLibAttributes;
import duckshield.dsmod.client.util.DSClientUtils;
import duckshield.dsmod.common.util.DSCommonUtils;
import li.cil.oc.api.Network;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.EnvironmentHost;
import li.cil.oc.api.network.Visibility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;

import javax.annotation.Nullable;
import java.util.Timer;
import java.util.TimerTask;

public class RefractorTileEntity extends OCTileEntity {
    public RefractorTileEntity() {
        super("refractor");
        node = Network.newNode(this, Visibility.Network).withComponent(getComponentName()).withConnector().create();
    }

    public RefractorTileEntity(EnvironmentHost host){
        super("os_entdetector", host);
    }

    @Callback(doc = "function(double:double) -- changes the size of player who standing at the refractor")
    public Object[] resize(Context context, Arguments args) {
        double width = args.checkDouble(0);
        double height = args.checkDouble(1);

        if(DSClientUtils.checkPlayerSize(width, height)) {
            return new Object[] { "Please, enter valid width and height." };
        }

        if(getPlayerStandingOnBlock() == null) {
            return new Object[] { "No one is standing on refractor." };
        }

        double oldWidth = getPlayerStandingOnBlock().getEntityAttribute(ArtemisLibAttributes.ENTITY_WIDTH).getBaseValue();
        double oldHeight = getPlayerStandingOnBlock().getEntityAttribute(ArtemisLibAttributes.ENTITY_HEIGHT).getBaseValue();

        if(oldWidth == width && oldHeight == height) {
            return new Object[] { "Player is already that size." };
        }

        Timer resizeTimer = new Timer();

        resizeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(getPlayerStandingOnBlock() == null) {
                    return;
                }

                world.playSound(null, getPlayerStandingOnBlock().getPosition(), SoundEvents.EVOCATION_ILLAGER_CAST_SPELL, SoundCategory.BLOCKS, 1, 1);
                DSClientUtils.spawnSmokeParticle(world, getPlayerStandingOnBlock().getPosition().add(0, height, 0), (float) Math.max(width, height) * 10);
                DSCommonUtils.resizePlayer(getPlayerStandingOnBlock(), width, height);

                resizeTimer.cancel();
            }
        }, 5 * 1000);

        resizeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(getPlayerStandingOnBlock() == null) {
                    DSClientUtils.randomSpawnParticles(10, pos.add(0, 1, 0), EnumParticleTypes.VILLAGER_ANGRY);
                    world.playSound(null, pos, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.BLOCKS, 1, 1);

                    resizeTimer.cancel();
                }
            }
        }, 50, 50);

        resizeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(getPlayerStandingOnBlock() == null) {
                    return;
                }

                world.playSound(null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 1, 1);
                DSClientUtils.randomSpawnParticles(10, pos.add(0, 1, 0), EnumParticleTypes.END_ROD);
            }
        }, 1000, 1000);

        return new Object[] { "Started resizing process." };
    }

    @Nullable
    public EntityPlayer getPlayerStandingOnBlock() {
        return world.playerEntities.stream().filter(player ->
                world.getTileEntity(player.getPosition().add(0, -1, 0)) == this)
                .findFirst().orElse(null);
    }
}
