package fmod.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import fmod.graphics.FPal;
import mindustry.entities.*;
import mindustry.graphics.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
public class FFx {
    public static final Effect
            corrosion = new Effect(50f, e -> {
                Draw.color(FPal.toxicGreen);
                alpha(Mathf.clamp(e.fin() * 2f));
                Fill.circle(e.x, e.y, e.fout());
            }),
            toxicShoot = new Effect(8f, e -> {
                color(FPal.toxicGreen);
                float w = 1f + 5 * e.fout();
                Drawf.tri(e.x, e.y, w, 17f * e.fout(), e.rotation);
                Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
            }),
            toxicSplash = new Effect(8, e -> {
                color(Color.white, FPal.toxicGreen, e.fin());
                stroke(0.5f + e.fout());
                Lines.circle(e.x, e.y, e.fin() * 5f);

                Drawf.light(e.x, e.y, 23f, FPal.toxicGreen, e.fout() * 0.7f);
            });
}
