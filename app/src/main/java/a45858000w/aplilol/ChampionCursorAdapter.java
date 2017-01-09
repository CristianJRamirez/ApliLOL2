package a45858000w.aplilol;

/**
 * Created by 45858000w on 09/01/17.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import a45858000w.aplilol.databinding.ChampionLayoutBinding;


public class ChampionCursorAdapter extends CupboardCursorAdapter<Champion> {

    public ChampionCursorAdapter(Context context, Class<Champion> entityClass) {
        super(context, entityClass);
    }

    @Override
    public View newView(Context context, Champion c, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ChampionLayoutBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.champion_layout, parent, false);

        return binding.getRoot();
    }


    @Override
    public void bindView(View view, Context context, Champion c) {
        ChampionLayoutBinding binding = DataBindingUtil.getBinding(view);

        binding.txtChampion.setText(c.getName());
        binding.titulo.setText(c.getTitle());
        Glide.with(context).load(c.getImageSquareFull()).into(binding.ImageChamp);
    }

}