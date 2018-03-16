package wizrole.titletop.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Field;


/**
 * Created by liushengping on 2016/11/27.
 * 何人执笔？
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Intent intent;
    private Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Steep();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(getLayout());
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        initData();
        setListener();
    }

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void setListener();

    protected void Skip(Class cla) {
        intent = new Intent(this, cla);
        startActivity(intent);
    }

    protected void Skip(Class cla, String key, String value) {
        intent = new Intent(this, cla);
        intent.putExtra(key, value);
        startActivity(intent);
    }

    protected void SkipForResult(Class cla, String key, String value, int requestcode) {
        intent = new Intent(this, cla);
        intent.putExtra(key, value);
        startActivityForResult(intent, requestcode);
    }


    protected String getData(Context context,String key) {
        return getIntent().getStringExtra(key);
    }


    protected void ToastShow(String result) {
        if (toast == null) {
            toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT);
        } else {
            toast.setText(result);
        }
        toast.show();
    }
    private void Steep() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 获取状态栏高度
     */
    public int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void initStatusBar(LinearLayout bar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int statusbarheight = getStatusBarHeight();
            bar.setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bar.getLayoutParams();
            layoutParams.height = statusbarheight;
            bar.setLayoutParams(layoutParams);
        }
    }

    public void initStatusBar(LinearLayout bar, int h) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            bar.setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bar.getLayoutParams();
            layoutParams.height = h;
            bar.setLayoutParams(layoutParams);
        }
    }
}
