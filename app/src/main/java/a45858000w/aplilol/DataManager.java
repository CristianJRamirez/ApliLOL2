package a45858000w.aplilol;

/**
 * Created by 45858000w on 09/01/17.
 */

import android.content.Context;
import android.support.v4.content.CursorLoader;
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
        cupboard().withContext(context).delete(CHAMPION_URI, "_id > ?", "0");
    }

    static CursorLoader getCursorLoader(Context context) {
        return new CursorLoader(context, CHAMPION_URI, null, null, null, null);
    }//TODO: buscar los datos que van en estos nulos, que ahi van los select y los where de la bbdd y desde ahi podemos recoger los datos

}