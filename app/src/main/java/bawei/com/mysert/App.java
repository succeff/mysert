package bawei.com.mysert;

import android.app.Application;

import org.xutils.x;

/**
 * 类的描述：
 * 时间：  2017/8/2.20:11
 * 姓名：chenlong
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
}
