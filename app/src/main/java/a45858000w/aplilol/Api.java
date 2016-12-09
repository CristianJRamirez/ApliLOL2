package a45858000w.aplilol;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by 45858000w on 02/12/16.
 */

public class Api {
    private String InfoApi="https://developer.riotgames.com/api/methods#!/1206/4678";
    private String InfoData="https://developer.riotgames.com/docs/static-data";

    private String Api_KEY="RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3";
    private String AllChampion="https://euw.api.pvp.net/api/lol/euw/v1.2/champion?api_key="+Api_KEY;

    private int IdChampion;

    private String ChampionID ="https://euw.api.pvp.net/api/lol/euw/v1.2/champion/"+IdChampion+"?api_key="+Api_KEY;


    private String ChampionLista="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?api_key="+Api_KEY;//con nombres, ID, titulo,key
    private String ChampionListaImagenes="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?champData=image&api_key="+Api_KEY;//con nombres, ID, titulo,key
    private  String ChampionIDDetalle="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+IdChampion+"?api_key="+Api_KEY;//detelles del champion
    private  String ChampionIDDetalleImagen="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+IdChampion+"?champData=image&api_key="+Api_KEY;//detelles del champion




    //https://api.magicthegathering.io/v1/cards
    //  String getCartas(String pais) { //para utilizar el parametro
   public String getChampions(){
        Uri builtUri = Uri.parse(ChampionListaImagenes)
                .buildUpon()
                //.appendPath("box_office.json")
                // .appendQueryParameter("country", pais)//para buscar dentro de la api con algun paramentro en concreto
                .build();
        String url = builtUri.toString();

        try {
            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Champion> getAllChampions(){
        Uri builtUri = Uri.parse("https://euw.api.pvp.net/api/lol/euw/v1.2/champion?api_key=RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3")
                .buildUpon()
                //.appendPath("box_office.json")
                // .appendQueryParameter("country", pais)//para buscar dentro de la api con algun paramentro en concreto
                .build();
        String url = builtUri.toString();
        //Log.d("URL", url);

        try {
            String JsonResponse = HttpUtils.get(url);

            ArrayList<Champion> cartas =new ArrayList<>();


           // Log.d("URLS",ChampionLista);//https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?api_key=RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3
           // Log.d("URLS",ChampionListaImagenes);//https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?champData=image&api_key=RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3
           // Log.d("URLS",ChampionIDDetalle);//https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/0?api_key=RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3
           // Log.d("URLS",ChampionIDDetalleImagen);//https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/0?champData=image&api_key=RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3

            JSONObject data= new JSONObject(JsonResponse);
            JSONArray jsonChamps = data.getJSONArray("champions");
            for (int i = 0; i<jsonChamps.length() ; i++) {
                Champion c= new Champion();
                JSONObject object = jsonChamps.getJSONObject(i);

                if (object.has("id")) {
                    c=getDetallesId(object.getString("id"));
               }
                cartas.add(c);
            }


            return cartas;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Champion getDetallesId(String id) {
        Uri builtUri = Uri.parse("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+id+"?champData=image&api_key=RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3")
                .buildUpon()
                .build();
        String url = builtUri.toString();

        try {
            //consigo los detalles de los campeones
            String JsonResponse = HttpUtils.get(url);
            Gson gson = new Gson();
            Champion champ= gson.fromJson(JsonResponse,
                    Champion.class);

            //para conseguir la informacion de las imagenes del campeon
            String[] list = JsonResponse.split("\"image\":");
            JsonResponse=list[1].substring(0,list[1].length()-2);
            ImageChamp imagC= gson.fromJson(JsonResponse,
                    ImageChamp.class);

            //seteo el valor de la imagen en el campeon
            champ.setImageSprite(imagC.getSprite());
            champ.setImageSquareFull(imagC.getFull());



            return champ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;

    }
}