package a45858000w.aplilol;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A placeholder fragment containing a simple view.
 */


public class MainActivityFragment extends Fragment {

    //region VARIABLES
    private ArrayList<Champion> champions;
   // private ArrayAdapter<Champion> adapter;

    private ChampionAdapter adapter;
    //endregion



    public MainActivityFragment() {
    }

    @Override//notificamos al activity quer le añadimos items al menu
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listaChampions = (ListView) view.findViewById(R.id.listaChampions);

        champions = new ArrayList<>();

    /*  String[] Ejemplos = {
            "Maestro Yi",
            "VI",
            "Ashe",
            "Garen",
            "Xerath",
            "Ekko",
            "Jhin"
            };
        champions = new ArrayList<>(Arrays.asList(Ejemplos));*/

        adapter = new ChampionAdapter(
                getContext(),
                R.layout.champion_layout,
                //R.id.txtChampion,
                champions
        );
        listaChampions.setAdapter(adapter);

        listaChampions.setOnItemClickListener(new AdapterView.OnItemClickListener() {@Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Champion champion = (Champion) adapterView.getItemAtPosition(i);

            Intent intent = new Intent(getContext(), ChampionDetalle.class);
            intent.putExtra("champion", champion);
            startActivity(intent);
            }
         });

        return view;
    }

    @Override//añadimos items al menu
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_champions,menu);
    }


    //region Click en el boton Actualizar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.actualizar) {
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
            super.onStart();
            refresh();
        }

    private void refresh() {
       /*Api api = new Api();
       String result = api.getChampions();
       Log.d("DEBUG", result);*/
        RefreshDataTask rdt = new RefreshDataTask();
        rdt.execute();
    }

    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Champion>> {
        @Override
        protected ArrayList<Champion> doInBackground(Void... voids) {
            Api api = new Api();
            ArrayList<Champion> result = api.getAllChampions();

            Log.d("DEBUG", result.toString());

            return result;
        }

        //crear filtros
        //https://github.com/CristianJRamirez/MagicList2/commit/599406c2f125d4d74ea9f34e5c9f649d14aa8845
        //https://github.com/CristianJRamirez/MagicList2/commit/3e485d4447b9917fe2ca74e0d3453a810c381b7b
        //https://github.com/CristianJRamirez/MagicList2/commit/2f4b5ba353c4c3658492a6e2f5ed2ee7624711d9

        @Override
        protected void onPostExecute(ArrayList<Champion> champions) {
            super.onPostExecute(champions);
            adapter.clear();
            for (Champion c : champions) {
                    adapter.add(c);
                }
        }
    }
    //endregion

}