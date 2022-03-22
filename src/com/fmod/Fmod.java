package com.fmod;

import arc.util.*;
import com.fmod.content.BasicItems;
import com.fmod.content.BasicLiquid;
import com.fmod.content.BaseBlocks;
import mindustry.mod.*;
import mindustry.ctype.ContentList;

public class Fmod extends Mod{

    public ContentList[] tiContent = {
            new BasicItems(),
            new BasicLiquid(),
            new BaseBlocks()
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
