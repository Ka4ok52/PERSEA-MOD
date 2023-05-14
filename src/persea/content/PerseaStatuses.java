package persea.content;

import persea.graphics.*;
import persea.type.statuses.*;
import mindustry.type.*;

public class PerseaStatuses {
    public static StatusEffect empty, corrosion;

    public static void load(){
        empty = new StatusEffect("empty");
        corrosion = new CorrosionEffect("corrosion"){{color = PerseaPal.toxicGreen;}};
    }
}
