package bawei.com.mysert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * 类的描述：
 * 时间：  2017/8/1.19:57
 * 姓名：chenlong
 */
@ContentView(R.layout.fragment)
public class MyFragment extends Fragment{
    @ViewInject(R.id.tab_layout)
    private TabLayout tabLayout;
    @ViewInject(R.id.viewpage)
    private ViewPager vp;
    private TabAdaper tabAdaper;
    public static MyFragment getInstance(int id){
        MyFragment myFragment=new MyFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("id",id);
        myFragment.setArguments(bundle);
        return myFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = x.view().inject(this, inflater, container);
        tabView();
        return view;


    }

    private void tabView() {

        tabAdaper = new TabAdaper(getFragmentManager());
        // 设置适配器
        vp.setAdapter(tabAdaper);
        // 直接绑定viewpager，消除了以前的需要设置监听器的繁杂工作
        tabLayout.setupWithViewPager(vp);

    }
    // fragment的适配器类
    class TabAdaper extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>();
        // 标题数组
        String[] titles = {"天天优惠","为你精选"};

        public TabAdaper(FragmentManager fm) {
            super(fm);
            fragmentList.add(new MyFragments());
            fragmentList.add(new GameFragment());

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }


}
