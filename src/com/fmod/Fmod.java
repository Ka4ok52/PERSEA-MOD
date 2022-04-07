package com.fmod;

import arc.util.*;
import com.fmod.content.*;
import mindustry.mod.*;
import mindustry.ctype.ContentList;

public class Fmod extends Mod{
    //loading game content into main class
    public ContentList[] tiContent = {
            new FItems(),
            new FLiquids(),
            new FBlocks()
    };
    //constructor
    public Fmod(){
        Log.info("Loaded FMOD constructor.");
    }
    //loading content into the game itself
    @Override
    public void loadContent(){
         for (var v : tiContent) {
             v.load();
         }
    }
}
