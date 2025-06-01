package com.kovalev.mireaproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// Создаем WebViewFragment.java
public class WebViewFragment extends Fragment {
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_view, container, false);
        webView = view.findViewById(R.id.webView);
        setupWebView();
        loadDefaultPage();
        return view;
    }

    private void setupWebView() {
        // Конфигурация WebView
        webView.getSettings().setJavaScriptEnabled(true); // Включаем JavaScript
        webView.setWebViewClient(new WebViewClient());
    }

    private void loadDefaultPage() {
        String defaultUrl = "https://www.example.com";
        webView.loadUrl(defaultUrl);
    }
}