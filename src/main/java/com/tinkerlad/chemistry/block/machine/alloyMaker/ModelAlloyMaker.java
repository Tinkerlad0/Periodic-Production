package com.tinkerlad.chemistry.block.machine.alloyMaker;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAlloyMaker extends ModelBase {

    //fields
    ModelRenderer Base;
    ModelRenderer Top;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Floater;
    ModelRenderer Shape6;
    ModelRenderer Shape5;

    public ModelAlloyMaker() {
        textureWidth = 128;
        textureHeight = 128;

        Base = new ModelRenderer(this, 0, 21);
        Base.addBox(-8F, 0F, -8F, 16, 4, 16);
        Base.setRotationPoint(0F, 20F, 0F);
        Base.setTextureSize(128, 128);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        Top = new ModelRenderer(this, 0, 0);
        Top.addBox(-8F, 0F, -8F, 16, 4, 16);
        Top.setRotationPoint(0F, 4F, 0F);
        Top.setTextureSize(128, 128);
        Top.mirror = true;
        setRotation(Top, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 66, 0);
        Shape1.addBox(-8F, 0F, -8F, 1, 16, 1);
        Shape1.setRotationPoint(0F, 4F, 0F);
        Shape1.setTextureSize(128, 128);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 66, 0);
        Shape2.addBox(7F, 0F, -8F, 1, 16, 1);
        Shape2.setRotationPoint(0F, 4F, 0F);
        Shape2.setTextureSize(128, 128);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 66, 0);
        Shape3.addBox(7F, 0F, 7F, 1, 16, 1);
        Shape3.setRotationPoint(0F, 4F, 0F);
        Shape3.setTextureSize(128, 128);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 66, 0);
        Shape4.addBox(-8F, 0F, 7F, 1, 16, 1);
        Shape4.setRotationPoint(0F, 4F, 0F);
        Shape4.setTextureSize(128, 128);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Floater = new ModelRenderer(this, 66, 27);
        Floater.addBox(0F, 0F, 0F, 2, 2, 2);
        Floater.setRotationPoint(-1F, 13F, -1F);
        Floater.setTextureSize(128, 128);
        Floater.mirror = true;
        setRotation(Floater, 0F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 66, 21);
        Shape6.addBox(0F, 0F, 0F, 2, 3, 2);
        Shape6.setRotationPoint(-1F, 8F, -1F);
        Shape6.setTextureSize(128, 128);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 66, 32);
        Shape5.addBox(0F, 0F, 0F, 2, 3, 2);
        Shape5.setRotationPoint(-1F, 17F, -1F);
        Shape5.setTextureSize(128, 128);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Base.render(f5);
        Top.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);

        Shape6.render(f5);
        Shape5.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void renderFloater(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Floater.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
