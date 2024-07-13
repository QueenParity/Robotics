package com.queenparity.robotics.blockentity;

import com.queenparity.robotics.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class RobotDockBlockEntity extends BlockEntity implements Inventory
{
    public RobotDockBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.ROBOT_DOCK_BLOCK_ENTITY, pos, state);
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public ItemStack getStack(int slot)
    {
        return null;
    }

    @Override
    public ItemStack removeStack(int slot, int amount)
    {
        return null;
    }

    @Override
    public ItemStack removeStack(int slot)
    {
        return null;
    }

    @Override
    public void setStack(int slot, ItemStack stack)
    {

    }

    @Override
    public boolean canPlayerUse(PlayerEntity player)
    {
        return false;
    }

    @Override
    public void clear()
    {

    }
}
