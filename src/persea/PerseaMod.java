package persea;

import arc.util.*;
import persea.content.*;
import mindustry.mod.*;

public class PerseaMod extends Mod{
    public PerseaMod(){
        Log.info("Call loadContent in F-MOD loader.");
        Log.info("I LOVE AVOCADO");
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
        //PerseaPlanets.load();
    }
}