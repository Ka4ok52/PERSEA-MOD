package persea.type.statuses;

import arc.math.*;
import persea.content.*;
import mindustry.type.*;

import static persea.content.PerseaStatuses.*;
import static mindustry.content.StatusEffects.*;

public class CorrosionEffect extends StatusEffect {
    public CorrosionEffect(String name) {
        super(name);
        damage = 0.4f;
        effect = PerseaFx.corrosion;
        speedMultiplier = 0.8f;
        healthMultiplier = 0.8f;
        effectChance = 0.3f;
        transitionDamage = 12f;

        init(() -> {
            opposite(wet, burning, melting);
            affinity(sapped, (unit, result, time) -> {
                unit.damagePierce(transitionDamage);
                PerseaFx.corrosion.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                result.set(corrosion, Math.min(time + result.time, 300f));
            });
        });
    }
}
