package fmod.content;

import arc.graphics.*;
import mindustry.type.*;

public class FItems{
    public static Item
    //lmao avocado
    avocado, carbon, carbonFiber, fiberglass, composite, enrichedThorium, energyIngot, rocketBase, rocketEMP, explosiveRocket, nuclearRocket, cryEnergyRaw;
    public static void load(){
        avocado = new Item("avocado",Color.valueOf("30942c")){{
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        carbon = new Item("carbon",Color.valueOf("1a1919")){{
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        carbonFiber = new Item("carbon-fiber",Color.valueOf("313131")){{
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        fiberglass = new Item("fiberglass",Color.valueOf("999999")){{
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        composite = new Item("composite",Color.valueOf("272626")){{
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        enrichedThorium = new Item("enriched-thorium",Color.valueOf("ff9db9")) {{
            alwaysUnlocked = true;
            radioactivity = 2f;
            charge = 0.5f;
        }};
        energyIngot = new Item("energy-ingot",Color.valueOf("ffcd66")){{
            alwaysUnlocked = true;
            charge = 1.2f;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        rocketBase = new Item("rocket-base",Color.valueOf("112233")){{
            alwaysUnlocked = true;
            charge = 0.2f;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        rocketEMP = new Item("rocket-emp",Color.valueOf("112233")){{
            alwaysUnlocked = true;
            charge = 2;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        explosiveRocket = new Item("explosive-rocket",Color.valueOf("112233")){{
            alwaysUnlocked = true;
            charge = 0.5f;
            explosiveness = 2;
            flammability = 0;
            radioactivity = 0;
        }};
        nuclearRocket = new Item("nuclear-rocket",Color.valueOf("112233")){{
            alwaysUnlocked = true;
            charge = 0.5f;
            explosiveness = 0.4f;
            flammability = 0;
            radioactivity = 2;
        }};
        //Ore Item
        cryEnergyRaw = new Item("ore-crystal-energy",Color.valueOf("ffffa3")){{
            cost = 0.3f;
            hardness = 5;
            charge = 0.5f;
            radioactivity = 0;
            flammability = 0;
            alwaysUnlocked = true;
        }};
    }
}