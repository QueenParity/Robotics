package com.queenparity.robotics;

import com.queenparity.robotics.init.ModEntities;
import com.queenparity.robotics.renderer.entity.RobotEntityRenderer;
import com.queenparity.robotics.renderer.entity.model.RobotEntityModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class RoboticsClient implements ClientModInitializer
{
	public static final EntityModelLayer ROBOT_ENTITY_MODEL = new EntityModelLayer(Identifier.of(Robotics.ID, "robot_entity_model"), "main");
	@Override
	public void onInitializeClient()
	{
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		EntityRendererRegistry.register(ModEntities.ROBOT_ENTITY, RobotEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(ROBOT_ENTITY_MODEL, RobotEntityModel::getTexturedModelData);
	}
}