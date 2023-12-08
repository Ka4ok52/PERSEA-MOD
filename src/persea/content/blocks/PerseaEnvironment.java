package persea.content.blocks;

import mindustry.content.Items;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.Prop;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.environment.TreeBlock;
import mindustry.world.meta.Attribute;
import persea.world.meta.PerseaAttribute;

import static mindustry.content.Blocks.shale;

public class PerseaEnvironment {
    public static Block
    //Floor
    dune,thickets,earth,marble,granite,polishedGraniteFloor,
    //Wall
    duneWall,thicketsWall,earthWall,marbleWall,pallidMarbleWall,graniteWall,pallidGraniteWall,
    //Ore
    oreCoalWall,oreGraphiteWall,
    //Props
    avocadoTree,smallAvocadoTree,deadTreeAvocado,smallDeadTreeAvocado,flowers,blueFlowers;
    public static void load() {
        //Floor
        dune = new Floor("dune"){{
            itemDrop = Items.sand;
            playerUnmineable = true;
            attributes.set(Attribute.oil, 0.9f);
            variants = 4;
        }};
        thickets = new Floor("thickets"){{
            attributes.set(PerseaAttribute.prolific, 0.112f);
            variants = 4;
        }};
        earth = new Floor("earth"){{variants = 4;}};
        marble = new Floor("marble"){{variants = 4;}};
        granite = new Floor("granite"){{variants = 4;}};
        polishedGraniteFloor = new Floor("polished-granite-floor"){{variants = 3;}};
        //Wall
        duneWall = new StaticWall("dune-wall"){{attributes.set(Attribute.sand, 2f);}};
        thicketsWall = new StaticWall("thickets-wall");
        earthWall = new StaticWall("earth-wall");
        marbleWall = new StaticWall("marble-wall");
        pallidMarbleWall = new StaticWall("pallid-marble-wall");
        graniteWall = new StaticWall("granite-wall");
        pallidGraniteWall = new StaticWall("pallid-granite-wall");
        //WallOre
        oreCoalWall = new StaticWall("coal-wall"){{
            itemDrop = Items.coal;
            variants = 3;
        }};
        oreGraphiteWall = new StaticWall("graphite-wall"){{
            itemDrop = Items.graphite;
            variants = 3;
        }};
        //Props
        avocadoTree = new TreeBlock("avocado-tree");
        smallAvocadoTree = new TreeBlock("small-avocado-tree");
        deadTreeAvocado = new TreeBlock("dead-tree-avocado");
        smallDeadTreeAvocado = new TreeBlock("small-dead-tree-avocado");
        flowers = new Prop("flowers"){{
            variants = 3;
            shale.asFloor().decoration = this;
            hasShadow = false;
        }};
        blueFlowers = new Prop("blue-flowers"){{
            variants = 3;
            shale.asFloor().decoration = this;
            hasShadow = false;
        }};
    }
}