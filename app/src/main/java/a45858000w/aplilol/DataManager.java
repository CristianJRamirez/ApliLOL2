package a45858000w.aplilol;

/**
 * Created by 45858000w on 09/01/17.
 */

import android.content.Context;
import android.net.Uri;

import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by carlesgm on 22/8/16.
 */

public class DataManager {

    private static UriHelper URI_HELPER = UriHelper.with(ChampionContentProvider.AUTHORITY);
    private static Uri CHAMPION_URI = URI_HELPER.getUri(Champion.class);

    static void saveChampions(ArrayList<Champion> champions, Context context) {
        cupboard().withContext(context).put(CHAMPION_URI, Champion.class, champions);
    }

    static void deleteChampions(Context context) {
        cupboard().withContext(context).delete(CHAMPION_URI, "_id > ?", "1");
    }

}