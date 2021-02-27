package com.unit1.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("E2LWKRfn6xonQ770YZbSXg70CMtx4gvXyzXgQGVY")
                .clientKey("VRp3jreG5GiWWNcxf9ijZTtH0r633LLZcGcfAFiY")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
