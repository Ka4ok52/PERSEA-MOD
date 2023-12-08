package persea.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import persea.graphics.PerseaPal;

import static arc.graphics.g2d.Draw.alpha;
import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Mathf.rand;

public class PerseaFx {
    public static final Vec2 v = new Vec2();
    public static final Effect
            corrosion = new Effect(50f, e -> {
                Draw.color(PerseaPal.toxicGreen);
                alpha(Mathf.clamp(e.fin() * 2f));
                Fill.circle(e.x, e.y, e.fout());
            }),
            toxicShoot = new Effect(8f, e -> {
                color(PerseaPal.toxicGreen);
                float w = 1f + 5 * e.fout();
                Drawf.tri(e.x, e.y, w, 17f * e.fout(), e.rotation);
                Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
            }),
            toxicSplash = new Effect(8, e -> {
                color(Color.white, PerseaPal.toxicGreen, e.fin());
                stroke(0.5f + e.fout());
                Lines.circle(e.x, e.y, e.fin() * 5f);
                Drawf.light(e.x, e.y, 23f, PerseaPal.toxicGreen, e.fout() * 0.7f);
            }),
            radioImpulse = new Effect(120, e -> {
                float radius = 4f + e.fin() * 12f;
                color(PerseaPal.flash);
                stroke(2f - e.fin() * 2f);
                Lines.circle(e.x, e.y, radius);
            }),
            forming = new Effect(60, e -> {
                float radius = 4f + e.fin() * 6f;
                color(PerseaPal.making);
                stroke(2f - e.fin() * 2f);
                Lines.circle(e.x, e.y, radius);
            }),
            turbineGenerate = new Effect(100, e -> {
                color(PerseaPal.smoke);
                alpha(e.fslope() * 0.8f);

                rand.setSeed(e.id);
                for(int i = 0; i < 3; i++){
                    v.trns(rand.random(360f), rand.random(e.finpow() * 14f)).add(e.x, e.y);
                    Fill.circle(v.x, v.y, rand.random(1.4f, 3.4f));
                }
            }).layer(Layer.bullet - 1f);
}
