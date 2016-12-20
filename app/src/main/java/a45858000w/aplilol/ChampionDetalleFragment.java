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

import com.alexvasilkov.events.Events;
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
    private Champion champion;



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
            champion = (Champion) i.getSerializableExtra("champion");

            if (champion != null) {
                updateUi(champion);
            }
        }

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Events.register(this);
    }

    @Events.Subscribe("click-boton")
    private void onClickButton() {
        Events.create("campeon").param(champion).post();

        Intent intent = new Intent(getContext(), ActivityInfoChampion.class);
        intent.putExtra("champion", champion);
        startActivity(intent);
    }


    private void updateUi(Champion champion)
    {
        Log.d("CHAMPION", champion.toString());




        binding.NombreChampion.setText(Html.fromHtml("<b>Nombre : </b> " +champion.getName()));
        //binding.idChampion.setText(Html.fromHtml("<b>ID : </b> " + champion.getId()));
        binding.titleChampion.setText(Html.fromHtml("<b>Titulo : </b> " + champion.getTitle()));
        binding.txtlore.setText(Html.fromHtml("<b>Lore : </b> " + champion.getLore()));
        binding.descripcionChamp.setText(Html.fromHtml("<b>Descripcion : </b> " + champion.getBlurb()));
        Glide.with(getContext()).load(champion.getImageSprite()).into(binding.ImageChampion);
    }
}
