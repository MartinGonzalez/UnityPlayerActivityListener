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

    public List<AbstractUnityActivityListener> getActivityListenersFrom(Context context) {
        Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n#### Creating Activity Listeners");
        List<AbstractUnityActivityListener> activityListeners = new ArrayList<>();
        try {
            @SuppressLint("WrongConstant") ApplicationInfo applicationInfo = context
                    .getPackageManager()
                    .getApplicationInfo(context.getPackageName(), FLAG_UPDATED_SYSTEM_APP);
            Bundle bundle = applicationInfo.metaData;
            List<String> activityListenerClassesNames = getActivityListenersClassName(bundle);
            activityListeners = getListenerClassesFrom(activityListenerClassesNames);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
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

    private boolean isString(Object value){
        return value instanceof String;
    }

    private boolean isKeyAnActivityListener(String key) {
        return key.startsWith(ACTIVITY_LISTENER_PREFIX);
    }

    private List<AbstractUnityActivityListener> getListenerClassesFrom(List<String> listenerClassesName) {
        List<AbstractUnityActivityListener> listenersClasses = new ArrayList<>();
        Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n#### Activity Listener Found: ");
        Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n####                          ");
        for (String className : listenerClassesName) {
            try {
                Class listenerClass = Class.forName(className);
                if (isAnActivityListenerClass(listenerClass)) {
                    Log.d(UnityPlayerActivityExtension.UNITY_TAG, "\n#### |_: " + listenerClass.getName());
                    listenersClasses.add((AbstractUnityActivityListener) listenerClass.newInstance());
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
        return listenersClasses;
    }

    private boolean isAnActivityListenerClass(Class listenerClass) {
        return AbstractUnityActivityListener.class.isAssignableFrom(listenerClass);
    }
}
