package com.example.broordersender;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
public class senderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtra = getResultExtras( true);
        String stringExtra = resultExtra.getString( "stringExtra" );

        resultCode++;
        stringExtra += "->senderReceiver";

        String toastText = "senderReceiver\n"+
                           "resultCode: " + resultCode + "\n" +
                           "resultData: " + resultData + "\n" +
                           "stringExtra: " + stringExtra;

        Toast.makeText( context, toastText, Toast.LENGTH_SHORT ).show();

        resultData = "senderReceiver";
        resultExtra.putString( "stringExtra", stringExtra );

        setResult( resultCode, resultData, resultExtra );    }
}
