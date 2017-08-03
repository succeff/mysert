package bawei.com.mysert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的描述：
 * 时间：  2017/8/2.20:05
 * 姓名：chenlong
 */
@ContentView(R.layout.fragmentes)
public class GameFragment extends Fragment{
    @ViewInject(R.id.listview)
    private ListView lv;
    private MyAdapter adapter;
    private List<Data.DataBean.ProductsBean> list = new ArrayList<>();
    private RequestParams params;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = x.view().inject(this, inflater, container);
        loadView();
        adapter = new MyAdapter(getContext(),list);
        lv.setAdapter(adapter);
        return view;

    }

    private void loadView() {
        params = new RequestParams("http://api.eleteam.com/v1/product/list-featured-topic");
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Data data = new Gson().fromJson(result, Data.class);
                list.addAll(data.getData().getProducts());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
