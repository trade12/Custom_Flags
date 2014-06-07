package mods.custom_flags.client;

import mods.custom_flags.CommonProxy;
import mods.custom_flags.CustomFlags;
import mods.custom_flags.blocks.TileEntityFlagPole;
import mods.custom_flags.client.renderer.FlagItemRenderer;
import mods.custom_flags.client.renderer.FlagPoleItemRenderer;
import mods.custom_flags.client.renderer.FlagPoleTileRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * User: nerd-boy
 * Date: 2/08/13
 * Time: 4:28 PM
 * TODO: Add discription
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlagPole.class, new FlagPoleTileRenderer());

        MinecraftForgeClient.registerItemRenderer(CustomFlags.blockFlagPole, new FlagPoleItemRenderer());
        MinecraftForgeClient.registerItemRenderer(CustomFlags.itemFlag, new FlagItemRenderer());

        GameRegistry.registerPlayerTracker(new CustomFlagsPlayerTracker());

    }
}
