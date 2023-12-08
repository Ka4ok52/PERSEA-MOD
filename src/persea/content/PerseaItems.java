package persea.content;

import arc.graphics.*;
import arc.struct.Seq;
import mindustry.type.*;

import static mindustry.content.Items.*;

public class PerseaItems {
    public static Item
    //Item
    aluminum, cobalt, cobaltglass, tantalum, energyCrystal, carbon, carbonFiber, fiberglass, composite, enrichedThorium, energyAlloy, avocado,
    //Rocket
    incendiaryRocket, explosiveRocket, fragBomb, rocketEMP, nuclearRocket;

    public static final Seq<Item> perseaItems = new Seq<>();

    public static void load(){
        //Item
        aluminum = new Item("aluminum",Color.valueOf("808f95")){{
            alwaysUnlocked = true;
            cost = 0.5f;
            hardness = 2;
        }};
        cobalt = new Item("cobalt",Color.valueOf("4456dc")){{
            cost = 0.7f;
            hardness = 3;
        }};
        cobaltglass = new Item("cobaltglass", Color.valueOf("d5eeff")){{cost = 1.5f;}};
        tantalum = new Item("tantalum",Color.valueOf("07ab8a")){{
            hardness = 4;
            cost = 1f;
        }};
        energyCrystal = new Item("crystal-energy",Color.valueOf("fabf37")){{
            cost = 0.7f;
            hardness = 5;
            charge = 0.5f;
        }};
        carbon = new Item("carbon",Color.valueOf("1a1919")){{cost = 1.0f;}};
        carbonFiber = new Item("carbon-fiber",Color.valueOf("313131")){{cost = 1.2f;}};
        fiberglass = new Item("fiberglass",Color.valueOf("999999")){{cost = 1.2f;}};
        composite = new Item("composite",Color.valueOf("272626")){{cost = 1.5f;}};
        enrichedThorium = new Item("enriched-thorium",Color.valueOf("ff9db9")) {{
            radioactivity = 2f;
            charge = 0.5f;
        }};
        energyAlloy = new Item("energy-ingot",Color.valueOf("ffcd66")){{charge = 1.2f;}};
        avocado = new Item("avocado",Color.valueOf("30942c")){{alwaysUnlocked = true;}};
        //Rocket
        incendiaryRocket = new Item("incendiary-rocket"){{
            alwaysUnlocked = true;
            charge = 0.5f;
            flammability = 2;
        }};
        explosiveRocket = new Item("explosive-rocket",Color.valueOf("112233")){{
            alwaysUnlocked = true;
            charge = 0.5f;
            explosiveness = 2;
        }};
        fragBomb = new Item("frag-bomb"){{
            alwaysUnlocked = true;
            charge = 0.5f;
            explosiveness = 0.3f;
        }};
        rocketEMP = new Item("rocket-emp",Color.valueOf("112233")){{
            alwaysUnlocked = true;
            charge = 2;
        }};
        nuclearRocket = new Item("nuclear-rocket",Color.valueOf("112233")){{
            alwaysUnlocked = true;
            charge = 0.6f;
            explosiveness = 0.5f;
            radioactivity = 2;
        }};

        perseaItems.addAll(
                aluminum,cobalt,coal,sand,graphite,cobaltglass,silicon,fiberglass,carbon,carbonFiber,tantalum,composite,energyCrystal,thorium,surgeAlloy,energyAlloy,enrichedThorium
        );
    }
}
