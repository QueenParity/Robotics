package com.queenparity.robotics.renderer.entity;

import com.queenparity.robotics.RoboticsClient;
import com.queenparity.robotics.entity.RobotEntity;
import com.queenparity.robotics.renderer.entity.model.RobotEntityModel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class RobotEntityRenderer extends EntityRenderer<RobotEntity>
{
    private final RobotEntityModel model;

    public RobotEntityRenderer(EntityRendererFactory.Context ctx)
    {
        super(ctx);
        this.shadowRadius = 0.5F;
        this.model = new RobotEntityModel(ctx.getPart(RoboticsClient.ROBOT_ENTITY_MODEL));
    }

    @Override
    public void render(RobotEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumerProvider, int light)
    {
        matrices.push();
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        boolean bl = !entity.isInvisible();
        boolean bl2 = !bl && !entity.isInvisibleTo(minecraftClient.player);
        boolean bl3 = minecraftClient.hasOutline(entity);
        RenderLayer renderLayer = this.getRenderLayer(entity, bl, bl2, bl3);
        if(renderLayer != null)
        {
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(renderLayer);
            this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
        }
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumerProvider, light);
    }

    @Nullable
    protected RenderLayer getRenderLayer(RobotEntity entity, boolean showBody, boolean translucent, boolean showOutline)
    {
        Identifier identifier = this.getTexture(entity);
        if(translucent)
        {
            return RenderLayer.getItemEntityTranslucentCull(identifier);
        }
        else if(showBody)
        {
            return this.model.getLayer(identifier);
        }
        else
        {
            return showOutline ? RenderLayer.getOutline(identifier) : null;
        }
    }

    @Override
    public Identifier getTexture(RobotEntity entity)
    {
        return Identifier.ofVanilla("textures/block/netherite_block.png");
    }
}
