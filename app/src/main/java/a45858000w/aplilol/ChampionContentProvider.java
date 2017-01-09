package a45858000w.aplilol;

/**
 * Created by 45858000w on 09/01/17.
 */

import android.graphics.Movie;
import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class ChampionContentProvider extends CupboardContentProvider {


    // The content provider authority is used for building Uri's for the provider
    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

    static {
        cupboard().register(Champion.class);
    }

    public ChampionContentProvider() {
        super(AUTHORITY, 1);
    }
}