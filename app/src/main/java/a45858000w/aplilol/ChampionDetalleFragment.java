package a45858000w.aplilol;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChampionDetalleFragment extends Fragment {

    public ChampionDetalleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_champion_detalle, container, false);
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
    }
}
