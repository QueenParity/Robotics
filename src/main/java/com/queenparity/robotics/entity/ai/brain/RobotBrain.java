package com.queenparity.robotics.entity.ai.brain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.queenparity.robotics.entity.RobotEntity;
import com.queenparity.robotics.entity.ai.brain.task.FindWoodTask;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;

public class RobotBrain
{
    public static Brain<?> create(Brain<RobotEntity> brain)
    {
        addCoreActivities(brain);
        brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
        brain.setDefaultActivity(Activity.IDLE);
        brain.resetPossibleActivities();
        return brain;
    }

    private static void addCoreActivities(Brain<RobotEntity> brain)
    {
        brain.setTaskList(
                Activity.CORE,
                0,
                ImmutableList.of(
                        new FindWoodTask()
                )
        );
    }

    public static void updateActivities(RobotEntity robotEntity)
    {
        robotEntity.getBrain().resetPossibleActivities(ImmutableList.of(Activity.CORE));
    }
}