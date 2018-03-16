package wizrole.titletop.adapter;

import android.content.Context;

import java.util.List;

import wizrole.titletop.R;
import wizrole.titletop.adapter.base.ConcreteAdapter;
import wizrole.titletop.adapter.base.ViewHolder;

/**
 * Created by liushengping on 2018/3/15.
 * 何人执笔？
 */

public class ScrollViewAdapter extends ConcreteAdapter<String> {
    public ScrollViewAdapter(Context context, List<String> list, int itemLayout) {
        super(context, list, itemLayout);
    }

    @Override
    protected void convert(ViewHolder viewHolder, String item, int position) {
        viewHolder.setText(item, R.id.item_name);
    }
}
