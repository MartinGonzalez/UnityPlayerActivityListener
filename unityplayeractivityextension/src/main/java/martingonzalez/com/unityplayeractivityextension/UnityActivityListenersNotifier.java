package martingonzalez.com.unityplayeractivityextension;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.List;

class UnityActivityListenersNotifier {
    private List<UnityActivityListener> activityListeners;

    public UnityActivityListenersNotifier(List<UnityActivityListener> activityListeners) {
        this.activityListeners = activityListeners;
    }

    public void onCreate(Bundle bundle) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onCreate(bundle);
        }
    }

    public void onStart() {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onStart();
        }
    }

    public void onResume() {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onResume();
        }
    }

    public void onNewIntent(Intent intent) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onNewIntent(intent);
        }
    }

    public void onPause() {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onPause();
        }
    }

    public void onDestroy() {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onDestroy();
        }
    }

    public void onLowMemory() {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onLowMemory();
        }
    }

    public void onTrimMemory(int i) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onTrimMemory(i);
        }
    }

    public void onWindowFocusChanged(boolean b) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onWindowFocusChanged(b);
        }
    }

    public void onStop() {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onStop();
        }
    }

    public void onRestart() {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onRestart();
        }
    }

    public void onBackPressed() {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onConfigurationChanged(configuration);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onSaveInstanceState(outState);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onRestoreInstanceState(savedInstanceState);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (UnityActivityListener listenerClass : activityListeners) {
            listenerClass.onActivityResult(requestCode, resultCode, data);
        }
    }
}

