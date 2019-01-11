package devan.mod.util.handlers;

import devan.mod.entity.EntityCustomVillager;
import devan.mod.entity.render.RenderCustomVillager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
{
    public static void registerEntityRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityCustomVillager.class, new IRenderFactory<EntityCustomVillager>() {
            @Override
            public Render<? super EntityCustomVillager> createRenderFor(RenderManager manager) {
                return new RenderCustomVillager(manager);
            }
        });
    }
}
