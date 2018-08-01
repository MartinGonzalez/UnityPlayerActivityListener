package martingonzalez.com.unityplayeractivityextension;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.pm.ApplicationInfo.FLAG_UPDATED_SYSTEM_APP;

class UnityActivityListenersLoader {

    public static final String ACTIVITY_LISTENER_PREFIX = "com.unity.activity.listener";

    public List<UnityActivityListener> getActivityListenersFrom(Context context) {
        logDebug("\n#### Creating Activity Listeners");
        List<UnityActivityListener> activityListeners = new ArrayList<>();
        try {
            @SuppressLint("WrongConstant") ApplicationInfo applicationInfo = context
                    .getPackageManager()
                    .getApplicationInfo(context.getPackageName(), FLAG_UPDATED_SYSTEM_APP);
            Bundle bundle = applicationInfo.metaData;
            List<String> activityListenerClassesNames = getActivityListenersClassName(bundle);
            activityListeners = getListenerClassesFrom(activityListenerClassesNames);
        } catch (PackageManager.NameNotFoundException e) {
            logError(e.getMessage());
        }
        return activityListeners;
    }

    private List<String> getActivityListenersClassName(Bundle bundle) {
        List<String> classesNames = new ArrayList<>();
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if (isString(value) && isKeyAnActivityListener(key)) {
                classesNames.add((String) value);
            }
        }
        return classesNames;
    }

    private boolean isString(Object value) {
        return value instanceof String;
    }

    private boolean isKeyAnActivityListener(String key) {
        return key.startsWith(ACTIVITY_LISTENER_PREFIX);
    }

    private List<UnityActivityListener> getListenerClassesFrom(List<String> listenerClassesName) {
        List<UnityActivityListener> listenersClasses = new ArrayList<>();
        logDebug("\n#### Activity Listener Found: ");
        logDebug("\n####                          ");
        for (String className : listenerClassesName) {
            try {
                Class listenerClass = Class.forName(className);
                if (isAnActivityListenerClass(listenerClass)) {
                    logDebug("\n#### |_: " + listenerClass.getName());
                    listenersClasses.add((UnityActivityListener) listenerClass.newInstance());
                }
            } catch (ClassNotFoundException e) {
                logError(className + " was not found.");
            } catch (IllegalAccessException e) {
                logError(e.getMessage());
            } catch (InstantiationException e) {
                logError(e.getMessage());
            }
        }
        logDebug("\n##############################");
        return listenersClasses;
    }

    private void logDebug(String message) {
        Log.d(UnityPlayerActivityExtension.UNITY_TAG, message);
    }

    private void logError(String message) {
        Log.e(UnityPlayerActivityExtension.UNITY_TAG, message);
    }

    private boolean isAnActivityListenerClass(Class listenerClass) {
        return UnityActivityListener.class.isAssignableFrom(listenerClass);
    }
}
