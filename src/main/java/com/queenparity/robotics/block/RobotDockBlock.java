package com.queenparity.robotics.block;

import com.mojang.serialization.MapCodec;
import com.queenparity.robotics.blockentity.RobotDockBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class RobotDockBlock extends BlockWithEntity
{
    public static final MapCodec<RobotDockBlock> CODEC = createCodec(RobotDockBlock::new);

    public RobotDockBlock(AbstractBlock.Settings settings)
    {
        super(settings);
    }

    @Override
    protected MapCodec<RobotDockBlock> getCodec()
    {
        return CODEC;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state)
    {
        return new RobotDockBlockEntity(pos, state);
    }
}
