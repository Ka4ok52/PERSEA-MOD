package fmod.type.statuses;

import arc.math.*;
import fmod.content.*;
import mindustry.type.*;

import static fmod.content.FStatuses.*;
import static mindustry.content.StatusEffects.*;

public class CorrosionEffect extends StatusEffect {
    public CorrosionEffect(String name) {
        super(name);
        damage = 0.4f;
        effect = FFx.corrosion;
        speedMultiplier = 0.8f;
        healthMultiplier = 0.8f;
        effectChance = 0.3f;
        transitionDamage = 12f;

        init(() -> {
            opposite(wet, burning, melting);
            affinity(sapped, (unit, result, time) -> {
                unit.damagePierce(transitionDamage);
                FFx.corrosion.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                result.set(corrosion, Math.min(time + result.time, 300f));
            });
        });
    }
}
