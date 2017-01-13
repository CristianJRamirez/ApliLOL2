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
import android.widget.TextView;

import com.alexvasilkov.events.Events;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import a45858000w.aplilol.databinding.FragmentActivityInfoChampionBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class ActivityInfoChampionFragment extends Fragment {

    private Champion champion;
    private FragmentActivityInfoChampionBinding binding;
    private View view;

    public ActivityInfoChampionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_activity_info_champion, container, false);

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

    @Events.Subscribe("campeon")
    private void onCampeonDetalles(Champion champion) {

        updateUi(champion);
    }


    private void updateUi(Champion champion) {
        Log.d("CAMPEON", champion.toString());
        this.champion=champion;


        binding.CampeonNombre.setText(Html.fromHtml("<b>Nombre : </b> " +champion.getName()));
        binding.tViewTipoCampeon.setText(this.champion.getTipoChamp());

        binding.tvAtaque.setText(String.valueOf(this.champion.getAttack()));
        binding.tvDefensa.setText(String.valueOf(this.champion.getDefense()));
        binding.tvAbilidad.setText(String.valueOf(this.champion.getMagic()));
        binding.tvDificultat.setText(String.valueOf(this.champion.getDifficulty()));

        binding.pbAttack.setProgress(this.champion.getAttack()*10);
        binding.pbDefense.setProgress(this.champion.getDefense()*10);
        binding.pbAbility.setProgress(this.champion.getMagic()*10);
        binding.pbDifficulty.setProgress(this.champion.getDifficulty()*10);

        binding.lblPassive.setText("<b>Nombre de la Pasiva : </b> "+this.champion.getNamePassive());
        binding.txtPassive.setText(this.champion.getDescriptionPassive());

        binding.txtAllytips.setText(this.champion.getAllytipsFuncionalidad());
        binding.txtEnemytips.setText(this.champion.getEnemytipsAnulacion());
    }
}
