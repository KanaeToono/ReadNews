package com.example.conga.finaltest.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.conga.finaltest.models.Task;
import com.example.conga.finaltest.services.ReminderService;
import com.example.conga.finaltest.services.WakeReminderIntentService;

/**
 * Created by ConGa on 9/04/2016.
 */
public class OnAlarmReceiver extends BroadcastReceiver {
    private static String TAG = OnAlarmReceiver.class.getSimpleName();
    //private static final String TAG = ComponentInfo.class.getCanonicalName();


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Received wake up from alarm manager.");

        Task list = (Task) intent.getParcelableExtra("alarm");

        WakeReminderIntentService.acquireStaticLock(context);

        Intent i = new Intent(context, ReminderService.class);
        i.putExtra("id_alarm", list);
        context.startService(i);

    }
}
