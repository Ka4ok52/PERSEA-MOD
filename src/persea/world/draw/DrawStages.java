package persea.world.draw;

import arc.Core;
import arc.graphics.g2d.*;
import mindustry.gen.Building;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;

public class DrawStages extends DrawBlock {
    public TextureRegion[] stages = new TextureRegion[3];
    public String suffix;
    public int currentIndex = 0;
    public DrawStages(String suffix){
        this.suffix = suffix;
    }

    @Override
    public void load(Block block){
        stages[0] = Core.atlas.find(block.name + suffix + "1");
        stages[1] = Core.atlas.find(block.name + suffix + "2");
        stages[2] = Core.atlas.find(block.name + suffix + "3");
    }

    @Override
    public void draw(Building build) {
        TextureRegion currentStage = stages[currentIndex % stages.length];
        Draw.rect(currentStage, build.x, build.y);
        currentIndex++;
    }
}