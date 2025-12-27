package persea.world.draw;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import mindustry.gen.Building;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;

public class DrawFrame extends DrawBlock {
    public int frames = 3;
    public float interval = 5f;
    public boolean sine = true;
    public TextureRegion[] regions;
    @Override
    public void draw(Building build){
        Draw.rect(
                sine ?
                        regions[(int)Mathf.absin(build.totalProgress(), interval, frames - 0.001f)] :
                        regions[(int)((build.totalProgress() / interval) % frames)],
                build.x, build.y);
    }
    @Override
    public TextureRegion[] icons(Block block){
        return new TextureRegion[]{regions[0]};
    }
    @Override
    public void load(Block block){
        regions = new TextureRegion[frames];
        for(int i = 0; i < frames; i++){
            regions[i] = Core.atlas.find(block.name + "-frame" + i);
        }
    }
}