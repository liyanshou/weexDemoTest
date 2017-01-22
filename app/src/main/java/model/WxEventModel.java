package model;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXModuleAnno;

/**
 * Created by admin on 2016/12/20.
 */

public class WxEventModel extends WXModule {
    private static final String WEEX_CATEGORY="com.taobao.android.intent.category.WEEX";
    @WXModuleAnno
    public void openURL(String url){
        Log.e("WxEventModel", "mWXSDKInstance=="+mWXSDKInstance);
        Log.e("WxEventModel", "url=="+url);
//        mWXSDKInstance.renderByUrl("股手",url, null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
        String scheme = Uri.parse(url).getScheme();
        StringBuilder builder = new StringBuilder();
        if (TextUtils.equals("http",scheme) || TextUtils.equals("https",scheme) || TextUtils.equals("file",scheme)) {
            builder.append(url);
        } else {
            builder.append("http:");
            builder.append(url);
        }
        Uri uri = Uri.parse(builder.toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addCategory(WEEX_CATEGORY);
        mWXSDKInstance.getContext().startActivity(intent);
    }
    @WXModuleAnno(runOnUIThread = true)
    public void printLog(String msg){
        Toast.makeText(mWXSDKInstance.getContext(), "msg="+msg.toString(), Toast.LENGTH_SHORT).show();
    }
}
