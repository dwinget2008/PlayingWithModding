package devan.mod.entity.model;

import devan.mod.entity.EntityCustomVillager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * ModelVillager - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelCustomVillager extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer RightArm_Top;
    public ModelRenderer LeftArm_Top;
    public ModelRenderer LeftLeg;
    public ModelRenderer Body;
    public ModelRenderer RightLeg;
    public ModelRenderer Nose;
    public ModelRenderer RightArm_Bottom;
    public ModelRenderer LeftArm_Bottom;
    public ModelRenderer LeftLeg_Bottom;
    public ModelRenderer RightLeg_Bottom;

    protected int cycleIndex = 0;
    protected float[][] walkCycle = new float[][]
    {
            {36F, -36F},
            {-36F, 36F}
    };


    public ModelCustomVillager() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LeftLeg = new ModelRenderer(this, 0, 22);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.LeftLeg_Bottom = new ModelRenderer(this, 17, 38);
        this.LeftLeg_Bottom.mirror = true;
        this.LeftLeg_Bottom.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.LeftLeg_Bottom.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.RightArm_Top = new ModelRenderer(this, 44, 22);
        this.RightArm_Top.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.RightArm_Top.addBox(-8.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(RightArm_Top, -0.5009094953223726F, 0.0F, 0.0F);
        this.LeftArm_Top = new ModelRenderer(this, 44, 22);
        this.LeftArm_Top.setRotationPoint(0.0F, 2.9F, 0.0F);
        this.LeftArm_Top.addBox(4.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F);
        this.RightArm_Bottom = new ModelRenderer(this, 0, 38);
        this.RightArm_Bottom.setRotationPoint(-8.0F, 4.0F, 0.0F);
        this.RightArm_Bottom.addBox(0.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(RightArm_Bottom, -0.5009094953223726F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.RightLeg_Bottom = new ModelRenderer(this, 17, 38);
        this.RightLeg_Bottom.mirror = true;
        this.RightLeg_Bottom.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.RightLeg_Bottom.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.Body = new ModelRenderer(this, 16, 20);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.RightLeg = new ModelRenderer(this, 0, 22);
        this.RightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.Nose = new ModelRenderer(this, 24, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.LeftArm_Bottom = new ModelRenderer(this, 0, 38);
        this.LeftArm_Bottom.mirror = true;
        this.LeftArm_Bottom.setRotationPoint(4.0F, 4.0F, 0.0F);
        this.LeftArm_Bottom.addBox(0.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
        this.LeftLeg.addChild(this.LeftLeg_Bottom);
        this.RightArm_Top.addChild(this.RightArm_Bottom);
        this.RightLeg.addChild(this.RightLeg_Bottom);
        this.Head.addChild(this.Nose);
        this.LeftArm_Top.addChild(this.LeftArm_Bottom);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.RightArm_Top.render(f5);
        this.Head.render(f5);
        this.LeftLeg.render(f5);
        this.LeftArm_Top.render(f5);
        this.Body.render(f5);
        this.RightLeg.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        float f = 1.0F;
        float angleX = 0.0F;

        this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.Head.rotateAngleX  = headPitch * 0.017453292F;

        this.Body.rotateAngleY = 0.0F;

        if(entityIn instanceof EntityCustomVillager){
            this.Body.rotateAngleY = entityIn.rotationYaw;
        }

        this.RightArm_Top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
        angleX = this.RightArm_Top.rotateAngleX;
        if(angleX > 0) angleX = 0.0F;
        this.RightArm_Bottom.rotateAngleX = angleX / 2F;

        this.LeftArm_Top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
        angleX = this.LeftArm_Top.rotateAngleX;
        if(angleX > 0) angleX = 0.0F;
        this.LeftArm_Bottom.rotateAngleX = angleX / 2F;

        this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        angleX = -(this.RightLeg.rotateAngleX);
        if(angleX < 0) angleX = 0.0F;
        this.RightLeg_Bottom.rotateAngleX = angleX / 1.5F;

        this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
        angleX = -(this.LeftLeg.rotateAngleX);
        if(angleX < 0) angleX = 0.0F;
        this.LeftLeg_Bottom.rotateAngleX = angleX / 1.5F;
    }
}
