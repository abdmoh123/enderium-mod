package com.abdmoh.enderium.client.renders;

import com.abdmoh.enderium.Enderium;
import com.abdmoh.enderium.client.models.XEntityModel;
import com.abdmoh.enderium.entities.XEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class XEntityRender extends LivingRenderer<XEntity, XEntityModel> {
    public XEntityRender(EntityRendererManager manager) {
        super(manager, new XEntityModel(), 0.5F);
    }

    @Override
    protected boolean canRenderName(XEntity entity) {
        return false;
    }

    @Override
    protected ResourceLocation getEntityTexture(XEntity entity) {
        return new ResourceLocation(Enderium.MODID, "textures/entity/x_mob.png");
    }

    public static class RenderFactory implements IRenderFactory<XEntity> {

        @Override
        public EntityRenderer<? super XEntity> createRenderFor(EntityRendererManager manager) {
            return new XEntityRender(manager);
        }
    }
}
