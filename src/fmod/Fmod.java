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
    public void loadContent(){
        FItems.load();
        FLiquids.load();
        FBlocks.load();
        FUnitTypes.load();
    }
}