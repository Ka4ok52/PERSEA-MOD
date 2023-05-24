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
    public float rotateSpeed;

    public DrawRotating(float rotateSpeed) {this.rotateSpeed = rotateSpeed;}

    @Override
    public void load(Block block){rotating = Core.atlas.find(block.name + "-rotating");}

    @Override
    public void draw(Building build) {
        angle += (1f / 60f) * build.efficiency * rotateSpeed;
        if (angle >= 360f) {
            angle -= 360f;
        }
        Draw.z(Layer.block);
        Draw.rect(rotating, build.x, build.y, rotating.width / 4f, rotating.height / 4f, angle);
    }
}