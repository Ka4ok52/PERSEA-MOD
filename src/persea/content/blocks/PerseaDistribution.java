package persea.content.blocks;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import persea.content.PerseaItems;

import static mindustry.type.ItemStack.with;

public class PerseaDistribution {
    public static Block reinforcedConveyor, reinforcedRouter, reinforcedJunction, reinforcedSorter, reinforcedBridge, largeReinforcedRouter;
    public static void load() {
        reinforcedConveyor = new Conveyor("reinforced-conveyor"){{
            health = 50;
            speed = 0.0714285f;
            displayedSpeed = 10f; //to find out the displayed speed you need to multiply the conveyor speed by 140
            buildCostMultiplier = 2f;
            researchCost = with(PerseaItems.aluminum, 10);
            squareSprite = false;
            requirements(Category.distribution, with(PerseaItems.aluminum, 1));
        }};
        reinforcedRouter = new Router("reinforced-router") {{
            health = 45;
            researchCost = with(PerseaItems.aluminum, 20);
            buildCostMultiplier = 2f;
            speed = 12;
            squareSprite = false;
            requirements(Category.distribution, with(PerseaItems.aluminum, 4));
        }};
        reinforcedJunction = new Junction("reinforced-junction") {{
            health = 45;
            researchCost = with(PerseaItems.aluminum, 40);
            speed = 10;
            capacity = 4;
            health = 140;
            buildCostMultiplier = 2f;
            squareSprite = false;
            requirements(Category.distribution, with(PerseaItems.aluminum, 4));
        }};
        reinforcedSorter = new Sorter("reinforced-sorter"){{
            health = 45;
            researchCost = with(PerseaItems.aluminum, 40);
            buildCostMultiplier = 2f;
            squareSprite = false;
            requirements(Category.distribution, with(PerseaItems.cobalt, 2, PerseaItems.aluminum, 4));
        }};
        reinforcedBridge = new BufferedItemBridge("reinforced-bridge"){{
            fadeIn = moveArrows = false;
            range = 4;
            speed = 74f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
            requirements(Category.distribution, with(PerseaItems.cobalt, 8, PerseaItems.aluminum, 8));
        }};
        largeReinforcedRouter = new Router("large-reinforced-router") {{
            health = 80;
            researchCost = with(PerseaItems.aluminum, 60);
            speed = 20;
            size = 2;
            squareSprite = false;
            requirements(Category.distribution, with(PerseaItems.aluminum, 6));
        }};
    }
}