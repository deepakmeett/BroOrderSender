package com.example.broordersender;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        button = findViewById( R.id.buttonPanel );
        textView = findViewById( R.id.text );
        
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( "com.example.EXAMPLE_ACTION" );
                intent.setPackage( "com.example.broorderreceiver" );
//                sendBroadcast( intent ); //Normal Broadcast
//                sendOrderedBroadcast( intent, null ); // Priority Broadcast
                
                Bundle bundle = new Bundle(  );
                bundle.putString( "stringExtra", "start" );
                
                sendOrderedBroadcast( intent, null, new senderReceiver(), 
                                      null, 0, "start", bundle);
            }
        } );
    }
}
