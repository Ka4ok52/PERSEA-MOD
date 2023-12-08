package persea.content.blocks;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.power.SolarGenerator;
import mindustry.world.consumers.ConsumeLiquidFlammable;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawRegion;
import persea.content.PerseaFx;
import persea.content.PerseaItems;
import persea.content.PerseaLiquids;
import persea.world.blocks.power.PerseaReactor;

import static mindustry.type.ItemStack.with;

public class PerseaPower {
    public static Block
    //Node
    reinforcedPowerNode,powerSubstation,
    //Battery
    carbonBattery,
    //Power Generator
    dieselGenerator,improvedSolarPanel,steamTurbine,gasTurbine,NuclearReactor;
    public static void load() {
        //Node
        reinforcedPowerNode = new PowerNode("reinforced-power-node"){{
            size = 2;
            maxNodes = 3;
            laserRange = 60;
            requirements(Category.power, with(Items.surgeAlloy, 6, PerseaItems.cobalt, 10, PerseaItems.composite, 10, PerseaItems.energyAlloy, 4));
        }};
        powerSubstation = new PowerNode("power-substation"){{
            size = 3;
            maxNodes = 44;
            laserRange = 18;
            requirements(Category.power, with(Items.titanium, 20, Items.lead, 20, Items.silicon, 10, PerseaItems.composite, 12, PerseaItems.energyAlloy, 4));
        }};
        //Battery
        carbonBattery = new Battery("carbon-battery"){{
            size = 3;
            baseExplosiveness = 3f;
            consumePowerBuffered(70000);
            requirements(Category.power, with(Items.titanium, 40, Items.lead, 40, Items.silicon, 11, PerseaItems.carbonFiber, 11, PerseaItems.composite, 6, PerseaItems.energyAlloy, 11));
        }};
        //Power Generator
        dieselGenerator = new ConsumeGenerator("diesel-generator"){{
            size = 2;
            powerProduction = 8f;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawGlowRegion(){{
                        color = Color.valueOf("cc0605");
                        glowIntensity = 0.3f;
                        glowScale = 6f;
                    }}
            );
            ambientSound = Sounds.smelter;
            generateEffect = Fx.generatespark;

            consumeLiquid(Liquids.oil, 0.1f);
            requirements(Category.power, with(PerseaItems.aluminum, 60, PerseaItems.cobalt, 60));
        }};
        improvedSolarPanel = new SolarGenerator("improved-solar-panel"){{
            size = 4;
            powerProduction = 4f;
            requirements(Category.power, with(Items.lead, 40, Items.titanium, 30, Items.silicon, 80, Items.phaseFabric, 15, PerseaItems.energyAlloy, 15));
        }};
        steamTurbine = new ConsumeGenerator("steam-turbine"){{
            size = 2;
            powerProduction = 10f;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawRegion(){{
                        suffix = "-rotator";
                        rotateSpeed = 4.2f;
                        spinSprite = true;
                    }}
                    //new DrawBlurSpin("-rotator", 0.6f * 7f)
            );
            ambientSound = Sounds.smelter;
            generateEffect = Fx.smoke;
            consumeLiquid(PerseaLiquids.steam, 0.25f);
            requirements(Category.power, with(Items.lead, 80, Items.silicon, 30, Items.titanium, 20, Items.metaglass, 10));
        }};
        gasTurbine = new ConsumeGenerator("gas-turbine"){{
            size = 3;
            powerProduction = 20f;
            drawer = new DrawMulti(
                    new DrawRegion(),
                    new DrawRegion(){{
                        suffix = "-rotator";
                        rotateSpeed = 6f;
                        spinSprite = true;
                    }}
                    //new DrawBlurSpin("-rotator", 0.6f * 10f)
            );
            ambientSound = Sounds.torch;
            generateEffect = PerseaFx.turbineGenerate;

            consume(new ConsumeLiquidFlammable(){
                @Override
                public float efficiencyMultiplier(Building build) {
                    var liquidGas = getConsumed(build);
                    //TODO fix the bug later
                    return liquidGas != null && liquidGas.gas ? liquidGas.flammability : 0f;
                }
            });
            requirements(Category.power, with(Items.lead, 300, Items.titanium, 200, Items.silicon, 100, Items.metaglass, 50, PerseaItems.composite, 50));
        }};
        NuclearReactor = new PerseaReactor("nuclear-reactor"){{
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.24f;
            size = 3;
            health = 800;
            itemDuration = 360f;
            powerProduction = 24f;
            heating = 0.02f;

            consumeItem(PerseaItems.enrichedThorium);
            consumeLiquid(Liquids.cryofluid, heating / coolantPower).update(false);
            requirements(Category.power, with(Items.titanium, 300, Items.silicon, 250, Items.plastanium, 100, Items.metaglass, 50, PerseaItems.carbonFiber, 100, PerseaItems.composite, 50));
        }};
    }
}