package martingonzalez.com.unityplayeractivityextension;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.pm.ApplicationInfo.FLAG_UPDATED_SYSTEM_APP;

class UnityActivityListenerHelper {
    public static final String ACTIVITY_LISTENER_PREFIX = "com.unity.activity.listener";
    private Context _context;
    private List<AbstractUnityActivityListener> _listeners;

    public UnityActivityListenerHelper(Context runningActivity) {
        Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n#### Creating Activity Listeners");
        _context = runningActivity;
        _listeners = getActivityListenersFrom(runningActivity);
    }

    public void onCreate(Bundle bundle) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onCreate(bundle);
        }
    }

    public void onStart() {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onStart();
        }
    }

    public void onResume() {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onResume();
        }
    }

    public void onNewIntent(Intent intent) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onNewIntent(intent);
        }
    }


    public void onPause() {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onPause();
        }
    }

    public void onDestroy() {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onDestroy();
        }
    }

    public void onLowMemory() {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onLowMemory();
        }
    }

    public void onTrimMemory(int i) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onTrimMemory(i);
        }
    }

    public void onWindowFocusChanged(boolean b) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onWindowFocusChanged(b);
        }
    }

    public void onStop() {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onStop();
        }
    }

    public void onRestart() {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onRestart();
        }
    }

    public void onBackPressed() {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onConfigurationChanged(configuration);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onSaveInstanceState(outState);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onRestoreInstanceState(savedInstanceState);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (AbstractUnityActivityListener listenerClass : _listeners) {
            listenerClass.onActivityResult(requestCode,resultCode, data);
        }
    }


    private List<AbstractUnityActivityListener> getActivityListenersFrom(Context context) {
        List<AbstractUnityActivityListener> temp = new ArrayList<>();
        try {
            @SuppressLint("WrongConstant") ApplicationInfo applicationInfo = context
                    .getPackageManager()
                    .getApplicationInfo(context.getPackageName(), FLAG_UPDATED_SYSTEM_APP);
            Bundle bundle = applicationInfo.metaData;
            List<String> activityListenerClassesName = getActivityListenersClassName(bundle);
            temp = getListenerClassesFrom(activityListenerClassesName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }

    private List<String> getActivityListenersClassName(Bundle bundle) {
        List<String> temp = new ArrayList<>();
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (isString(value) && isKeyAnActivityListener(key)) {
                temp.add((String) value);
            }
        }
        return temp;
    }

    private List<AbstractUnityActivityListener> getListenerClassesFrom(List<String> listenerClassesName) {
        List<AbstractUnityActivityListener> temp = new ArrayList<>();
        Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n#### Activity Listener Found: ");
        Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n####                          ");
        for (String className : listenerClassesName) {
            try {
                Class listenerClass = Class.forName(className);
                if (isAnActivityListenerClass(listenerClass)) {
                    Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n#### |_: " + listenerClass.getName());
                    temp.add((AbstractUnityActivityListener) listenerClass.newInstance());
                }
            } catch (ClassNotFoundException e) {
                Log.e(UnityPlayerActivityExtension.UNITY_TAG, className + " was not found.");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n##############################");
        return temp;
    }

    private boolean isAnActivityListenerClass(Class listenerClass) {
        return AbstractUnityActivityListener.class.isAssignableFrom(listenerClass);
    }

    private boolean isString(Object object) {
        return object instanceof String;
    }

    private boolean isKeyAnActivityListener(String key) {
        return key.startsWith(ACTIVITY_LISTENER_PREFIX);
    }


}
