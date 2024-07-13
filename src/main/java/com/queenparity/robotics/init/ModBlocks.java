package com.queenparity.robotics.init;

import com.queenparity.robotics.Robotics;
import com.queenparity.robotics.block.RobotDockBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class ModBlocks
{
    public static ArrayList<Block> MOD_BLOCKS = new ArrayList<Block>();

    //Instantiate blocks
    public static final Block ROBOT_DOCK = register("robot_dock", new RobotDockBlock(AbstractBlock.Settings.create().strength(0.5F).sounds(BlockSoundGroup.NETHERITE)));

    //Initialize class
    public static void initialize()
    {

    }

    //Register block with default shouldRegisterItem=true because java << C++
    public static <T extends Block> T register(String name, T block)
    {
        return register(name, block, true);
    }

    //Register block with game and return
    public static <T extends Block> T register(String name, T block, boolean shouldRegisterItem)
    {
        //Identifier with format "modid:name"
        Identifier id = Identifier.of(Robotics.ID, name);
        //Registers item
        if(shouldRegisterItem)
        {
            Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        }
        //Register block
        T registeredBlock = Registry.register(Registries.BLOCK, id, block);
        //Add block to list to be added to item group
        MOD_BLOCKS.add(registeredBlock);
        //Return registered block for reference
        return registeredBlock;
    }
}
