package wizrole.titletop.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import wizrole.titletop.R;
import wizrole.titletop.adapter.ScrollViewAdapter;
import wizrole.titletop.base.BaseActivity;
import wizrole.titletop.view.CustListView;
import wizrole.titletop.view.CustScrollView;

/**
 * Created by liushengping on 2018/3/15.
 * 何人执笔？
 * 在activity的标题置顶
 */

public class ScrollViewTopActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.list_view)CustListView list_view;
    @BindView(R.id.scrollView)CustScrollView scrollView;
    @BindView(R.id.scroll_title_one)LinearLayout scroll_title_one;//未置顶
    @BindView(R.id.scroll_title_two)LinearLayout scroll_title_two;//已置顶
    @BindView(R.id.title_detail)LinearLayout title_detail;//已置顶
    @BindView(R.id.tab1_t)TextView tab1_t;
    @BindView(R.id.tab1_v)TextView tab1_v;
    @BindView(R.id.tab2_t)TextView tab2_t;
    @BindView(R.id.tab2_v)TextView tab2_v;
    @BindView(R.id.tab3_t)TextView tab3_t;
    @BindView(R.id.tab3_v)TextView tab3_v;
    @BindView(R.id.tab3_mian)RelativeLayout tab3_mian;
    @BindView(R.id.tab2_mian)RelativeLayout tab2_mian;
    @BindView(R.id.tab1_mian)RelativeLayout tab1_mian;
    @BindView(R.id.xrefreshview)RefreshLayout xrefreshview;
    private int topHeight;
    private int select = 1;//当前选中的下标
    @Override
    protected int getLayout() {
        return R.layout.activity_scrollviewtop;
    }

    @Override
    protected void initData() {
        ButterKnife.bind(this);
        setView();
        setListView();
    }
    public void setView(){
        xrefreshview.setPrimaryColorsId(R.color.bule);
        scrollView.setOnScrollListener(new CustScrollView.OnScrollListener() {
            @Override
            public void onScroll(int scrollY) {
                if (scrollY >= topHeight) {
                    if (title_detail.getParent() != scroll_title_one) {
                        scroll_title_two.removeView(title_detail);
                        scroll_title_one.addView(title_detail);
                    }
                } else {
                    if (title_detail.getParent() != scroll_title_two) {
                        scroll_title_one.removeView(title_detail);
                        scroll_title_two.addView(title_detail);
                    }
                }
            }
        });
    }
    public List<String> strings=new ArrayList<>();
    public void setListView(){
        for(int i=0;i<30;i++){
            strings.add("我是帅哥"+i);
        }
        ScrollViewAdapter adapter=new ScrollViewAdapter(ScrollViewTopActivity.this,strings,R.layout.list_item);
        list_view.setAdapter(adapter);
        list_view.setFocusable(false);//解决listView上移距离
        scrollView.smoothScrollTo(0,0);
    }

    @Override
    protected void setListener() {
        tab1_mian.setOnClickListener(this);
        tab2_mian.setOnClickListener(this);
        tab3_mian.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tab1_mian:
                select = 1;
                changeview(select);
                break;
            case R.id.tab2_mian:
                select = 2;
                changeview(select);
                break;
            case R.id.tab3_mian:
                select = 3;
                changeview(select);
                break;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        changeview(select);
    }


    private void changeview(int index) {
        tab1_t.setTextColor(Color.parseColor("#333333"));
        tab2_t.setTextColor(Color.parseColor("#333333"));
        tab3_t.setTextColor(Color.parseColor("#333333"));
        tab1_v.setSelected(false);
        tab2_v.setSelected(false);
        tab3_v.setSelected(false);
        if (index == 1) {
            tab1_t.setTextColor(Color.parseColor("#59c2de"));
            tab1_v.setSelected(true);
        } else if (index == 2) {
            tab2_t.setTextColor(Color.parseColor("#59c2de"));
            tab2_v.setSelected(true);
        } else {
            tab3_t.setTextColor(Color.parseColor("#59c2de"));
            tab3_v.setSelected(true);
        }
    }

    /**
     *Activity 中可直接   在此方法中获取布局的实际高度
     *
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            topHeight = scroll_title_two.getBottom() - scroll_title_one.getHeight();
        }
    }

    /**
     * 如果在fragment中实现标题置顶，步骤如下
     * （1）、在fragment宿主activitu中
     public  LinearLayout main_tab2;
     public  LinearLayout main_tab1;
     public int topHeight;
     @Override
     public void onWindowFocusChanged(boolean hasFocus) {
     super.onWindowFocusChanged(hasFocus);
     if (hasFocus) {
     topHeight = main_tab2.getBottom() - main_tab1.getHeight();
     }
     }

     public int getTopHeight() {
     return topHeight;
     }

     @Override
     public void getView(LinearLayout linearLayout_one, LinearLayout linearLayout_two) {
     main_tab1=linearLayout_one;
     main_tab2=linearLayout_two;
     }

     （2）、在fragment中
     public GetView getView;
     public interface GetView {
     void getView(LinearLayout linearLayout_one, LinearLayout linearLayout_two);
     }
     @Override
     public void onAttach(Context context) {
     super.onAttach(context);
     getView=(GetView)context;
     }


     myscroview.setOnScrollListener(new MyScroview.OnScrollListener() {
     @Override
     public void onScroll(int scrollY) {
     if (scrollY >= ((MainActivity)getActivity()).getTopHeight()) {
     if (tab_mian.getParent() != main_tab1) {
     main_tab2.removeView(tab_mian);
     main_tab1.addView(tab_mian);
     //滑动到顶端
     scrollTotop=true;
     }
     } else {
     scrollTotop=false;
     if (tab_mian.getParent() != main_tab2) {
     main_tab1.removeView(tab_mian);
     main_tab2.addView(tab_mian);
     }
     }
     }
     });
     getView.getView(main_tab1,main_tab2);
     }

     即可
     */


}
