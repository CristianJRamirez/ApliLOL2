package a45858000w.aplilol;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

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
        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.champion_layout, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView Champion = (TextView) convertView.findViewById(R.id.txtChampion);
        TextView title = (TextView) convertView.findViewById(R.id.titulo);
        ImageView Image = (ImageView) convertView.findViewById(R.id.ImageChamp);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        Champion.setText(c.getName());
        title.setText(c.getTitle());
        Glide.with(getContext()).load(c.getImageSquareFull()).into(Image);


        // Retornem la View replena per a mostrarla
        return convertView;
    }
}