package com.fmod.content;

import arc.graphics.*;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class BasicItems implements ContentList{
    public static Item
             carbon, carbon_fiber, composite, fiberglass;
    @Override
    public void load(){
        carbon = new Item("carbon",Color.valueOf("1a1919")){{
            localizedName = "";
            description = "Кусок чистого углерода.";
            cost = 0.2f;
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        carbon_fiber = new Item("carbon_fiber",Color.valueOf("313131")){{
            description = "Гибкие углеродные нити.";
            cost = 0.2f;
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        composite = new Item("composite",Color.valueOf("#272626")){{
            description = "Вещетво одновременно гибкое и твёрдое на ощупь.";
            cost = 0.3f;
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
        fiberglass = new Item("fiberglass",Color.valueOf("999999")){{
            description = "Плетеная ткань из чистого стекла.";
            cost = 0.2f;
            alwaysUnlocked = true;
            explosiveness = 0;
            flammability = 0;
            radioactivity = 0;
        }};
    }
}
