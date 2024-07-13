package com.queenparity.robotics.init;

import com.queenparity.robotics.Robotics;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class ModItems
{
    public static ArrayList<Item> MOD_ITEMS = new ArrayList<Item>();
    
    //Instantiate item group and key, WHY DO YOU NEED A KEY???
    public static final RegistryKey<ItemGroup> TAB_ROBOTICS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Robotics.ID, "item_group"));
    public static final ItemGroup TAB_ROBOTICS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.TEMP_ITEM))
            .displayName(Text.translatable("itemGroup.tabRobotics"))
            .build();
    
    //Instantiate items
    public static final Item TEMP_ITEM = register("temp_item", new Item(new Item.Settings()));

    
    //Initialize class and game loading registries
    public static void initialize()
    {
        //Register item group
        Registry.register(Registries.ITEM_GROUP, TAB_ROBOTICS_KEY, TAB_ROBOTICS);
        //Register item and block items into item group
        ItemGroupEvents.modifyEntriesEvent(TAB_ROBOTICS_KEY).register(itemGroup -> MOD_ITEMS.forEach(itemGroup::add));
        ItemGroupEvents.modifyEntriesEvent(TAB_ROBOTICS_KEY).register(itemGroup -> ModBlocks.MOD_BLOCKS.forEach(block -> itemGroup.add(block.asItem())));
    }

    //Register item with game and return
    public static <T extends Item> T register(String name, T item)
    {
        //Identifier with format "modid:name"
        Identifier id = Identifier.of(Robotics.ID, name);
        //Register item
        T registeredItem = Registry.register(Registries.ITEM, id, item);
        //Add item to list to be added to item group
        MOD_ITEMS.add(registeredItem);
        //Return registered item for reference
        return registeredItem;
    }
}