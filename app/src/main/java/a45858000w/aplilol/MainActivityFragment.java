package a45858000w.aplilol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.preference.PreferenceManager;
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

import com.alexvasilkov.events.Events;

import java.util.ArrayList;
import java.util.Arrays;

import a45858000w.aplilol.databinding.FragmentMainBinding;
import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static a45858000w.aplilol.R.id.listaChampions;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;


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
       /* View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listaChampions = (ListView) view.findViewById(R.id.listaChampions);*/

        FragmentMainBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_main, container, false);
        View view = binding.getRoot();


        champions = new ArrayList<>();

        adapter = new ChampionAdapter(
                getContext(),
                R.layout.champion_layout,
                //R.id.txtChampion,
                champions
        );
        binding.listaChampions.setAdapter(adapter);

        binding.listaChampions.setOnItemClickListener(new AdapterView.OnItemClickListener() {@Override
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
        else if (id == R.id.filtro) {
            Intent i = new Intent(getContext(), SettingsActivity.class);
            startActivity(i);
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

    private class RefreshDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            String nombre = preferences.getString("nombre", "todos");

            //Api api = new Api();
            ArrayList<Champion> result = null;// api.getAllChampions();

            if ((nombre.equals("Todos")) || (nombre.equals("todos")) || (nombre.isEmpty())) {
                result = Api.getAllChampions();
            } else {
                result = Api.getAllChampions(nombre);
            }

            Log.d("DEBUG", result.toString());

            DataManager.deleteChampions(getContext());
            DataManager.saveChampions(result, getContext());


            return null;
        }
    }
    //endregion

}