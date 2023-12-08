package persea.content;

import arc.graphics.Color;
import mindustry.content.Planets;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.type.Planet;
import persea.graphics.PerseaPal;
import persea.maps.generators.PerseaPlanetGenerator;

import static mindustry.content.Blocks.*;

public class PerseaPlanets {
    public static Planet persea;
    public static void load(){
        persea = new Planet("persea", Planets.sun, 1, 3){{
            generator = new PerseaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 0.15f, 0.13f, 5, new Color().set(PerseaPal.clouds).mul(0.9f).a(0.75f), 2, 0.45f, 0.9f, 0.38f),
                    new HexSkyMesh(this, 1, 0.6f, 0.16f, 5, Color.valueOf("0080ff").cpy().lerp(PerseaPal.clouds, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.41f)
            );
            ruleSetter = r34 -> {
                r34.bannedBlocks.addAll(thoriumWall, thoriumWallLarge, surgeWall, surgeWallLarge);
                r34.hideBannedBlocks = true;
            };
            iconColor = Color.valueOf("3298fc");
            atmosphereColor = Color.valueOf("014180");
            alwaysUnlocked = true;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            itemWhitelist.addAll(PerseaItems.perseaItems);
        }};
    }
}