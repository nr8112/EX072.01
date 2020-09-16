package com.example.ex072;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class hishov extends AppCompatActivity {
    Float a;
    Float b;
    Float c;
    Double ans1;
    Double ans2;
    Float dis;
    String aaa, bbb, ccc, url;
    WebView ww;
    TextView t1, t2;
    Intent mi = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hishov);
        ww = findViewById(R.id.ww);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView4);
        ww.getSettings().setJavaScriptEnabled(true);
        ww.setWebViewClient(new MyWebViewClient());

        intentpe();
        hoshovy();
    }
    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView ww, String url) {
            ww.loadUrl(url);
            return true;
        }
    }
    private void hoshovy() {
        dis = (b * b) - 4 * a * c; //Abbreviation - Discriminant
        ans1 = (-b - (Math.sqrt(dis))) / 2 * a;
        ans2 = (-b - (Math.sqrt(dis))) / 2 * a;
        if ((dis) < 0) {
            t1.setText("no answer");
            t2.setText("no answer");
        } else {
            t1.setText("x1=" + ans1);
            t2.setText("x2=" + ans2);
        }


    }


    public void intentpe() {

        a = Float.valueOf(mi.getStringExtra("aa"));
        b = Float.valueOf(mi.getStringExtra("bb"));
        c = Float.valueOf(mi.getStringExtra("cc"));

        aaa = a.toString();
        bbb = b.toString();
        ccc = c.toString();
        if (bbb.isEmpty() && ccc.isEmpty()) {
            url = "https://www.google.com/search?q=" + aaa + "x%5E2";
        } else if (bbb.isEmpty()) {
            url = "https://www.google.com/search?q=" + aaa + "x%5E2%2B" + ccc;
        } else if (ccc.isEmpty()) {
            url = "https://www.google.com/search?q=" + aaa + "x%5E2%2B" + bbb + "x";
        }
        ww.loadUrl(url);
    }






    public void fin(View view) {
        mi.putExtra("anas1",ans1);
        mi.putExtra("anas2",ans2);
        setResult(RESULT_OK,mi);
        finish();

    }
}
