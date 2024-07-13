package com.queenparity.robotics.init;

import com.queenparity.robotics.Robotics;
import com.queenparity.robotics.blockentity.RobotDockBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities
{
    //Instantiate block entities
    public static final BlockEntityType<RobotDockBlockEntity> ROBOT_DOCK_BLOCK_ENTITY = register("robot_dock_block_entity", RobotDockBlockEntity::new, ModBlocks.ROBOT_DOCK);

    //Initialize class
    public static void initialize()
    {

    }

    //Register block entity with game and return
    public static <T extends BlockEntity, U extends Block> BlockEntityType<T> register(String name, BlockEntityType.BlockEntityFactory<T> factory, U block)
    {
        //Identifier with format "modid:name"
        Identifier id = Identifier.of(Robotics.ID, name);
        //Register it with the game using some builder I have to use, return it registered
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, BlockEntityType.Builder.create(factory, block).build());
    }
}
