package persea.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.*;
import mindustry.type.*;

/*
import static fmod.content.FBlocks.*;
import static fmod.content.FItems.*;
*/

public class PerseaPlanets {
    public static Planet persea;
    public static void load(){
        persea = new Planet("persea", Planets.sun, 1, 3){{
            generator = new SerpuloPlanetGenerator();
            bloom = true;
            visible = true;
            hasAtmosphere = true;
            alwaysUnlocked = true;
            allowWaves = true;
            accessible = false;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            meshLoader = () -> new SunMesh(
                    this, 4,
                    3, 0.7, 1.9, 1.4, 1.6,
                    1.1f,
                    Color.valueOf("a9a39f"),
                    Color.valueOf("b5afaa"),
                    Color.valueOf("b5afaa"),
                    Color.valueOf("c1c7c1"),
                    Color.valueOf("f1f9f1"),
                    Color.valueOf("d7ded7")
            );
        }};
    }
}
