package com.example.dellpc.lab1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivity";
    static int TAKE_PICTURE = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageButton imageButton;
    Switch switch1;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);


        imageButton = findViewById(R.id.imageButton);
        switch1 = (Switch) findViewById(R.id.switch1);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create intent with ACTION_IMAGE_CAPTURE action
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // start camera activity
                startActivityForResult(intent, TAKE_PICTURE);

                Intent resultIntent = new Intent();
                resultIntent.putExtra("Response", "Here is my response");
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
        switch1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        int duration = Toast.LENGTH_LONG;
                        String text = (switch1.isChecked() ? "Switch is on" : "Switch is off");
                        Toast ts = Toast.makeText(getApplicationContext(), text, duration);
                        ts.show();
                    }
                });


        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);

// 2. Chain together various setter methods to set the dialog characteristics


builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

.setTitle(R.string.dialog_title)
.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               // User clicked OK button
           }
       })



.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               // User cancelled the dialog
           }
       })
.show();


         */
        checkBox.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);

                        builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                                .setTitle(R.string.dialog_title)
                                .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent resultIntent = new Intent();
                                        resultIntent.putExtra("Response", "Here is my response");
                                        setResult(Activity.RESULT_OK, resultIntent);
                                        finish();
                                    }
                                })
//
//                        AlertDialog.Builder response = builder.setMessage(R.string.dialog_message)
//                                .setTitle(R.string.dialog_title)
//                                .setPositiveButton(R.string.dialog_ok,
//
//                                        new DialogInterface.onClickListener() {
//
//                                    public void onClick(DialogInterface dialog int id) {
//                                        Intent resultIntent = new Intent();
//                                        resultIntent.putExtra("Response", "Here is my response");
//                                        setResult(Activity.RESULT_OK, resultIntent);
//                                        finish();
//                                    }
//                                })
                                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                    }
                                });
                    }
                });
    }



    public void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");

    }

    public void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    public void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    public void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
