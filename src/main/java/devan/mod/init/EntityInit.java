package devan.mod.init;

import devan.mod.Main;
import devan.mod.entity.EntityCustomVillager;
import devan.mod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
    public static void registerEntities(){
        registerEntity("customvillager", EntityCustomVillager.class, Reference.ENTITY_VILLAGER, 50, 3093151, 3121457);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
    }
}
