package a45858000w.aplilol;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import a45858000w.aplilol.databinding.ChampionLayoutBinding;

/**
 * Created by 45858000w on 09/12/16.
 */

public class ChampionAdapter extends ArrayAdapter<Champion> {

    public ChampionAdapter(Context context, int resource, List<Champion> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtenim l'objecte en la possició corresponent
        Champion c  = getItem(position);
        Log.w("XXXX", c.toString());

        ChampionLayoutBinding binding = null;

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            //convertView = inflater.inflate(R.layout.champion_layout, parent, false);
            binding = DataBindingUtil.inflate(inflater, R.layout.champion_layout, parent, false);
                }
        else {
                    binding = DataBindingUtil.getBinding(convertView);
        }





        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        binding.txtChampion.setText(c.getName());
        binding.titulo.setText(c.getTitle());
        Glide.with(getContext()).load(c.getImageSquareFull()).into(binding.ImageChamp);


        // Retornem la View replena per a mostrarla
        return binding.getRoot();
    }
}