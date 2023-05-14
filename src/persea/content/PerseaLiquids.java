package persea.content;

import arc.graphics.*;
import mindustry.type.*;

public class PerseaLiquids {
    public static Liquid associatedPetroleumGas, steam, masut, oilWaste, catalyst, resin;

    public static void load() {
        associatedPetroleumGas = new Liquid("associated-petroleum-gas", Color.valueOf("7c539e")) {{
            gas = true;
            flammability = 1.2f;
            temperature = 0.5f;
            heatCapacity = 0.3f;
            explosiveness = 2f;
        }};
        steam = new Liquid("steam", Color.valueOf("f0f0f0")) {{
            gas = true;
            temperature = 1f;
            heatCapacity = 0.3f;
        }};
        masut = new Liquid("masut", Color.valueOf("0d151f")){{
            flammability = 0.01f;
            temperature = 0.7f;
            heatCapacity = 0.8f;
            viscosity = 0.9f;
        }};
        oilWaste = new Liquid("oil-waste", Color.valueOf("7a483f")) {{
            temperature = 0.5f;
            heatCapacity = 0f;
            viscosity = 0.9f;
        }};
        resin = new Liquid("resin", Color.valueOf("946c00")) {{
            flammability = 0.01f;
            temperature = 0.6f;
            viscosity = 0.8f;
        }};
        catalyst = new Liquid("catalyst", Color.valueOf("27958f")) {{
            heatCapacity = 0.4f;
            temperature = 0.4f;
        }};
    }

}
