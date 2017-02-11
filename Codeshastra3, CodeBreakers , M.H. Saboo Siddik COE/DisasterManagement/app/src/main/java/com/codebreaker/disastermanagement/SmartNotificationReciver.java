package com.codebreaker.disastermanagement;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by bilal on 29-01-2017.
 */

public class SmartNotificationReciver extends Service {




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}




