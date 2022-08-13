package com.example.everyday.Function.DangKy_DangNhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.everyday.R;

public class MapActivity extends AppCompatActivity {
    private WebView weViewMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        weViewMap = (WebView) findViewById(R.id.weView_Map);
        weViewMap.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        weViewMap.getSettings().setBuiltInZoomControls(true);
        weViewMap.setWebChromeClient(new WebChromeClient());
        weViewMap.setWebViewClient(new MapActivity.Map());
        weViewMap.loadUrl("https://www.google.com/maps");
    }
    public  class Map extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            return true;
        }
    }
}