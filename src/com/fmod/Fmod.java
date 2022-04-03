package com.fmod;

import arc.util.*;
import com.fmod.content.*;
import mindustry.mod.*;
import mindustry.ctype.ContentList;
import mindustry.world.Block;
import mindustry.world.draw.*;

public class Fmod extends Mod{

    public ContentList[] tiContent = {
            new FItems(),
            new FLiquids(),
            new FBlocks()
    };

    public Fmod(){
        Log.info("Loaded FMOD constructor.");
    }

     @Override
     public void loadContent(){
         for (var v : tiContent) {
             v.load();
         }
     }
}
