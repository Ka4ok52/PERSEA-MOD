package persea.type.draw;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.gen.Building;
import mindustry.graphics.Layer;
import mindustry.world.Block;
import mindustry.world.draw.DrawBlock;

public class DrawRotating extends DrawBlock {
    TextureRegion rotating;
    float angle;

    @Override
    public void load(Block block){rotating = Core.atlas.find(block.name + "-rotating");}

    @Override
    public void draw(Building build) {
        angle += (1f / 60f) * build.efficiency;
        if (angle >= 360f) {
            angle -= 360f;
        }
        Draw.z(Layer.block);
        Draw.rect(rotating, build.x, build.y, rotating.width / 4.3f, rotating.height / 4.3f, angle);
    }
}