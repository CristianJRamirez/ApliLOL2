package a45858000w.aplilol;

import android.content.Intent;
import android.databinding.DataBindingUtil;
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

import a45858000w.aplilol.databinding.FragmentChampionDetalleBinding;

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
    private FragmentChampionDetalleBinding binding;



    public ChampionDetalleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                 inflater, R.layout.fragment_champion_detalle, container, false);

        view = binding.getRoot();


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




        binding.NombreChampion.setText(Html.fromHtml("<b>Nombre : </b> " +champion.getName()));
        binding.idChampion.setText(Html.fromHtml("<b>ID : </b> " + champion.getId()));
        binding.titleChampion.setText(Html.fromHtml("<b>Titulo : </b> " + champion.getTitle()));
        Glide.with(getContext()).load(champion.getImageSprite()).into(binding.ImageChampion);
    }
}
