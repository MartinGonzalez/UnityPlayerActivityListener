# UnityPlayerActivity Extension

# Support this project for Unity to implement

Vote here: [Unity Feedback Ticket](https://feedback.unity3d.com/suggestions/stop-extending-unityplayeractivity-on-android)

Watch it here: [Unity Community Post](https://forum.unity.com/threads/no-more-extending-unityplayeractivity-feature-request-storytelling.526834/)


# Description

 When we want to create a `Unity android plugin` that will use any method of the `Activity` class we are forced to extend `UnityPlayerActivity` class.

That is not a problem for us, it's possible and simple. Following Unity [documentation](https://docs.unity3d.com/Manual/AndroidUnityPlayerActivity.html) to extend this class and implement it in our project should take us 10-20 minutes to have a simple plugin in our project running.

But what happen when we want to create antoher plugin that also will need to listen `Activity` methods. Well nevermind, we can `merge` two plugins into one right? Messy but works...

But the real problem comes when `3rd party plugins` also extend from `UnityPlayerActivity` and merging our plugins and others it would be unsustainable and a problem for us. Imagine that every time a plugin provider release a new version that changes something of it class extending from UnityPlayerActivity, we will have to:

* Find plugin source code (if it's open source).
* Create our UnityActivityPlayer.
* Merge plugin codes with our UnityPlayerActivity custom class.
* Build our `.aar`
* Modify the AndroidManifest.xml
* Test that all lives in harmony

**Really tedious right?** 

And if you don't know anything about Android or Java or exporting .aar files you will be in a bigger problem.

# What this project do?

This project solves this problem. But to really work it must be a standard, and what better way to be a standard than to implement Unity itself.

To give you a summary of what this project does, it provide the way to listen an Activity lifecycle method `without extending from UnityPlayerActivity`.

## Bad Example

Imagine you want to create your first android plugin for Unity, let's call it MyHelloWorldPlugin. It will be an awesome plugin that will `Log` every Activity method that is executed.

Since we need to know about Activity events, following Unity [documentation](https://docs.unity3d.com/Manual/AndroidUnityPlayerActivity.html) tells us to extend UnityPlayerActivity to have interaction with Android OS and Unity Application


    When developing a Unity Android application, it is possible to extend the standard UnityPlayerActivity class (the primary Java class for the Unity Player on Android, similar to AppController.mm on Unity iOS) by using plug-ins. An application can override any and all of the basic interaction between the Android OS and the Unity Android application.
 
So we extend from UnityPlayerActivity, let's call this class `MyCustomUnityPlayerActivity`, and we log every Activity method with cool mesages.

So when the Activity `onCreate` method is executed we will log

```bash
    onCreate: Wow! I've been created from MyHelloWorldPlugin!
    onStart: Nice! Now we can start doing things!
    .
    .
    .
    onDestroy: Ou! We are been destroyed! Bye World!
```

Cool right?

We build our `.aar` (Android library) file containing our new `MyCustomUnityPlayerActivity`, we place it under `Assets/Plugins/Android` and now we have to tell Android to use our custom Activity instead of Unity Activity. So we create an AndroidManifest.xml `Plugins/Android` folder.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android" package="com.company.product">
  <application android:icon="@drawable/app_icon" android:label="@string/app_name">
  <!-- Here we tell Android to use OUR activity -->
    <activity android:name="com.unity.myhelloworldplugin.MyCustomUnityPlayerActivity" 
             android:label="@string/app_name"
             android:configChanges="fontScale|keyboard|keyboardHidden|locale|mnc|mcc|navigation|orientation|screenLayout|screenSize|smallestScreenSize|uiMode|touchscreen">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
  </application>
</manifest>
```

We build the `.apk` file, watch the logs and everything is working fine. So now we published to the world!

Let's imagine that Ed, a developer who is just starting using Unity, saw your awesome plugin and wants to integrate it. He will have to:

* Import your plugin
* Change his AndroidManifest.xml main Activity to yours.

But imagine Ed already has another plugin that also need to be the main activity. Ed doesn't know how to merge those plugins so he spend weeks learning how to create a Android project, how to extend from UnityPlayerActivity, being in forums asking for help etc.

Time wasted...poor Ed.

## The Happy Path

Imagine Unity provides us this project feature, to listen the Main Activity events. Let's create the same `MyHelloWorldPlugin` but now instead of extending UnityPlayerActivity i will do the following steps:

Create what should be my "CustomUnityPlayerActivity" but instead i will create a "MyHelloWorldActivityListener" and will extend from an abstract class that "Unity provide us" called `AbstractUnityActivityListener` that will facilitate the methods of an activity. Lets see a code example

```java
package com.unity.myhelloworldplugin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import martingonzalez.com.unityplayeractivityextension.AbstractUnityActivityListener;

public class MyHelloWorldActivityListener extends AbstractUnityActivityListener {
    private static final String MY_PLUGIN_TAG = "MyPluginTag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(MY_PLUGIN_TAG, "Hello World from onCreate Method!");
    }

    @Override
    public void onNewIntent(Intent intent) {
        Log.d(MY_PLUGIN_TAG, "Hello World from onNewIntent Method! Yes im listening this too! Awesome!");
    }

    @Override
    public void onStop() {
        Log.d(MY_PLUGIN_TAG, "Ow! The app was stopped so Bye World!");
    }

    @Override
    public void onResume() {
        Log.d(MY_PLUGIN_TAG, "OHH! We are back! HELLO AGAIN!");
    }
}
```

Here we are lying to our plugin, telling him it will be like an activity, but it is not, it is `listening` to the Main Activity.

After doing this i will add something to my plugin `AndroidManifest.xml` so when Unity merges every AndroidManifests of the project, we will be sure that this `meta-data` is on it.

```xml
<manifest 
    xmlns:android="http://schemas.android.com/apk/res/android" package="com.unity.myhelloworldplugin">
    <application>
        <meta-data android:name="com.unity.activity.listener.MyHelloWorld" android:value="com.unity.myhelloworldplugin.MyHelloWorldActivityListener" />
    </application>
</manifest>
```

See how i created a `meta-data` node where it has: 

key: `com.unity.activity.listener.MyHelloWorld`

value: `com.unity.myhelloworldplugin.MyHelloWorldActivityListener`

What "Unity will do" _(remember Unity does not have this project feature)_ in its activity is to find all the keys of its metadata that contain the prefix `com.unity.activity.listener` following by an identifier for your plugin. In this case our plugin id is `.MyHelloWorld` and create an instance of the class that we are setting as a value in the meta-data. In this case Unity will create an instance of our `com.unity.myhelloworldplugin.MyHelloWorldActivityListener` class.

Nice! Now we can create our `.aar` file and import it into Unity under 'Assets/Plugins/Android' without touching the project AndroidManifest.xml and even we are not forcing to set any Main Activity!

Imagine everybody following this rule, there will be no collision between plugins!

## Usage

