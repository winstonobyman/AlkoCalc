package com.example.alkocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

public class WineSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_search);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new CustomWebViewFragment())
                    .commit();
        }
    }

    public static class CustomWebViewFragment extends WebViewFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View result= super.onCreateView(inflater, container, savedInstanceState);
            getWebView().getSettings().setJavaScriptEnabled(true);
            // настройка масштабирования
            getWebView().getSettings().setSupportZoom(true);
            getWebView().getSettings().setBuiltInZoomControls(true);
            getWebView().loadUrl("https://www.vivinod.com/");
            return(result);
        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }
    }
}
