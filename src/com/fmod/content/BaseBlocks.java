package com.fmod.content;

import arc.graphics.*;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.ctype.ContentList;
import mindustry.world.blocks.production.GenericCrafter;
import static mindustry.type.ItemStack.with;

public class BaseBlocks implements ContentList{
    public static Block
             CarbonfiberCrafter,CompositeCrafter, OpticalfiberCrafter;
    @Override
    public void load() {
        CarbonfiberCrafter = new GenericCrafter("carbonfiber-crafter"){{
            requirements(Category.crafting, with(Items.copper, 90,Items.lead, 50));
            hasItems = true;
            hasPower = true;
            outputItem = new ItemStack(BasicItems.carbon_fiber, 1);
            size = 2;

            consumes.items(with(BasicItems.carbon, 2));
            consumes.power(2f);
        }};
        CompositeCrafter = new GenericCrafter("composite-crafter"){{
            requirements(Category.crafting, with(Items.copper, 90,Items.lead, 50));
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            outputItem = new ItemStack(BasicItems.composite, 1);
            size = 3;

            consumes.items(with(BasicItems.carbon_fiber, 3, BasicItems.fiberglass,2));
            consumes.liquid(BasicLiquid.resin,0.25f);
            consumes.power(2f);
        }};
        OpticalfiberCrafter = new GenericCrafter("opticalfiber-crafter"){{
            requirements(Category.crafting, with(Items.copper, 90,Items.lead, 50));
            hasItems = true;
            hasPower = true;
            outputItem = new ItemStack(BasicItems.fiberglass, 2);
            size = 2;

            consumes.items(with(Items.metaglass, 2));
            consumes.power(2f);
        }};
    }
}
