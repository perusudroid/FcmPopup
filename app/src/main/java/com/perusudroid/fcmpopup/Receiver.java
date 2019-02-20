package com.perusudroid.fcmpopup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    public static final String ACTION_UPDATE_STATUS = "com.perusudroid.fcmpopup.Receiver";

    public void onReceive(Context context, Intent intent) {
        if (ACTION_UPDATE_STATUS.equals(intent.getAction())) {
            Toast.makeText(context, "received", Toast.LENGTH_SHORT).show();
            if (intent.getExtras() != null && intent.getExtras().getString("txt") != null) {
                Intent i = new Intent(context, MainActivity.class);
                i.putExtra("txt", intent.getExtras().getString("txt"));
                context.startActivity(i);
            }
        } else {
            Log.e("Receiver", "onReceive: action mismatch");
        }
    }
}
