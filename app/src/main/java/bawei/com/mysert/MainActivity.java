package bawei.com.mysert;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.tab_layout)
    private TabLayout tabLayout;
    private String[] name = {"月光茶人","优惠","购物车","我的"};
    private List<String> list = new ArrayList<>();
    private MyFragment[] fragment;
    @ViewInject(R.id.view_pager)
    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.Ext.init(getApplication());
        x.view().inject(this);
        tabView();
    }

    private void tabView() {
        for (String bean:name) {
            list.add(bean);
        }

        for (int i = 0; i < name.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(list.get(i)));
        }



        fragment = new MyFragment[list.size()];
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return list.size();
            }
            @Override
            public Fragment getItem(int position) {
                if (fragment[position] == null) {
                    MyFragment my = MyFragment.getInstance(list.get(position).charAt(0));

                    fragment[position] = my;
                }
                return fragment[position];
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        tabLayout.setupWithViewPager(vp);
        tabLayout.getTabAt(0).setText(list.get(0)).setIcon(R.drawable.yue);
        tabLayout.getTabAt(1).setText(list.get(1)).setIcon(R.drawable.you);
        tabLayout.getTabAt(2).setText(list.get(2)).setIcon(R.drawable.gou);
        tabLayout.getTabAt(3).setText(list.get(3)).setIcon(R.drawable.me);

    }
}
