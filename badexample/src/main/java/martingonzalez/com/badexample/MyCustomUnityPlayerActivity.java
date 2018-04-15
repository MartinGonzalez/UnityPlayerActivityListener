package martingonzalez.com.badexample;

import android.os.Bundle;
import android.util.Log;

import com.unity3d.player.UnityPlayerActivity;

public class MyCustomUnityPlayerActivity extends UnityPlayerActivity {
    private static final String MY_BAD_TAG = "BadTag";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        Log.d(MY_BAD_TAG, "I've override onCreate! Nice!");
    }
}
