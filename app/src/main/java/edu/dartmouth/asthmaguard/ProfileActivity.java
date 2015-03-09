package edu.dartmouth.asthmaguard;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



// extra credit -- take from camera or gallery

public class ProfileActivity extends Activity {

    public static final int REQUEST_CODE_TAKE_FROM_CAMERA = 0;
    public static final int REQUEST_CODE_TAKE_FROM_GALLERY = 1;
    public static final int REQUEST_CODE_CROP_PHOTO = 2;



    private static final String IMAGE_UNSPECIFIED = "image/*";
    private static final String URI_INSTANCE_STATE_KEY = "saved_uri";

    private Uri mImageCaptureUri;
    private ImageView mImageView;
    private boolean isTakenFromCamera;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        mImageView = (ImageView) findViewById(R.id.imageProfile);

        if (savedInstanceState != null) {
            mImageCaptureUri = savedInstanceState
                    .getParcelable(URI_INSTANCE_STATE_KEY);
        }

        loadSnap();
        loadUserData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the image capture uri before the activity goes into background
        outState.putParcelable(URI_INSTANCE_STATE_KEY, mImageCaptureUri);
    }

    // ****************** button click callbacks ***************************//



    public void onSaveClicked(View v) {
        // Save picture
        saveSnap();
        // Save data
        saveUserData();
        // Making a "toast" informing the user the picture is saved.
//        Toast.makeText(getApplicationContext(),
//                getString(R.string.ui_profile_toast_save_text),
//                Toast.LENGTH_SHORT).show();
        // Close the activity
        finish();
    }

    public void onChangePhotoClicked(View v) {
        // Take photo from camera，
        // Construct an intent with action
        // MediaStore.ACTION_IMAGE_CAPTURE
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Construct temporary image path and name to save the taken
//        // photo
//        mImageCaptureUri = Uri.fromFile(new File(Environment
//                .getExternalStorageDirectory(), "tmp_"
//                + String.valueOf(System.currentTimeMillis()) + ".jpg"));
//        intent.putExtra(MediaStore.EXTRA_OUTPUT,
//                mImageCaptureUri);
//        intent.putExtra("return-data", true);
//        try {
//            // Start a camera capturing activity
//            // REQUEST_CODE_TAKE_FROM_CAMERA is an integer tag you
//            // defined to identify the activity in onActivityResult()
//            // when it returns
//            startActivityForResult(intent, REQUEST_CODE_TAKE_FROM_CAMERA);
//        } catch (ActivityNotFoundException e) {
//            e.printStackTrace();
//        }
//        isTakenFromCamera = true;
        // changing the profile image, show the dialog asking the user
        // to choose between taking a picture
        // Go to MyRunsDialogFragment for details.
        displayDialog(MyDialogFragment.PHOTO);
    }
    public void displayDialog(int id){
        MyDialogFragment mdf = MyDialogFragment.newInstance(id);
        mdf.show(getFragmentManager(),getString(R.string.dialog_fragment_tag_general));
    }

    public void photo_item_select(int position){
        switch (position){
            //select photos from camera == position 0
            case 0:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Construct temporary image path and name to save the taken
                // photo
                mImageCaptureUri = Uri.fromFile(new File(Environment
                        .getExternalStorageDirectory(), "tmp_"
                        + String.valueOf(System.currentTimeMillis()) + ".jpg"));
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        mImageCaptureUri);
                intent.putExtra("return-data", true);
                try {
                    // Start a camera capturing activity
                    // REQUEST_CODE_TAKE_FROM_CAMERA is an integer tag you
                    // defined to identify the activity in onActivityResult()
                    // when it returns
                    startActivityForResult(intent, REQUEST_CODE_TAKE_FROM_CAMERA);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
                isTakenFromCamera = true;
                break;
            //select photos from gallery == position 1
            case 1:

                // Start a photo selection activity
                // REQUEST_CODE_TAKE_FROM_ALBUM is an integer tag
                // defined to identify the activity in onActivityResult()
                // when it returns

                Intent intentFromAlbum = new Intent((String) null, null);
                intentFromAlbum.setType("image/*");
                intentFromAlbum.setAction(Intent.ACTION_PICK);
                startActivityForResult(intentFromAlbum,
                        REQUEST_CODE_TAKE_FROM_GALLERY);
                break;

            default:
                return;
        }
    }

    // Handle data after activity returns.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;

        switch (requestCode) {
            case REQUEST_CODE_TAKE_FROM_CAMERA:
                // Send image taken from camera for cropping
                cropImage();
                break;

            case REQUEST_CODE_TAKE_FROM_GALLERY:
                mImageCaptureUri = data.getData();
                cropImage();
                break;

            case REQUEST_CODE_CROP_PHOTO:
                // Update image view after image crop
                Bundle extras = data.getExtras();
                // Set the picture image in UI
                if (extras != null) {
                    mImageView
                            .setImageBitmap((Bitmap) extras.getParcelable("data"));
                }

                // Delete temporary image taken by camera after crop.
                if (isTakenFromCamera) {
                    File f = new File(mImageCaptureUri.getPath());
                    if (f.exists())
                        f.delete();
                }

                break;
        }


    }

    // ****************** private helper functions ***************************//

    private void loadSnap() {

        // Load profile photo from internal storage
        try {
            FileInputStream fis = openFileInput(getString(R.string.profile_photo_file_name));
            Bitmap bmap = BitmapFactory.decodeStream(fis);
            mImageView.setImageBitmap(bmap);
            fis.close();
        } catch (IOException e) {
            // Default profile photo if no photo saved before.
            mImageView.setImageResource(R.drawable.default_profile);
        }
    }

    private void saveSnap() {

        // Commit all the changes into preference file
        // Save profile image into internal storage.
        mImageView.buildDrawingCache();
        Bitmap bmap = mImageView.getDrawingCache();
        try {
            FileOutputStream fos = openFileOutput(
                    getString(R.string.profile_photo_file_name), MODE_PRIVATE);
            bmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // Crop and resize the image for profile
    private void cropImage() {
        // Use existing crop activity.
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(mImageCaptureUri, IMAGE_UNSPECIFIED);

        // Specify image size
        intent.putExtra("outputX", 100);
        intent.putExtra("outputY", 100);

        // Specify aspect ratio, 1:1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("scale", true);
        intent.putExtra("return-data", true);
        // REQUEST_CODE_CROP_PHOTO is an integer tag you defined to
        // identify the activity in onActivityResult() when it returns
        startActivityForResult(intent, REQUEST_CODE_CROP_PHOTO);
    }

    public void onCancleCliked(View v){
        finish();
    }

    // ****************** private helper functions ***************************//

    // load the user data from shared preferences if there is no data make sure
    // that we set it to something reasonable
    private void loadUserData() {

        // We can also use log.d to print to the LogCat

        // Log.d(TAG, "loadUserData()");

        // Load and update all profile views

        // Get the shared preferences - create or retrieve the activity
        // preference object

        String mKey = getString(R.string.preference_name);
        SharedPreferences mPrefs = getSharedPreferences(mKey, MODE_PRIVATE);

        // Load the user name

        mKey = getString(R.string.preference_key_profile_name);
        String mValue = mPrefs.getString(mKey, " ");
        ((EditText) findViewById(R.id.edit_name)).setText(mValue);
        // Load the user email

        mKey = getString(R.string.preference_key_profile_email);
        String mValue1 = mPrefs.getString(mKey, " ");
        ((EditText) findViewById(R.id.edit_email)).setText(mValue1);

        // Load the user phone

        mKey = getString(R.string.preference_key_profile_phone);
        String mValue2 = mPrefs.getString(mKey, " ");
        ((EditText) findViewById(R.id.edit_phone)).setText(mValue2);

        // Load the user class


        // Please Load gender info and set radio box

        mKey = getString(R.string.preference_key_profile_gender);

        int mIntValue = mPrefs.getInt(mKey, -1);
        // In case there isn't one saved before:
        if (mIntValue >= 0) {
            // Find the radio button that should be checked.
            RadioButton radioBtn = (RadioButton) ((RadioGroup) findViewById(R.id.radioGroup))
                    .getChildAt(mIntValue);
            // Check the button.
            radioBtn.setChecked(true);
            Toast.makeText(getApplicationContext(),
                    "number of the radioButton is : " + mIntValue,
                    Toast.LENGTH_SHORT).show();
        }

    }

    // load the user data from shared preferences if there is no data make sure
    // that we set it to something reasonable
    private void saveUserData() {

        //Log.d(TAG, "saveUserData()");

        // Getting the shared preferences editor

        String mKey = getString(R.string.preference_name);
        SharedPreferences mPrefs = getSharedPreferences(mKey, MODE_PRIVATE);

        SharedPreferences.Editor mEditor = mPrefs.edit();
        mEditor.clear();

        // Save email information

        mKey = getString(R.string.preference_key_profile_email);
        String mValue = (String) ((EditText) findViewById(R.id.edit_email))
                .getText().toString();
        mEditor.putString(mKey, mValue);

        // Save name information

        mKey = getString(R.string.preference_key_profile_name);
        String mValue1 = (String) ((EditText) findViewById(R.id.edit_name))
                .getText().toString();
        mEditor.putString(mKey, mValue1);

        // Save phone information

        mKey = getString(R.string.preference_key_profile_phone);
        String mValue2 = (String) ((EditText) findViewById(R.id.edit_phone))
                .getText().toString();
        mEditor.putString(mKey, mValue2);

        // Save class information


        // Read which index the radio is checked.

        // edit this out and use as a debug example
        // interesting bug because you try and write an int to a string

        mKey = getString(R.string.preference_key_profile_gender);

        RadioGroup mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int mIntValue = mRadioGroup.indexOfChild(findViewById(mRadioGroup
                .getCheckedRadioButtonId()));
        mEditor.putInt(mKey, mIntValue);

        // Commit all the changes into the shared preference
        mEditor.commit();

        Toast.makeText(getApplicationContext(), "saved name: " + mValue,
                Toast.LENGTH_SHORT).show();

    }
}
