package com.fmod.content;

import arc.graphics.*;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class FItems implements ContentList{
    public static Item
             carbon, carbon_fiber, composite, fiberglass, cryenerRaw, eneringot;
    @Override
    public void load(){
        carbon = new Item("carbon",Color.valueOf("1a1919")){{
            cost = 0.3f;
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        carbon_fiber = new Item("carbon-fiber",Color.valueOf("313131")){{
            cost = 0.4f;
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        composite = new Item("composite",Color.valueOf("#272626")){{
            cost = 0.5f;
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        fiberglass = new Item("fiberglass",Color.valueOf("999999")){{
            cost = 0.2f;
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        cryenerRaw = new Item("cryenerRaw",Color.valueOf("0f0f0f")){{
            cost = 0.3f;
            hardness = 4;
            charge = 0.5f;
            radioactivity = 0;
            flammability = 0;
            alwaysUnlocked = true;
        }};
        eneringot = new Item("eneringot"){{
            cost = 0.3f;
            alwaysUnlocked = true;
            charge = 1.2f;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
    }
}
