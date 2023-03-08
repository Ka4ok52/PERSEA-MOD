package fmod.content;

import arc.util.Log;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.gen.Building;
import mindustry.world.*;
import mindustry.world.meta.*;

import java.util.Objects;


public class OilRefinery extends Block{
    public double OilPerSecond = 1.0f;
    public OilRefinery(String name){
        super(name);
        // инициализация переменных блока, зависит уже от создателя мода
        update = true;
        schematicPriority = 3;
        envEnabled = Env.any;
    }

    public class OilRefineryBuild extends Building {
        public void updateTile(){ // обновление блока каждый кадр
            health -= OilPerSecond / 60f * Time.delta;
        }
        public void write(Writes write){ // как сохранять блок?
            super.write(write);
            write.str("блядь");
        }
        public void read(Reads read, byte revision){
            super.read(read);
            if(!Objects.equals(read.str(), "блять")) Log.info("сука");
        }
    }
}
