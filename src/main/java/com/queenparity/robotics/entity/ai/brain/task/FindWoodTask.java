package com.queenparity.robotics.entity.ai.brain.task;

import com.google.common.collect.ImmutableMap;
import com.queenparity.robotics.Robotics;
import com.queenparity.robotics.entity.RobotEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.WalkTarget;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;

public class FindWoodTask extends MultiTickTask<RobotEntity>
{
    private final int SEARCH_RANGE = 10;
    private final float SPEED = 0.5F;
    private BlockPos currentTarget;
    //ImmutableList<PillarBlock> logs = ImmutableList.of(Blocks.OAK_LOG, Blocks.SPRUCE_LOG, Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG, Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG

    public FindWoodTask()
    {
        super(ImmutableMap.of(
                //MemoryModuleType.LOOK_TARGET, MemoryModuleState.VALUE_ABSENT,
                MemoryModuleType.WALK_TARGET, MemoryModuleState.VALUE_ABSENT));
    }

    @Override
    protected boolean shouldRun(ServerWorld world, RobotEntity robotEntity)
    {
        if(world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING))
        {
            for(BlockPos blockPos : BlockPos.iterateOutwards(robotEntity.getBlockPos(), SEARCH_RANGE, SEARCH_RANGE, SEARCH_RANGE))
            {
                if(world.getBlockState(blockPos).isOf(Blocks.OAK_LOG))
                {
                    currentTarget = blockPos;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void run(ServerWorld world, RobotEntity robotEntity, long time)
    {
        Robotics.LOGGER.info("FindLog:run, " + currentTarget.getX() + ", " + currentTarget.getY() + ", " + currentTarget.getZ());
        //robotEntity.getBrain().remember(MemoryModuleType.LOOK_TARGET, new BlockPosLookTarget(currentTarget));
        robotEntity.getBrain().remember(MemoryModuleType.WALK_TARGET, new WalkTarget(currentTarget, SPEED, 0));
    }

    @Override
    protected void keepRunning(ServerWorld world, RobotEntity robotEntity, long time)
    {
        Robotics.LOGGER.info("FindLog:keepRunning, " + currentTarget.getX() + ", " + currentTarget.getY() + ", " + currentTarget.getZ());
        robotEntity.getBrain().remember(MemoryModuleType.WALK_TARGET, new WalkTarget(currentTarget, SPEED, 0));
    }

    @Override
    protected boolean shouldKeepRunning(ServerWorld world, RobotEntity robotEntity, long time)
    {
        /*if(robotEntity.getBrain().hasMemoryModule(MemoryModuleType.WALK_TARGET))
        {
            Robotics.LOGGER.info("FindLog:shouldKeepRunning:False");
            return false;
        }
        Robotics.LOGGER.info("FindLog:shouldKeepRunning:True");*/
        return true;
    }
}
