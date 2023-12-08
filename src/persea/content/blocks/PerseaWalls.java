package persea.content.blocks;

import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;
import persea.content.PerseaItems;

import static mindustry.type.ItemStack.with;

public class PerseaWalls {
    public static Block aluminumWall,largeAluminumWall,compositeWall,largeCompositeWall,energyWall,largeEnergyWall,avocadoBlock;
    public static void load() {
        aluminumWall = new Wall("aluminum-wall"){{
            health = 400;
            size = 1;
            envDisabled |= Env.scorching;
            requirements(Category.defense, with(PerseaItems.aluminum, 8));
        }};
        largeAluminumWall = new Wall("large-aluminum-wall"){{
            health = 400 * 4;
            size = 2;
            envDisabled |= Env.scorching;
            requirements(Category.defense, with(PerseaItems.aluminum, 28));
        }};
        compositeWall = new Wall("composite-wall") {{
            health = 960;
            size = 1;
            envDisabled |= Env.scorching;
            requirements(Category.defense, with(PerseaItems.composite, 12));
        }};
        largeCompositeWall = new Wall("large-composite-wall") {{
            health = 960 * 4;
            size = 2;
            envDisabled |= Env.scorching;
            requirements(Category.defense, with(PerseaItems.composite, 24));
        }};
        energyWall = new Wall("energy-wall") {{
            health = 890;
            size = 1;
            envDisabled |= Env.scorching;
            requirements(Category.defense, with(PerseaItems.energyAlloy, 12, PerseaItems.composite, 4));
        }};
        largeEnergyWall = new Wall("large-energy-wall") {{
            health = 890 * 4;
            size = 2;
            envDisabled |= Env.scorching;
            requirements(Category.defense, with(PerseaItems.energyAlloy, 24, PerseaItems.composite, 4));
        }};
        //sus
        avocadoBlock = new Wall("avocado-block"){{
            requirements(Category.effect, BuildVisibility.sandboxOnly, with(PerseaItems.avocado, 4));
            health = 69;
        }};
    }
}