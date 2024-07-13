package com.queenparity.robotics;

import com.queenparity.robotics.init.ModBlockEntities;
import com.queenparity.robotics.init.ModBlocks;
import com.queenparity.robotics.init.ModEntities;
import com.queenparity.robotics.init.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}