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
    private UnityActivityListenersNotifier unityActivityListenersNotifier;

    @Override
    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);

        logOverrideMethod("onCreate");
        UnityActivityListenersLoader listenersLoader = new UnityActivityListenersLoader();
        List<UnityActivityListener> activityListeners
                = listenersLoader.getActivityListenersFrom(this);
        unityActivityListenersNotifier = new UnityActivityListenersNotifier(activityListeners);
        unityActivityListenersNotifier.onCreate(bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logOverrideMethod("onStart");
        unityActivityListenersNotifier.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logOverrideMethod("onResume");
        unityActivityListenersNotifier.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        logOverrideMethod("onPause");
        unityActivityListenersNotifier.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logOverrideMethod("onDestroy");
        unityActivityListenersNotifier.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        logOverrideMethod("onNewIntent");
        unityActivityListenersNotifier.onNewIntent(intent);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        logOverrideMethod("onLowMemory");
        unityActivityListenersNotifier.onLowMemory();
    }

    @Override
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        logOverrideMethod("onTrimMemory");
        unityActivityListenersNotifier.onTrimMemory(i);
    }

    @Override
    public void onWindowFocusChanged(boolean b) {
        super.onWindowFocusChanged(b);
        logOverrideMethod("onWindowFocusChanged");
        unityActivityListenersNotifier.onWindowFocusChanged(b);
    }

    @Override
    protected void onStop() {
        super.onStop();
        logOverrideMethod("onStop");
        unityActivityListenersNotifier.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logOverrideMethod("onRestart");
        unityActivityListenersNotifier.onRestart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logOverrideMethod("onBackPressed");
        unityActivityListenersNotifier.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        logOverrideMethod("onConfigurationChanged");
        unityActivityListenersNotifier.onConfigurationChanged(configuration);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logOverrideMethod("onSaveInstanceState");
        unityActivityListenersNotifier.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logOverrideMethod("onRestoreInstanceState");
        unityActivityListenersNotifier.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        unityActivityListenersNotifier.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        unityActivityListenersNotifier.onActivityResult(requestCode, resultCode, data);
    }

    private void logOverrideMethod(String methodName) {
        Log.d(UNITY_TAG, "#### " + methodName + " from UnityPlayerActivityExtension");
    }
}
