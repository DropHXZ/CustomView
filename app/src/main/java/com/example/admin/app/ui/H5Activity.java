package com.example.admin.app.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.admin.app.R;

public class H5Activity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5);
        mWebView = (WebView) findViewById(R.id.my_webview);
        initWebView();
    }

    private void initWebView() {
        mWebView.getSettings().setJavaScriptEnabled(true);// 设置使用够执行JS脚本
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setAllowFileAccess(true); // 允许访问文件
        mWebView.getSettings().setBlockNetworkImage(false);//
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        // 支持自动加载图片
        mWebView.getSettings().setLoadsImagesAutomatically(true);
        // 支持内容重新布局
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        if (AndroidUtil.isNetworkAvailable(this)) {
//            mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//        } else {
//            mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        }
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                try {
                    if (url.startsWith("weixin://") || url.startsWith("alipays://") ||
                            url.startsWith("mailto://") || url.startsWith("tel://")
                        //其他自定义的scheme
                            ) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                    return false;
                }
                Log.e("tag", "webview 加载URL：" + url);

                view.loadUrl(url);   //在当前的webview中进行url跳转
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl("https://static.ncmimg.com/app_static/pd_explain_v1_6.html");
    }
}
