package devan.mod.entity.render;

import devan.mod.entity.EntityCustomVillager;
import devan.mod.entity.model.ModelCustomVillager;
import devan.mod.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCustomVillager extends RenderLiving<EntityCustomVillager> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/modelcustomvillager.png" );

    public RenderCustomVillager(RenderManager manager)
    {
        super(manager, new ModelCustomVillager(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCustomVillager entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityCustomVillager entityLiving, float something, float rotaionYaw, float partialTicks){
        super.applyRotations(entityLiving, something, rotaionYaw, partialTicks);
    }
}
