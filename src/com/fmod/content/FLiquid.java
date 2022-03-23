package com.fmod.content;

import arc.graphics.*;
import mindustry.ctype.ContentList;
import mindustry.type.Liquid;

public class FLiquid implements ContentList{
    public static Liquid
             gas, resin;
    @Override
    public void load(){
        gas = new Liquid("gas",Color.valueOf("c8a2c8")){{
            description = "Огнеопасно!!!";
            flammability = 1.2f;
            temperature = 0.4f;
            heatCapacity = 0.3f;
            viscosity = 0.2f;
            explosiveness = 2;
        }};
        resin = new Liquid("resin",Color.valueOf("946c00")){{
            description = "Очень вязкая жидкость. Кажись её невозожно смыть.";
            flammability =0;
            temperature = 0.5f;
            heatCapacity = 0.2f;
            viscosity = 0.9f;
            explosiveness = 0;
        }};
    }

}
