package persea.content.blocks;

import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import persea.content.PerseaItems;

public class PerseaOre {
    public static Block oreAluminum, oreCobalt, oreTantalum,  oreCrystalEnergy;
    public static void load() {
        oreAluminum = new OreBlock(PerseaItems.aluminum) {{
            oreDefault = true;
            oreThreshold = 0.811f;
            oreScale = 24.580953f;
        }};
        oreCobalt = new OreBlock(PerseaItems.cobalt) {{
            oreDefault = true;
            oreThreshold = 0.821f;
            oreScale = 24.809531f;
        }};
        oreTantalum = new OreBlock(PerseaItems.tantalum) {{
            oreDefault = true;
            oreThreshold = 0.831f;
            oreScale = 25.580953f;
        }};
        oreCrystalEnergy = new OreBlock(PerseaItems.energyCrystal) {{
            oreDefault = true;
            oreThreshold = 0.841f;
            oreScale = 25.580953f;
        }};
        //Coal be here: persea.content.blocks.PerseaEnvironment.oreCoalWall;
        //Graphite be here: persea.content.blocks.PerseaEnvironment.oreGraphiteWall;
    }
}