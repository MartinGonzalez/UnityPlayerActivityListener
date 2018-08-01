package com.unity.myhelloworldplugin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import martingonzalez.com.unityplayeractivityextension.UnityActivityListener;

public class MyHelloWorldActivityListener extends UnityActivityListener {
    private static final String MY_PLUGIN_TAG = "MyPluginTag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(MY_PLUGIN_TAG, "Hello World from onCreate Method!");
    }

    @Override
    public void onNewIntent(Intent intent) {
        Log.d(MY_PLUGIN_TAG, "Hello World from onNewIntent Method! Yes im listening this too! Awesome!");
    }

    @Override
    public void onStop() {
        Log.d(MY_PLUGIN_TAG, "Ow! The app was stopped so Bye World!");
    }

    @Override
    public void onResume() {
        Log.d(MY_PLUGIN_TAG, "OHH! We are back! HELLO AGAIN!");
    }
}
