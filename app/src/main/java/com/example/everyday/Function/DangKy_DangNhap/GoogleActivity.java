package com.example.everyday.Function.DangKy_DangNhap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.everyday.R;

public class GoogleActivity extends AppCompatActivity {
    private WebView weViewGoogle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        weViewGoogle = (WebView) findViewById(R.id.weView_Google);
        weViewGoogle.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        weViewGoogle.getSettings().setBuiltInZoomControls(true);
        weViewGoogle.setWebChromeClient(new WebChromeClient());
        weViewGoogle.setWebViewClient(new Google());
        weViewGoogle.loadUrl("https://accounts.google.com/ServiceLogin/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    }
    public  class Google extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            return true;
        }
    }
}