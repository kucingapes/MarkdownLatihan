package com.utsman.kucingapes.markdownlatihan;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vitorlaerte.bypassglideimagegetter.BypassGlideImageGetter;

import javax.security.auth.callback.Callback;

import in.uncod.android.bypass.Bypass;
import ru.noties.markwon.Markwon;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.UrlProcessor;
import ru.noties.markwon.UrlProcessorRelativeToAbsolute;
import ru.noties.markwon.renderer.html.SpannableHtmlParser;
import ru.noties.markwon.spans.AsyncDrawable;


public class MainActivity extends AppCompatActivity {

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text_md);

        id = "![logo](https://raw.githubusercontent.com/noties/Markwon/master/art/markwon_logo.png)\n" +
                "\n" +
                "# Markwon\n" +
                "\n" +
                "[![markwon](https://img.shields.io/maven-central/v/ru.noties/markwon.svg?label=markwon)](http://search.maven.org/#search|ga|1|g%3A%22ru.noties%22%20AND%20a%3A%22markwon%22)\n" +
                "[![markwon-image-loader](https://img.shields.io/maven-central/v/ru.noties/markwon-image-loader.svg?label=markwon-image-loader)](http://search.maven.org/#search|ga|1|g%3A%22ru.noties%22%20AND%20a%3A%22markwon-image-loader%22)\n" +
                "[![markwon-view](https://img.shields.io/maven-central/v/ru.noties/markwon-view.svg?label=markwon-view)](http://search.maven.org/#search|ga|1|g%3A%22ru.noties%22%20AND%20a%3A%22markwon-view%22)\n" +
                "\n" +
                "**Markwon** is a library for Android that renders markdown as system-native Spannables. It gives ability to display markdown in all TextView widgets (**TextView**, **Button**, **Switch**, **CheckBox**, etc), **Notifications**, **Toasts**, etc. <u>**No WebView is required**</u>. Library provides reasonable defaults for display style of markdown but also gives all the means to tweak the appearance if desired. All markdown features are supported (including limited support for inlined HTML code, markdown tables and images).\n" +
                "\n" +
                "<sup>*</sup>*This file is displayed by default in the [sample-apk] application. Which is a generic markdown viewer with support to display markdown via `http`, `https` & `file` schemes and 2 themes included: Light & Dark*\n" +
                "\n" +
                "## Installation\n" +
                "```groovy\n" +
                "compile 'ru.noties:markwon:1.0.4'\n" +
                "compile 'ru.noties:markwon-image-loader:1.0.4' // optional\n" +
                "compile 'ru.noties:markwon-view:1.0.4' // optional\n" +
                "```";

        Bypass bypass = new Bypass(this);

        textView.setText(bypass.markdownToSpannable(id,
                new BypassGlideImageGetter(textView, Glide.with(MainActivity.this))));
        /*final UrlProcessor urlProcessor;
        final AsyncDrawable.Loader loader;
        loader = new AsyncDrawable.Loader() {
            @Override
            public void load(@NonNull String destination, @NonNull AsyncDrawable drawable) {

            }

            @Override
            public void cancel(@NonNull String destination) {

            }
        };*/
        //urlProcessor = new UrlProcessorRelativeToAbsolute(uri.toString());


        /*final SpannableConfiguration configuration = SpannableConfiguration.builder(this)
                .asyncDrawableLoader(loader)
                .build();

        textView.setText(id);

        //Markwon.setMarkdown(textView, id);
        Markwon.setText(textView, (CharSequence) configuration);

       // AsyncDrawable.createFromPath(id);*/

    }
}
