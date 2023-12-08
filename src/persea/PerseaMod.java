package persea;

import arc.util.*;
import persea.content.*;
import mindustry.mod.*;
/**
 * The main class of the Persea mod.
 * <p>
 * This mod brings new content to the game, including custom statuses,
 * elements, liquids, types of projectiles, units, blocks, launch combinations,
 * planets, settlement points and technology tree.
 * <p>
 * The {@code loadContent} method is called when the mod is initialized to load
 * all content.
 * <p>
 * The class also has a {@code init} method that is used to execute code,
 * which should not be executed in the {@code loadContent} method.
 *
 * @author K4ok52
 * @version 1.0
 * @since 1.0
 */
public class PerseaMod extends Mod{
    public PerseaMod(){
        /*
          Constructor of the Persea mod, which displays information messages in the log.
         */
        Log.info("Call loadContent in F-MOD loader.");
        Log.info("I LOVE AVOCADO");
    }
    /**
     * Initializes the mod. Called after {@code loadContent}.
     * Can be used to execute initialization code that
     * not suitable for downloading content.
     */
    @Override
    public void init() {
        super.init();
        // Additional initialization code can be executed here if required.
        // sometime i use it
    }
    /**
     * Loads mod content. This method is called when the mod is initialized.
     * Loads all statuses, objects, liquids, shells, units, blocks
     * and other components necessary for the mod to work.
     */
    @Override
    public void loadContent(){
        PerseaStatuses.load();
        PerseaItems.load();
        PerseaLiquids.load();
        PerseaBullets.load();
        PerseaUnits.load();
        PerseaBlocks.load();
        PerseaLoadouts.load();
        PerseaPlanets.load();
        PerseaSectorPreset.load();
        PerseaTechTree.load();
    }
}