package persea.content.blocks;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.production.Drill;
import persea.content.PerseaItems;
import persea.content.PerseaLiquids;
import persea.world.blocks.production.MountMiner;

import static mindustry.type.ItemStack.with;

public class PerseaDrill {
    public static Block basicDrill, mountMiner, hammerDrill, toxicDrill;
    public static void load() {
        basicDrill = new Drill("basic-drill"){{
            tier = 3;
            drillTime = 600;
            size = 2;
            researchCost = with(PerseaItems.aluminum, 40);

            requirements(Category.production, with(PerseaItems.aluminum, 10));
            consumeLiquid(Liquids.water, 0.05f).boost();
        }};
        mountMiner = new MountMiner("mount-miner"){{
            size = 2;
            rotators = 1;
            rotatorsSideSpace = 0.8f;
            tier = 4;
            drillTime = 30 * 2.5f * 2f;
            researchCost = with(PerseaItems.aluminum, 400, PerseaItems.cobalt, 200);

            consumePower(0.5f);
            consumeLiquid(Liquids.water, 0.25f / 60f).boost();
            requirements(Category.production, with(PerseaItems.aluminum, 20, PerseaItems.cobalt, 20));
        }};
        hammerDrill = new Drill("hammer-drill"){{
            tier = 4;
            drillTime = 400;
            size = 3;
            researchCost = with(PerseaItems.aluminum, 120, Items.graphite, 80);

            requirements(Category.production, with(PerseaItems.aluminum, 20, Items.graphite, 10));
            consumePower(0.5f);
            consumeLiquid(Liquids.water, 0.06f).boost();
        }};
        toxicDrill = new Drill("toxicDrill-drill") {{
            drillTime = 4000;
            size = 3;
            hasPower = true;
            tier = 5;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;
            liquidBoostIntensity = 7.9f;

            requirements(Category.production, with(PerseaItems.cobalt, 40, PerseaItems.composite, 15, PerseaItems.fiberglass, 15));
            consumePower(1.10f);
            consumeLiquid(PerseaLiquids.catalyst, 0.25f).boost();
        }};
    }
}