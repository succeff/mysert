package bawei.com.mysert;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * 类的描述：
 * 时间：  2017/8/2.20:21
 * 姓名：chenlong
 */
public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<Data.DataBean.ProductsBean> list;

    public MyAdapter(Context context, List<Data.DataBean.ProductsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
         public int getCount() {
            return  list.size();
         }

         @Override
         public Object getItem(int position) {
             return list.get(position);
         }

         @Override
         public long getItemId(int position) {
             return position;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             ViewHolder holder=null;
             if(convertView==null){
                 convertView=View.inflate(context,R.layout.item1,null);
                 holder=new ViewHolder();
                 x.view().inject(holder,convertView);

                 convertView.setTag(holder);
             }else{
                 holder=(ViewHolder)convertView.getTag();
             }
             x.image().bind(holder.image,list.get(position).getImage_small());
             holder.tit.setText(list.get(position).getName());
             holder.conts.setText(list.get(position).getShort_description());
             holder.prices.setText(list.get(position).getPrice());

             return convertView;
         }

         class ViewHolder{
             @ViewInject(R.id.image)
             private ImageView image;
             @ViewInject(R.id.title)
             private TextView tit;
             @ViewInject(R.id.cont)
             private TextView conts;
             @ViewInject(R.id.price)
             private TextView prices;
         }
}
