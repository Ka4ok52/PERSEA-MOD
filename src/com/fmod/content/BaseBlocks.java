package com.fmod.content;

import mindustry.content.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.world.*;
import mindustry.ctype.ContentList;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.production.*;

import static mindustry.type.ItemStack.with;

public class BaseBlocks implements ContentList {
    public static Block
            CarbonfiberCrafter, CompositeCrafter, OpticalfiberCrafter, CompositeWall, LargeCompositeWall, OilOffice;

    @Override
    public void load() {
        CarbonfiberCrafter = new GenericCrafter("carbonfiber-crafter") {{
            requirements(Category.crafting, with(Items.copper, 200, Items.lead, 150, Items.silicon, 55, Items.titanium, 60));
            description = "oh no";
            health = 280;
            hasItems = true;
            hasPower = true;
            itemCapacity = 10;
            outputItem = new ItemStack(BasicItems.carbon_fiber, 1);
            size = 2;

            consumes.items(with(BasicItems.carbon, 2));
            consumes.power(2f);
        }};
        CompositeCrafter = new GenericCrafter("composite-crafter") {{
            requirements(Category.crafting, with(Items.copper, 200, Items.lead, 100, Items.silicon, 60, Items.titanium, 50, Items.thorium, 15));
            description = "oh no";
            health = 450;
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            itemCapacity = 10;
            outputItem = new ItemStack(BasicItems.composite, 1);
            size = 3;

            consumes.items(with(BasicItems.carbon_fiber, 3, BasicItems.fiberglass, 2));
            consumes.liquid(BasicLiquid.resin, 0.25f);
            consumes.power(3f);
        }};
        OpticalfiberCrafter = new GenericCrafter("opticalfiber-crafter") {{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
            description = "oh no";
            health = 240;
            hasItems = true;
            hasPower = true;
            itemCapacity = 5;
            outputItem = new ItemStack(BasicItems.fiberglass, 2);
            size = 2;

            consumes.items(with(Items.metaglass, 2));
            consumes.power(1f);
        }};
        OilOffice = new LiquidConverter("oil-office"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 100, Items.silicon, 40, Items.titanium, 40));
            description = "oh no";
            hasItems = true;
            hasPower = true;
            hasLiquids = true;
            outputItem = new ItemStack(BasicItems.carbon, 2);
            outputLiquid = new LiquidStack(BasicLiquid.gas, 0.5f);
            size = 3;

            consumes.liquid(Liquids.oil, 0.5f);
            consumes.item(Items.coal, 2);
            consumes.power(1f);
        }};
        CompositeWall = new Wall("composite-wall") {{
            requirements(Category.defense, with(BasicItems.composite, 8));
            description = "A wall made of 100% composite, it will withstand any enemy!";
            health = 960;
            size = 1;
        }};
        LargeCompositeWall = new Wall("large-composite-wall") {{
            requirements(Category.defense, with(BasicItems.composite, 24));
            description = "A wall made of 100% composite, it will withstand any enemy!";
            health = 4000;
            size = 2;
        }};
    }
}
