package a45858000w.aplilol;

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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A placeholder fragment containing a simple view.
 */


public class MainActivityFragment extends Fragment {

    //region VARIABLES
    private ArrayList<String> champions;
    private ArrayAdapter<String> adapter;
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

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.champion_layout,
                R.id.txtChampion,
                champions
        );
        listaChampions.setAdapter(adapter);

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
        @Override
        protected void onPostExecute(ArrayList<Champion> champions) {
            super.onPostExecute(champions);
            adapter.clear();
            for (Champion c : champions) {
                    adapter.add(c.getName());
                }
        }
    }
    //endregion

}