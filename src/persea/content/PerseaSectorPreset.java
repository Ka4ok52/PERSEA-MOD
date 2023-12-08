package persea.content;

import mindustry.type.SectorPreset;

public class PerseaSectorPreset {
    public static SectorPreset ruins;
        public static void load(){
            ruins = new SectorPreset("ruins", PerseaPlanets.persea, 10){{
                difficulty = 2;
            }};
        }
}
