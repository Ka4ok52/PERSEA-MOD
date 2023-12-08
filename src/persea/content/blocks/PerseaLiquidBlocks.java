package persea.content.blocks;

import arc.graphics.Color;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.production.Pump;
import persea.content.PerseaItems;

import static mindustry.type.ItemStack.with;

public class PerseaLiquidBlocks {
    public static Block liquidPipe, liquidPipeJunction, liquidPipeRouter, pipeBridgeConduit, tank, capillaryPump, pneumaticPump;
    public static void load() {
        liquidPipe = new ArmoredConduit("liquid-pipe"){{
            botColor = Color.valueOf("565666"); //hmm
            leaks = true;
            liquidCapacity = 20f;
            liquidPressure = 1.1f;
            researchCostMultiplier = 0.3f;
            underBullets = true;

            requirements(Category.liquid, with(PerseaItems.aluminum, 10));
        }};
        liquidPipeJunction = new LiquidJunction("liquid-pipe-junction"){{
            buildCostMultiplier = 3f;
            health = 320;
            researchCostMultiplier = 0.3f;
            solid = false;
            underBullets = true;

            ((Conduit)liquidPipe).junctionReplacement = this;
            requirements(Category.liquid, with(PerseaItems.aluminum, 10));
        }};
        liquidPipeRouter = new LiquidRouter("liquid-pipe-router"){{
            liquidCapacity = 30f;
            liquidPadding = 1.0f;
            researchCostMultiplier = 0.3f;
            underBullets = true;
            solid = false;

            requirements(Category.liquid, with(PerseaItems.aluminum, 10));
        }};
        pipeBridgeConduit = new LiquidBridge("pipe-bridge-conduit"){{
            range = 5;
            hasPower = false;
            researchCostMultiplier = 0.3f;
            underBullets = true;
            arrowSpacing = 6f;

            ((Conduit)liquidPipe).rotBridgeReplacement = this;
            requirements(Category.liquid, with(PerseaItems.aluminum, 10));
        }};
        capillaryPump = new Pump("capillary-pump"){{
            squareSprite = false;
            pumpAmount = 7f / 60f;
            liquidCapacity = 60f;
            researchCostMultiplier = 0.3f;
            size = 1;

            requirements(Category.liquid, with(PerseaItems.aluminum, 10, PerseaItems.cobalt, 2));
        }};
        pneumaticPump = new Pump("pneumatic-pump"){{
            squareSprite = false;
            pumpAmount = 10f / 60f;
            liquidCapacity = 140f;
            researchCostMultiplier = 0.3f;
            size = 2;

            consumePower(1.5f / 3f);
            requirements(Category.liquid, with(PerseaItems.aluminum, 10));
        }};
        tank = new LiquidRouter("tank") {{
            liquidCapacity = 3545f;
            size = 2;
            liquidPadding = 1.0f;
            researchCostMultiplier = 0.3f;
            squareSprite = false;
            underBullets = true;

            requirements(Category.liquid, with(PerseaItems.aluminum, 10));
        }};
    }
}