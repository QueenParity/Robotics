package com.queenparity.robotics;

import com.google.common.collect.ImmutableSet;
import com.queenparity.robotics.init.ModBlockEntities;
import com.queenparity.robotics.init.ModBlocks;
import com.queenparity.robotics.init.ModEntities;
import com.queenparity.robotics.init.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Robotics implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String ID = "robotics";
    public static final Logger LOGGER = LoggerFactory.getLogger("robotics");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModBlocks.initialize();
		ModItems.initialize();
		ModBlockEntities.initialize();
		ModEntities.initialize();

		LOGGER.info("Hello Fabric world!");
	}

	private static Set<BlockState> getStatesOfBlock(Block block)
	{
		return ImmutableSet.copyOf(block.getStateManager().getStates());
	}

	//public static final Activity WALK_TOWARDS_LOG = Registry.register(Registries.ACTIVITY, Identifier.of(ID, "walk_towards_log"), new Activity("walk_towards_log"));
	//public static final RegistryKey<PointOfInterestType> LOG_KEY = RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), Identifier.of(ID, "log"));
	//public static final PointOfInterestType LOG = Registry.register(Registries.POINT_OF_INTEREST_TYPE, Identifier.of(ID, "log"), new PointOfInterestType(getStatesOfBlock(Blocks.EMERALD_BLOCK), 32, 100));

	//public static final MemoryModuleType<GlobalPos> LOG_POS = Registry.register(Registries.MEMORY_MODULE_TYPE, Identifier.of(ID, "log_pos"), new MemoryModuleType<GlobalPos>(Optional.of(GlobalPos.CODEC)));
}