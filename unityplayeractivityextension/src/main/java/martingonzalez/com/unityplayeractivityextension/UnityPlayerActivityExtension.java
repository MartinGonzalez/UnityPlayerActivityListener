package martingonzalez.com.unityplayeractivityextension;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.unity3d.player.UnityPlayerActivity;

public class UnityPlayerActivityExtension extends UnityPlayerActivity  {

    public static final String UNITY_TAG = "Unity";
    private UnityActivityListenerHelper _unityActivityListenerHelper;

    @Override
    protected void onCreate(Bundle bundle) {

        super.onCreate(bundle);

        LogOverrideMethod("onCreate");
        _unityActivityListenerHelper = new UnityActivityListenerHelper(this);
        _unityActivityListenerHelper.onCreate(bundle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogOverrideMethod("onStart");
        _unityActivityListenerHelper.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogOverrideMethod("onResume");
        _unityActivityListenerHelper.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogOverrideMethod("onPause");
        _unityActivityListenerHelper.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogOverrideMethod("onDestroy");
        _unityActivityListenerHelper.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogOverrideMethod("onNewIntent");
        _unityActivityListenerHelper.onNewIntent(intent);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogOverrideMethod("onLowMemory");
        _unityActivityListenerHelper.onLowMemory();
    }

    @Override
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        LogOverrideMethod("onTrimMemory");
        _unityActivityListenerHelper.onTrimMemory(i);
    }

    @Override
    public void onWindowFocusChanged(boolean b) {
        super.onWindowFocusChanged(b);
        LogOverrideMethod("onWindowFocusChanged");
        _unityActivityListenerHelper.onWindowFocusChanged(b);
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogOverrideMethod("onStop");
        _unityActivityListenerHelper.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogOverrideMethod("onRestart");
        _unityActivityListenerHelper.onRestart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogOverrideMethod("onBackPressed");
        _unityActivityListenerHelper.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LogOverrideMethod("onConfigurationChanged");
        _unityActivityListenerHelper.onConfigurationChanged(configuration);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogOverrideMethod("onSaveInstanceState");
        _unityActivityListenerHelper.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogOverrideMethod("onRestoreInstanceState");
        _unityActivityListenerHelper.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        _unityActivityListenerHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        _unityActivityListenerHelper.onActivityResult(requestCode, resultCode, data);
    }

    private void LogOverrideMethod(String methodName){
        Log.d(UNITY_TAG, "#### " + methodName + " from UnityPlayerActivityExtension");
    }
}
