package app.liys.com.weexdemo;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

import model.WxEventModel;

/**
 * Created by admin on 2016/12/16.
 */

public  class WXApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        InitConfig config=new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build();
        WXSDKEngine.initialize(this,config);
        try {
            WXSDKEngine.registerModule("event", WxEventModel.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }
}