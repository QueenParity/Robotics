package com.queenparity.robotics.entity.ai.brain.task;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.queenparity.robotics.entity.RobotEntity;
import net.minecraft.entity.ai.brain.task.Task;

public class RobotTaskListProvider
{
    public static ImmutableList<Pair<Integer, ? extends Task<? super RobotEntity>>> createTreeChopTask(float speed)
    {
        return ImmutableList.of(
                Pair.of(1, new FindWoodTask())
        );
    }
}