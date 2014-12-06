package com.siliconvalleyinsight.mwork.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import  android.provider.MediaStore.Files.FileColumns;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.siliconvalleyinsight.mwork.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import android.app.DialogFragment;

public class PhotoTaskActivity extends Activity {

    private static final int CAMERA_REQUEST = 20;
    private ImageButton mTakePhotoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_task);

        mTakePhotoButton = (ImageButton) findViewById(R.id.take_photo_button);
        mTakePhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mTakePhotoButton.setImageBitmap(photo);
            showNoticeDialog();
        }
    }

    public void showNoticeDialog() {
        // Create an instance of the SubmitPhotoDialog fragment and show it
        DialogFragment dialog = new SubmitPhotoDialogFragment(this);
        dialog.show(getFragmentManager(), "SubmitPhotoDialogFragment");
    }

    public static class SubmitPhotoDialogFragment extends DialogFragment {
        private Context mContext;

        public SubmitPhotoDialogFragment(Context activity) {
            mContext = activity;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("Submit this photo to complete task?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Notify user
                            Context context = mContext.getApplicationContext();
                            CharSequence text = "You will earn $4.00 after photo review.";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();

                            // Finish activity
                            getActivity().finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
