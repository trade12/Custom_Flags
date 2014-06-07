package mods.custom_flags.client.utils;

import mods.custom_flags.CustomFlags;
import mods.custom_flags.items.ItemFlag;
import mods.custom_flags.utils.ImageData;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.item.ItemStack;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * User: nerd-boy
 * Date: 2/08/13
 * Time: 3:02 PM
 * TODO: Add discription
 */
public class ImageCahce {

    private static ItemStack temp;

    private static final DynamicTexture defaultTexture;

    private static final DynamicTexture test1;

    static{
        defaultTexture = new DynamicTexture(ImageData.IMAGE_RES, ImageData.IMAGE_RES);

        test1 = new DynamicTexture(ImageData.IMAGE_RES, ImageData.IMAGE_RES);

        ImageData.defaultImage.setTexture(defaultTexture.getTextureData());
    }

    private static final LoadingCache<String, DynamicTexture> imageCahce =
            CacheBuilder.newBuilder().maximumSize(CustomFlags.CAHCE_SIZE).
                    build(
                            new CacheLoader<String, DynamicTexture>() {
                                @Override
                                public DynamicTexture load(String key) throws Exception {
                                    DynamicTexture texture = new DynamicTexture(ImageData.IMAGE_RES, ImageData.IMAGE_RES);

                                    if (temp != null &&
                                            temp.getItem() instanceof ItemFlag &&
                                            ((ItemFlag) temp.getItem()).hasImageData(temp)) {


                                        new ImageData(((ItemFlag) temp.getItem()).getImageData(temp)).setTexture(texture.getTextureData());

                                    }

                                    return texture;
                                }

                            }
                    );
    {
        CacheBuilder.newBuilder().build();
    }


    public static void setTexture(ItemStack stack){

        if (stack != null &&
                stack.getItem() instanceof ItemFlag &&
                ((ItemFlag) stack.getItem()).hasImageData(stack)) {


            ImageData id =  new ImageData(((ItemFlag) stack.getItem()).getImageData(stack));
            id.setTexture(test1.getTextureData());
            test1.updateDynamicTexture();
        }else{
            ImageData.defaultImage.setTexture(defaultTexture.getTextureData());
            defaultTexture.updateDynamicTexture();
        }

        /*
        try{
            if (stack != null &&
                    stack.getItem() instanceof ItemFlag &&
                    ((ItemFlag) stack.getItem()).hasImageData(stack)) {
                temp = stack;
                imageCahce.get(((ItemFlag)stack.getItem()).getKey(stack)).func_110564_a();

            }else{
                ImageData.defaultImage.setTexture(defaultTexture.func_110565_c());
                defaultTexture.func_110564_a();
            }
        }catch(Exception e){
            ImageData.defaultImage.setTexture(defaultTexture.func_110565_c());
            defaultTexture.func_110564_a();
        }
        */


    }




}
