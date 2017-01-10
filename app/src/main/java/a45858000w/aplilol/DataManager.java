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


    static CursorLoader getCursorLoaderPrueba(Context context,String[] projection,String where,String[] whereargs,String order){
        return new CursorLoader(context,CHAMPION_URI,projection,where,whereargs,order);
    }



    /*
    CursorLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
    El significado de los parámetros son los siguientes:
        Context: Contexto del entorno de aplicación.
        Uri: URI con contenido: // patrón que recupera el contenido.
        Projection: Lista de columnas a devolver y si null devolverá todas las columnas.
        Selección: Filtro para devolver filas. Formato es como consulta SQL.
        SortOrder: Tipo de orden como SQL ORDER BY y si nulo, la salida será desordenada.
     */
}