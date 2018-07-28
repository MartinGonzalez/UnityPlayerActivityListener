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
    private UnityActivityMessageSender _unityActivityMessageSender;

    @Override
    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);

        logOverrideMethod("onCreate");
        UnityActivityListenersLoader listenersLoader = new UnityActivityListenersLoader();
        List<AbstractUnityActivityListener> activityListeners = listenersLoader.getActivityListenersFrom(this);
        _unityActivityMessageSender = new UnityActivityMessageSender(activityListeners);
        _unityActivityMessageSender.onCreate(bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logOverrideMethod("onStart");
        _unityActivityMessageSender.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logOverrideMethod("onResume");
        _unityActivityMessageSender.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        logOverrideMethod("onPause");
        _unityActivityMessageSender.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logOverrideMethod("onDestroy");
        _unityActivityMessageSender.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        logOverrideMethod("onNewIntent");
        _unityActivityMessageSender.onNewIntent(intent);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        logOverrideMethod("onLowMemory");
        _unityActivityMessageSender.onLowMemory();
    }

    @Override
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        logOverrideMethod("onTrimMemory");
        _unityActivityMessageSender.onTrimMemory(i);
    }

    @Override
    public void onWindowFocusChanged(boolean b) {
        super.onWindowFocusChanged(b);
        logOverrideMethod("onWindowFocusChanged");
        _unityActivityMessageSender.onWindowFocusChanged(b);
    }

    @Override
    protected void onStop() {
        super.onStop();
        logOverrideMethod("onStop");
        _unityActivityMessageSender.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logOverrideMethod("onRestart");
        _unityActivityMessageSender.onRestart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logOverrideMethod("onBackPressed");
        _unityActivityMessageSender.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        logOverrideMethod("onConfigurationChanged");
        _unityActivityMessageSender.onConfigurationChanged(configuration);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logOverrideMethod("onSaveInstanceState");
        _unityActivityMessageSender.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logOverrideMethod("onRestoreInstanceState");
        _unityActivityMessageSender.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        _unityActivityMessageSender.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        _unityActivityMessageSender.onActivityResult(requestCode, resultCode, data);
    }

    private void logOverrideMethod(String methodName) {
        Log.d(UNITY_TAG, "#### " + methodName + " from UnityPlayerActivityExtension");
    }
}
