package fmod.content;

import arc.graphics.*;
import mindustry.type.*;

public class FLiquids{
    public static Liquid resin, catalyst, AssociatedPetroleumGas;

    public static void load() {
        AssociatedPetroleumGas = new Liquid("associated-petroleum-gas", Color.valueOf("7c539e")) {
            {
                gas = true;
                flammability = 1.2f;
                temperature = 0.5f;
                heatCapacity = 0.3f;
                explosiveness = 2f;
            }
        };
        resin = new Liquid("resin", Color.valueOf("946c00")) {
            {
                flammability = 0.01f;
                temperature = 0.6f;
                heatCapacity = 0.8f;
                viscosity = 0.9f;
                explosiveness = 0f;
            }
        };
        catalyst = new Liquid("catalyst", Color.valueOf("27958f")) {
            {
                heatCapacity = 0.4f;
                temperature = 0.4f;
            }
        };
    }

}
