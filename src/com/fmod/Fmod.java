package com.fmod;

import arc.util.*;
import com.fmod.content.FItems;
import com.fmod.content.FLiquid;
import com.fmod.content.FBlocks;
import mindustry.mod.*;
import mindustry.ctype.ContentList;

public class Fmod extends Mod{

    public ContentList[] tiContent = {

            new FItems(),
            new FLiquid(),
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
