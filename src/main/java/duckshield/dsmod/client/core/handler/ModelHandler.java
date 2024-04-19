package duckshield.dsmod.client.core.handler;

import duckshield.dsmod.client.render.IModelRegister;
import duckshield.dsmod.common.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IRegistryDelegate;

import java.util.Map;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = LibMisc.MOD_ID)
public class ModelHandler {
    private static final Map<IRegistryDelegate<Block>, IStateMapper> customStateMappers = ReflectionHelper.getPrivateValue(ModelLoader.class, null, "customStateMappers");
    private static final DefaultStateMapper fallbackMapper = new DefaultStateMapper();

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent evt) {
        for(Item item : Item.REGISTRY) {
            if(item instanceof IModelRegister) {
                ((IModelRegister) item).registerModels();
            }
        }

        for(Block block : Block.REGISTRY) {
            if(block instanceof IModelRegister) {
                ((IModelRegister) block).registerModels();
            }
        }
    }

    private static ModelResourceLocation getMrlForState(IBlockState state) {
        return customStateMappers
                .getOrDefault(state.getBlock().delegate, fallbackMapper)
                .putStateModelLocations(state.getBlock())
                .get(state);
    }

    public static void registerBlockToState(Block b, int meta, IBlockState state) {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(b),
                meta,
                getMrlForState(state)
        );
    }
}
