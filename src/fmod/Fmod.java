package fmod;

import arc.util.*;
import fmod.content.*;
import mindustry.mod.*;

public class Fmod extends Mod{
    public Fmod(){
        Log.info("Call loadContent in F-MOD loader.");
        Log.info("YOU SUS!!!!");
    }
    @Override
    public void init() {
        // sometime i use it
    }
    @Override
    public void loadContent(){
        FStatuses.load();
        FItems.load();
        FLiquids.load();
        FBullets.load();
        FUnits.load();
        FBlocks.load();
        FPlanets.load();
    }
}