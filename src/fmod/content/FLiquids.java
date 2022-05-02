package fmod.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.type.*;

public class FLiquids implements ContentList {
    public static Liquid gas, resin, catalyst;

    @Override
    public void load() {
        // gas? Hmmmmm.........
        gas = new Liquid("gas", Color.valueOf("c8a2c8")) {
            {
                flammability = 1.2f;
                temperature = 0.5f;
                heatCapacity = 0.3f;
                viscosity = 0.2f;
                explosiveness = 2f;
            }
        };
        resin = new Liquid("resin", Color.valueOf("946c00")) {
            {
                flammability = 0.01f;
                temperature = 0.6f;
                heatCapacity = 0.8f;
                viscosity = 0.9f;
                explosiveness = 0;
            }
        };
        catalyst = new Liquid("catalyst", Color.valueOf("27958f")) {
            {
                heatCapacity = 0.4f;
                temperature = 0.5f;
            }
        };
    }

}
