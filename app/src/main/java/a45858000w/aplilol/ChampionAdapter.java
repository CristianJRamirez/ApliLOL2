package a45858000w.aplilol;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by 45858000w on 09/12/16.
 */

public class ChampionAdapter extends ArrayAdapter<Champion> {

    public ChampionAdapter(Context context, int resource, List<Champion> objects) {
        super(context, resource, objects);
    }
}