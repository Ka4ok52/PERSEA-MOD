package persea.content;

import persea.content.blocks.*;

public class PerseaBlocks {
    public static void load() {
        PerseaEnvironment.load();
        PerseaCoreAndStorage.load();
        PerseaOre.load();
        PerseaDistribution.load();
        PerseaLiquidBlocks.load();
        PerseaDrill.load();
        PerseaPower.load();
        PerseaProduction.load();
        PerseaTurrets.load();
        PerseaUnitFactory.load();
        PerseaWalls.load();
    }
}