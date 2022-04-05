package com.fmod.content;

import arc.util.Log;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.gen.Building;
import mindustry.world.*;
import mindustry.world.meta.Env;


public class PizdecSource extends Block {
    public double pizdecPerSecond = 1.0f;
    public PizdecSource(String name){
        super(name);
        // инициализация переменных блока, зависит уже от создателя мода
        update = true;
        schematicPriority = 3;
        envEnabled = Env.any;
    }

    public class PizdecSourceBuild extends Building {
        public void updateTile(){ // обновление блока каждый кадр
            health -= pizdecPerSecond / 60f * Time.delta;
        }
        public void write(Writes write){ // как сохранять блок?
            super.write(write);
            write.str("блядь");
        }
        public void read(Reads read, byte revision){
            super.read(read);
            if(read.str() != "блять"){
                Log.info("сука");
            }
        }
    }
}
