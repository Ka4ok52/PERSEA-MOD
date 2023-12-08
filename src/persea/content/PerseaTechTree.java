package persea.content;

import arc.struct.Seq;
import mindustry.game.Objectives;

import static mindustry.content.Items.*;
import static mindustry.content.Liquids.oil;
import static mindustry.content.Liquids.water;
import static mindustry.content.TechTree.*;
import static persea.content.PerseaItems.*;
import static persea.content.PerseaLiquids.*;
import static persea.content.PerseaSectorPreset.ruins;
import static persea.content.PerseaUnits.gecko;
import static persea.content.blocks.PerseaCoreAndStorage.coreHope;
import static persea.content.blocks.PerseaDistribution.*;
import static persea.content.blocks.PerseaDrill.*;
import static persea.content.blocks.PerseaLiquidBlocks.*;
import static persea.content.blocks.PerseaPower.dieselGenerator;
import static persea.content.blocks.PerseaTurrets.squall;
import static persea.content.blocks.PerseaUnitFactory.advancedAirBellowsFactory;
import static persea.content.blocks.PerseaWalls.aluminumWall;

public class PerseaTechTree {
    public static void load() {
        PerseaPlanets.persea.techTree = nodeRoot("Persea", coreHope, () -> {
            //region blocks
            //region distribution
            node(reinforcedConveyor, () -> {
                node(reinforcedRouter, () -> {
                    node(reinforcedSorter, () -> {
                    });
                    node(reinforcedJunction, () -> {
                    });
                });
                node(reinforcedBridge, () -> {
                });
            });
            //endregion distribution
            //region crafting
            node(basicDrill, () -> {
                node(mountMiner, () -> {
                });
                node(hammerDrill, () -> {

                });
            });
            //endregion crafting
            //region liquid
            node(liquidPipe, () -> {
                node(pneumaticPump, () -> {

                });
                node(liquidPipeJunction, () -> {
                    node(liquidPipeRouter, () -> {

                    });
                });
                node(pipeBridgeConduit, () -> {

                });
            });
            //endregion liquid

            //region power
            node(dieselGenerator, () -> {
            });
            //endregion power

            //region defense
            node(squall, () -> {

            });
            node(aluminumWall, () -> {

            });
            //endregion defense
            //endregion blocks


            //region units
            node(advancedAirBellowsFactory, () -> {
                node(gecko);
            });
            //endregion units
            //region items and liquids
            nodeProduce(aluminum, () -> {
                nodeProduce(water, () -> {
                });
                nodeProduce(cobalt, () -> {
                    nodeProduce(cobaltglass,() -> {
                    });
                    nodeProduce(tantalum, () -> {
                    });
                });
                nodeProduce(sand, () -> {
                    nodeProduce(coal, () -> {
                        nodeProduce(oil, () -> {
                            nodeProduce(associatedPetroleumGas, () -> {
                            });
                            nodeProduce(masut, () -> {
                                nodeProduce(oilWaste,() -> {
                                    nodeProduce(carbon,() -> {
                                        nodeProduce(carbonFiber, () -> {
                                        });
                                    });
                                });
                            });
                        });
                        nodeProduce(graphite, Seq.with(new Objectives.Research(mountMiner)), () -> {
                            nodeProduce(silicon, () -> {
                            });
                        });
                    });
                });
            });
            //endregion items and liquids

            //region sectors
            node(ruins, () -> {

            });
            //endregion sectors
        });
    }
}