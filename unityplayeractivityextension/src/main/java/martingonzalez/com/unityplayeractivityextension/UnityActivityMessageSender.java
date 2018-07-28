package martingonzalez.com.unityplayeractivityextension;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.List;

class UnityActivityMessageSender {
    private List<AbstractUnityActivityListener> _activityListeners;

    public UnityActivityMessageSender(List<AbstractUnityActivityListener> activityListeners) {
        _activityListeners = activityListeners;
    }

    public void onCreate(Bundle bundle) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onCreate(bundle);
        }
    }

    public void onStart() {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onStart();
        }
    }

    public void onResume() {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onResume();
        }
    }

    public void onNewIntent(Intent intent) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onNewIntent(intent);
        }
    }

    public void onPause() {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onPause();
        }
    }

    public void onDestroy() {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onDestroy();
        }
    }

    public void onLowMemory() {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onLowMemory();
        }
    }

    public void onTrimMemory(int i) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onTrimMemory(i);
        }
    }

    public void onWindowFocusChanged(boolean b) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onWindowFocusChanged(b);
        }
    }

    public void onStop() {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onStop();
        }
    }

    public void onRestart() {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onRestart();
        }
    }

    public void onBackPressed() {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onConfigurationChanged(configuration);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onSaveInstanceState(outState);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onRestoreInstanceState(savedInstanceState);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (AbstractUnityActivityListener listenerClass : _activityListeners) {
            listenerClass.onActivityResult(requestCode, resultCode, data);
        }
    }
}

