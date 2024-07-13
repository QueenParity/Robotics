package com.queenparity.robotics.init;

import com.queenparity.robotics.Robotics;
import com.queenparity.robotics.entity.RobotEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities
{
    //Instantiate entities
    public static final EntityType<RobotEntity> ROBOT_ENTITY = register("robot", RobotEntity::new);

    //Initialize class
    public static void initialize()
    {

    }

    //Register block entity with game and return
    public static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory)
    {
        //Identifier with format "modid:name"
        Identifier id = Identifier.of(Robotics.ID, name);
        //Register it with the game using some builder I have to use, return it registered
        return Registry.register(Registries.ENTITY_TYPE, id, EntityType.Builder.create(factory, SpawnGroup.AMBIENT).dimensions(0.375F, 0.375F).build());
    }
}