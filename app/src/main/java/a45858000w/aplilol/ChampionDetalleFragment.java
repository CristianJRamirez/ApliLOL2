package a45858000w.aplilol;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChampionDetalleFragment extends Fragment {


    private View view;
    private ImageView ImageChampion;
    private TextView NombreChampion;
    private TextView idChampion;
    private TextView titleChampion;
    private TextView descripcionChamp;


    public ChampionDetalleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_champion_detalle, container, false);
        Intent i = getActivity().getIntent();
        if (i != null) {
            Champion champion = (Champion) i.getSerializableExtra("champion");

            if (champion != null) {
                updateUi(champion);
            }
        }

        return view;
    }

    private void updateUi(Champion champion)
    {
        Log.d("CHAMPION", champion.toString());

        ImageChampion = (ImageView) view.findViewById(R.id.ImageChamp);
        NombreChampion = (TextView) view.findViewById(R.id.NombreChampion);
        idChampion = (TextView) view.findViewById(R.id.idChampion);
        titleChampion = (TextView) view.findViewById(R.id.titleChampion);
        descripcionChamp = (TextView) view.findViewById(R.id.descripcionChamp);


        NombreChampion.setText(champion.getName() );
        idChampion.setText(
                       Html.fromHtml("<b>Critics Score:</b> " + champion.getId() + "%"));
        titleChampion.setText(Html.fromHtml("<b>Synopsis:</b> " + champion.getTitle()));
        Glide.with(getContext()).load(champion.getImageSprite()).into(ImageChampion);
    }
}
