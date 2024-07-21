package com.queenparity.robotics.entity;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Dynamic;
import com.queenparity.robotics.entity.ai.brain.RobotBrain;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class RobotEntity extends PathAwareEntity
{
    private static final ImmutableList<MemoryModuleType<?>> MEMORY_MODULES = ImmutableList.of(
            MemoryModuleType.WALK_TARGET,
            MemoryModuleType.LOOK_TARGET,
            MemoryModuleType.PATH,
            MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE
    );
    private static final ImmutableList<SensorType<? extends Sensor<? super RobotEntity>>> SENSORS = ImmutableList.of(
            SensorType.NEAREST_LIVING_ENTITIES,
            SensorType.NEAREST_PLAYERS,
            SensorType.NEAREST_ITEMS,
            SensorType.HURT_BY
    );
    /*public static final Map<MemoryModuleType<GlobalPos>, BiPredicate<RobotEntity, RegistryEntry<PointOfInterestType>>> POINTS_OF_INTEREST = ImmutableMap.of(
            Robotics.LOG_POS,
            (robot, registryEntry) -> registryEntry.matchesKey(Robotics.LOG_KEY)
    );*/
    public RobotEntity(EntityType<? extends RobotEntity> type, World world)
    {
        super(type, world);
    }

    @Override
    public Brain<RobotEntity> getBrain()
    {
        return (Brain<RobotEntity>) super.getBrain();
    }

    @Override
    protected Brain.Profile<RobotEntity> createBrainProfile()
    {
        return Brain.createProfile(MEMORY_MODULES, SENSORS);
    }

    @Override
    protected Brain<?> deserializeBrain(Dynamic<?> dynamic)
    {
        return RobotBrain.create(this.createBrainProfile().deserialize(dynamic));
    }

    /*public void reinitializeBrain(ServerWorld world)
    {
        Brain<RobotEntity> brain = this.getBrain();
        brain.stopAllTasks(world, this);
        this.brain = brain.copy();
        this.initBrain(this.getBrain());
    }*/

    @Override
    protected void mobTick()
    {
        this.getWorld().getProfiler().push("robotBrain");
        this.getBrain().tick((ServerWorld) this.getWorld(), this);
        this.getWorld().getProfiler().pop();

        this.getWorld().getProfiler().push("robotActivityUpdate");
        RobotBrain.updateActivities(this);
        this.getWorld().getProfiler().pop();

        super.mobTick();
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt)
    {
        super.writeCustomDataToNbt(nbt);

    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt)
    {
        super.readCustomDataFromNbt(nbt);
    }
}