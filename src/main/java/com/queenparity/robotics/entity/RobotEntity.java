package com.queenparity.robotics.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class RobotEntity extends Entity
{
    public RobotEntity(EntityType<? extends RobotEntity> type, World world)
    {
        super(type, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder)
    {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt)
    {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt)
    {

    }
}