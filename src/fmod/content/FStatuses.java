package fmod.content;

import fmod.graphics.*;
import fmod.type.statuses.*;
import mindustry.type.*;

public class FStatuses {
    public static StatusEffect empty, corrosion;

    public static void load(){
        empty = new StatusEffect("empty");
        corrosion = new CorrosionEffect("corrosion"){{color = FPal.toxicGreen;}};
    }
}
