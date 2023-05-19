package persea;

import arc.util.*;
import persea.content.*;
import mindustry.mod.*;

public class PerseaMod extends Mod{
    public PerseaMod(){
        int i = 6*9+6+9;
        Log.info("Call loadContent in F-MOD loader.");
        Log.info("I LOVE AVOCADO");
        Log.info(i);
    }
    @Override
    public void init() {
        // sometime i use it
    }
    @Override
    public void loadContent(){
        PerseaStatuses.load();
        PerseaItems.load();
        PerseaLiquids.load();
        PerseaBullets.load();
        PerseaUnits.load();
        PerseaBlocks.load();
        //PerseaSectors.load();
        PerseaPlanets.load();
    }
}