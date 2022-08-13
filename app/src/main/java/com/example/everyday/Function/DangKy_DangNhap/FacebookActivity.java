package com.example.everyday.Function.DangKy_DangNhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.everyday.R;

public class FacebookActivity extends AppCompatActivity {
    private WebView weViewFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        weViewFacebook = (WebView) findViewById(R.id.weView_Facebook);
        weViewFacebook.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        weViewFacebook.getSettings().setBuiltInZoomControls(true);
        weViewFacebook.setWebChromeClient(new WebChromeClient());
        weViewFacebook.setWebViewClient(new Facebook());
        weViewFacebook.loadUrl("https://vi-vn.facebook.com/");
    }
    public  class Facebook extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            return true;
        }
    }
}