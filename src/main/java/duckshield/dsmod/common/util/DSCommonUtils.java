package duckshield.dsmod.common.util;

import com.artemis.artemislib.util.attributes.ArtemisLibAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;

public class DSCommonUtils {
    public static void resizePlayer(EntityPlayer player, double width, double height) {
        player.getEntityAttribute(ArtemisLibAttributes.ENTITY_WIDTH).setBaseValue(width);
        player.getEntityAttribute(ArtemisLibAttributes.ENTITY_HEIGHT).setBaseValue(height);

        //майнкрафт гавно поэтому почему-то для применения изменений нужно делать ЭТО
        player.getEntityAttribute(ArtemisLibAttributes.ENTITY_WIDTH).removeAllModifiers();
        player.getEntityAttribute(ArtemisLibAttributes.ENTITY_HEIGHT).removeAllModifiers();
        player.getEntityAttribute(ArtemisLibAttributes.ENTITY_WIDTH).applyModifier(new AttributeModifier("widthModifier", 0, 0));
        player.getEntityAttribute(ArtemisLibAttributes.ENTITY_HEIGHT).applyModifier(new AttributeModifier("heightModifier", 0, 0));
    }
}
