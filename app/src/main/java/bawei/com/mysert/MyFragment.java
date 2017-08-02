package bawei.com.mysert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * 类的描述：
 * 时间：  2017/8/1.19:57
 * 姓名：chenlong
 */
@ContentView(R.layout.fragment)
public class MyFragment extends Fragment{
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
        return view;

    }
}
