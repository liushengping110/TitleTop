package wizrole.titletop.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import wizrole.titletop.R;


/**
 * Created by liushengping on 2018/3/1.
 * 何人执笔？
 */

public class NomalActionBar extends Toolbar {

    public NomalActionBar(Context context) {
        super(context);
    }

    public NomalActionBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NomalActionBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.nomal_actionbar, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER;
        addView(view, layoutParams);


//        View view_after = LayoutInflater.from(getContext()).inflate(R.layout.action_bar_nomal_after, null);
//        layoutParams.gravity = Gravity.CENTER;
//        addView(view_after, layoutParams);
    }

}
