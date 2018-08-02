package martingonzalez.com.unityplayeractivityextension;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.unity3d.player.UnityPlayerActivity;

import java.util.List;

public class UnityPlayerActivityExtension extends UnityPlayerActivity {

    public static final String UNITY_TAG = "Unity";
    private UnityActivityListenersNotifier notifier;

    @Override
    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);

        logOverrideMethod("onCreate");
        UnityActivityListenersLoader listenersLoader = new UnityActivityListenersLoader();
        List<UnityActivityListener> listeners = listenersLoader.getActivityListenersFrom(this);
        notifier = new UnityActivityListenersNotifier(listeners);
        notifier.onCreate(bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logOverrideMethod("onStart");
        notifier.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logOverrideMethod("onResume");
        notifier.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        logOverrideMethod("onPause");
        notifier.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logOverrideMethod("onDestroy");
        notifier.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        logOverrideMethod("onNewIntent");
        notifier.onNewIntent(intent);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        logOverrideMethod("onLowMemory");
        notifier.onLowMemory();
    }

    @Override
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        logOverrideMethod("onTrimMemory");
        notifier.onTrimMemory(i);
    }

    @Override
    public void onWindowFocusChanged(boolean b) {
        super.onWindowFocusChanged(b);
        logOverrideMethod("onWindowFocusChanged");
        notifier.onWindowFocusChanged(b);
    }

    @Override
    protected void onStop() {
        super.onStop();
        logOverrideMethod("onStop");
        notifier.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logOverrideMethod("onRestart");
        notifier.onRestart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logOverrideMethod("onBackPressed");
        notifier.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        logOverrideMethod("onConfigurationChanged");
        notifier.onConfigurationChanged(configuration);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logOverrideMethod("onSaveInstanceState");
        notifier.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logOverrideMethod("onRestoreInstanceState");
        notifier.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        notifier.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        notifier.onActivityResult(requestCode, resultCode, data);
    }

    private void logOverrideMethod(String methodName) {
        Log.d(UNITY_TAG, "#### " + methodName + " from UnityPlayerActivityExtension");
    }
}
