package a45858000w.aplilol;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import a45858000w.aplilol.DatosSecundarios.Habilidades;
import a45858000w.aplilol.DatosSecundarios.ImageChamp;
import a45858000w.aplilol.DatosSecundarios.InfoEstadisticas;
import a45858000w.aplilol.DatosSecundarios.InfoPassive;

/**
 * Created by 45858000w on 02/12/16.
 */

public class Api {
    private static String InfoApi="https://developer.riotgames.com/api/methods#!/1206/4678";
    private static String InfoData="https://developer.riotgames.com/docs/static-data";

    private static String Api_KEY="RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3";
    private static String AllChampion="https://euw.api.pvp.net/api/lol/euw/v1.2/champion?api_key="+Api_KEY;

    private static String IdChampion;

    private static String ChampionID ="https://euw.api.pvp.net/api/lol/euw/v1.2/champion/"+IdChampion+"?api_key="+Api_KEY;


    private static String ChampionLista="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?api_key="+Api_KEY;//con nombres, ID, titulo,key
    private static String ChampionListaImagenes="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion?champData=image&api_key="+Api_KEY;//con nombres, ID, titulo,key
    private static String ChampionIDDetalle="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+IdChampion+"?api_key="+Api_KEY;//detelles del champion
    private static String ChampionIDDetalleImagen="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+IdChampion+"?champData=image&api_key="+Api_KEY;//detelles del champion
    //private String ChampionAllDetail ="https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+IdChampion+"?champData=all&api_key="+Api_KEY;



    //https://api.magicthegathering.io/v1/cards
    //  String getCartas(String pais) { //para utilizar el parametro
   public static String getChampions(){
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

    public static ArrayList<Champion> getAllChampions(){
        Uri builtUri = Uri.parse("https://euw.api.pvp.net/api/lol/euw/v1.2/champion?api_key=RGAPI-f53a2e9d-2955-4e4e-9582-6725ed511ba3")
                .buildUpon()
                //.appendPath("box_office.json")
                // .appendQueryParameter("country", pais)//para buscar dentro de la api con algun paramentro en concreto
                .build();
        String url = builtUri.toString();
        //Log.d("URL", url);

        try {
            String JsonResponse = HttpUtils.get(url);

            ArrayList<Champion> champs =new ArrayList<>();


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
                champs.add(c);
            }


            return champs;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Champion getDetallesId(String id) throws JSONException {
        //https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+id+"?locale=es_ES&champData=all&api_key="+Api_KEY
        //https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+id+"?champData=all&api_key="+Api_KEY
        Uri builtUri = Uri.parse("https://global.api.pvp.net/api/lol/static-data/euw/v1.2/champion/"+id+"?locale=es_ES&champData=all&api_key="+Api_KEY)
                .buildUpon()
                .build();
        String url =builtUri.toString();

        try {
            //consigo los detalles de los campeones
            String JsonResponse = HttpUtils.get(url);
            Gson gson = new Gson();
            Champion champ= gson.fromJson(JsonResponse,
                    Champion.class);

            //para conseguir la informacion de las imagenes del campeon
            JSONObject data= new JSONObject(JsonResponse);
            String jsonChamps = data.getJSONObject("image").toString();
            ImageChamp imagC= gson.fromJson(jsonChamps,
                    ImageChamp.class);

            //seteo el valor de la imagen en el campeon
            String img[]=imagC.getFull().split("\\.");
            champ.setImageSprite(img[0]+"_0.jpg");//ACABAR
            champ.setImageSquareFull(imagC.getFull());
            //Log.d("IMGCHMP",champ.getImageSquareFull() +"///"+champ.getImageSprite());

            //Log.d("CHAMP ---->",champ.toString());


            //tags -> para tipo de campeon : mago, adc, tanque..
            JSONObject dataTag= new JSONObject(JsonResponse);
            String jsonChampsTag = dataTag.getJSONArray("tags").toString();
            champ.setTipoChamp(jsonChampsTag);



            //info -> para el ataque, defensa, magic, dificultat
            //para conseguir la informacion de estadisticas del campeon
            JSONObject dataInfo= new JSONObject(JsonResponse);
            String jsonChampsInfo = dataInfo.getJSONObject("info").toString();
            InfoEstadisticas infoE= gson.fromJson(jsonChampsInfo,
                    InfoEstadisticas.class);

            champ.setAttack(infoE.getAttack());
            champ.setDefense(infoE.getDefense());
            champ.setMagic(infoE.getMagic());
            champ.setDifficulty(infoE.getDifficulty());


            //añadir datos de la passiva
            JSONObject dataPassive= new JSONObject(JsonResponse);
            String jsonChampsPassive = dataPassive.getJSONObject("passive").toString();
            InfoPassive infoP= gson.fromJson(jsonChampsPassive,
                    InfoPassive.class);

            champ.setNamePassive(infoP.getName());
            champ.setDescriptionPassive(infoP.getDescription());


            //allytips -> breve descripcion de su funcionalidad
            JSONObject dataAllytips= new JSONObject(JsonResponse);
            String jsonChampsAllytips = dataAllytips.getJSONArray("allytips").toString();
            champ.setAllytipsFuncionalidad(jsonChampsAllytips);

            //enemytips -> breve descripcion de como para al campeon
            JSONObject dataEnemytips= new JSONObject(JsonResponse);
            String jsonChampsEnemytips = dataEnemytips.getJSONArray("enemytips").toString();
            champ.setEnemytipsAnulacion(jsonChampsEnemytips);



            //spells -> para las Habilidades
          //  JSONObject dataHabilidad= new JSONObject(JsonResponse);
          //  String jsonChampsHabilidad = dataHabilidad.getJSONObject("spells").toString();
      /*      List<Habilidades> hab= new List<Habilidades>(gson.fromJson(jsonChampsInfo,
                    Habilidades.class));*/
//JSONArray
          //  Log.d("HABILIDADES",jsonChampsHabilidad);


            return champ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;

    }

    public static ArrayList<Champion> getAllChampions(String nombre) {
        ArrayList<Champion> champsFiltro =new ArrayList<>();
        ArrayList<Champion> champs =getAllChampions();
        if (champs!=null) {
            for (Champion c : champs) {
                if ((c.getName().equalsIgnoreCase(nombre)) || (c.getName().contains(nombre))) {
                    champsFiltro.add(c);
                    Log.d("CH", c.toString());

                }
            }
        }
        return champsFiltro;
    }
}