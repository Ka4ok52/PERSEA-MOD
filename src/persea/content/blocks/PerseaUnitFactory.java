package persea.content.blocks;

import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.units.UnitFactory;
import persea.content.PerseaItems;
import persea.content.PerseaUnits;

import static mindustry.type.ItemStack.with;

public class PerseaUnitFactory {
    public static Block advancedAirBellowsFactory;//advancedHeavyEquipmentFactory,
    public static void load() {
        advancedAirBellowsFactory = new UnitFactory("advanced-air-bellows-factory"){{
            size = 3;
            plans = Seq.with(
                    new UnitPlan(PerseaUnits.gecko, 60f * 15, with(Items.silicon, 30, Items.lead, 15, Items.titanium, 10, PerseaItems.avocado, 1)),
                    new UnitPlan(PerseaUnits.philetaeus, 60f * 15, with(Items.silicon, 30, Items.lead, 20))
            );
            consumePower(1.6f);
            requirements(Category.units, with( Items.lead, 80, Items.titanium, 40, Items.silicon, 30));
        }};
    }
}