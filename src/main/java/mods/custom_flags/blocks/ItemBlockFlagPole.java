package mods.custom_flags.blocks;

import mods.custom_flags.CustomFlags;
import net.minecraft.item.ItemMultiTexture;

/**
 * User: nerd-boy
 * Date: 6/08/13
 * Time: 12:40 PM
 * TODO: Add discription
 */
public class ItemBlockFlagPole extends ItemMultiTexture{

    public ItemBlockFlagPole(int Block) {
        super(CustomFlags.blockFlagPole, new String[] {"oak", "spruce", "birch", "jungle", "iron"});
        this.setUnlocalizedName("custom_flags:flagpole");
    }
}
