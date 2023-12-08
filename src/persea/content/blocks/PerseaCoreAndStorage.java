package persea.content.blocks;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;
import persea.content.PerseaItems;
import persea.content.PerseaUnits;

import static mindustry.type.ItemStack.with;

public class PerseaCoreAndStorage {
    public static Block coreHope;
    public static void load() {
        coreHope = new CoreBlock("core-hope"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with( PerseaItems.aluminum, 2000, PerseaItems.cobalt, 800));
            alwaysUnlocked = true;
            squareSprite = false;
            isFirstTier = true;
            unitType = PerseaUnits.omega;
            health = 4000;
            itemCapacity = 6000;
            size = 4;
            unitCapModifier = 8;
            envEnabled ^= Env.space;
        }};
    }
}