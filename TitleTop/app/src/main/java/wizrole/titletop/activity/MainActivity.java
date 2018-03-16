package wizrole.titletop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import wizrole.titletop.R;
import wizrole.titletop.activity.ordinary.OrdinaryActivity;
import wizrole.titletop.activity.tablayout.TabLayoutActivity;

/**
 * Created by liushengping on 2018/3/15.
 * 何人执笔？
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ScrollView
        findViewById(R.id.scrollView_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ScrollViewTopActivity.class);
                startActivity(intent);
            }
        });
        //tabLayout
        findViewById(R.id.tablayout_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TabLayoutActivity.class);
                startActivity(intent);
            }
        });
        //普通
        findViewById(R.id.ordinary_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OrdinaryActivity.class);
                startActivity(intent);
            }
        });
    }
}
