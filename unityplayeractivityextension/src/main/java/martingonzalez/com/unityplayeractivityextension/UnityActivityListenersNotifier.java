package martingonzalez.com.unityplayeractivityextension;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.List;

class UnityActivityListenersNotifier {
    private List<UnityActivityListener> listeners;

    public UnityActivityListenersNotifier(List<UnityActivityListener> listeners) {
        this.listeners = listeners;
    }

    public void onCreate(Bundle bundle) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onCreate(bundle);
        }
    }

    public void onStart() {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onStart();
        }
    }

    public void onResume() {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onResume();
        }
    }

    public void onNewIntent(Intent intent) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onNewIntent(intent);
        }
    }

    public void onPause() {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onPause();
        }
    }

    public void onDestroy() {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onDestroy();
        }
    }

    public void onLowMemory() {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onLowMemory();
        }
    }

    public void onTrimMemory(int i) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onTrimMemory(i);
        }
    }

    public void onWindowFocusChanged(boolean b) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onWindowFocusChanged(b);
        }
    }

    public void onStop() {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onStop();
        }
    }

    public void onRestart() {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onRestart();
        }
    }

    public void onBackPressed() {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onConfigurationChanged(configuration);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onSaveInstanceState(outState);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onRestoreInstanceState(savedInstanceState);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (UnityActivityListener listenerClass : listeners) {
            listenerClass.onActivityResult(requestCode, resultCode, data);
        }
    }
}

