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
    private UnityActivityListenersNotifier _unityActivityListenersNotifier;

    @Override
    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);

        logOverrideMethod("onCreate");
        UnityActivityListenersLoader listenersLoader = new UnityActivityListenersLoader();
        List<AbstractUnityActivityListener> activityListeners
                = listenersLoader.getActivityListenersFrom(this);
        _unityActivityListenersNotifier = new UnityActivityListenersNotifier(activityListeners);
        _unityActivityListenersNotifier.onCreate(bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logOverrideMethod("onStart");
        _unityActivityListenersNotifier.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logOverrideMethod("onResume");
        _unityActivityListenersNotifier.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        logOverrideMethod("onPause");
        _unityActivityListenersNotifier.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logOverrideMethod("onDestroy");
        _unityActivityListenersNotifier.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        logOverrideMethod("onNewIntent");
        _unityActivityListenersNotifier.onNewIntent(intent);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        logOverrideMethod("onLowMemory");
        _unityActivityListenersNotifier.onLowMemory();
    }

    @Override
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        logOverrideMethod("onTrimMemory");
        _unityActivityListenersNotifier.onTrimMemory(i);
    }

    @Override
    public void onWindowFocusChanged(boolean b) {
        super.onWindowFocusChanged(b);
        logOverrideMethod("onWindowFocusChanged");
        _unityActivityListenersNotifier.onWindowFocusChanged(b);
    }

    @Override
    protected void onStop() {
        super.onStop();
        logOverrideMethod("onStop");
        _unityActivityListenersNotifier.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logOverrideMethod("onRestart");
        _unityActivityListenersNotifier.onRestart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logOverrideMethod("onBackPressed");
        _unityActivityListenersNotifier.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        logOverrideMethod("onConfigurationChanged");
        _unityActivityListenersNotifier.onConfigurationChanged(configuration);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logOverrideMethod("onSaveInstanceState");
        _unityActivityListenersNotifier.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logOverrideMethod("onRestoreInstanceState");
        _unityActivityListenersNotifier.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        _unityActivityListenersNotifier.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        _unityActivityListenersNotifier.onActivityResult(requestCode, resultCode, data);
    }

    private void logOverrideMethod(String methodName) {
        Log.d(UNITY_TAG, "#### " + methodName + " from UnityPlayerActivityExtension");
    }
}
