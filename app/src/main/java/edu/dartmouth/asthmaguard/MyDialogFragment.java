package edu.dartmouth.asthmaguard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MyDialogFragment extends DialogFragment {

    // Different dialog IDs
    public static final int ERROR = -1;
    public static final int DATE = 1;
    public static final int TIME = 2;
    public static final int DURATION = 3;
    public static final int EVENTTYPE = 4;
    public static final int DEGREE = 5;
    public static final int DETAIL_COUGHING = 6;
    public static final int PHOTO = 7;


    private static final String DIALOG_ID_KEY = "dialog_id";


    public static MyDialogFragment newInstance(int dialog_id) {
        MyDialogFragment frag = new MyDialogFragment();
        Bundle args = new Bundle();
        args.putInt(DIALOG_ID_KEY, dialog_id);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int dialog_id = getArguments().getInt(DIALOG_ID_KEY);

        final Activity parent = getActivity();
        final Calendar mDateAndTime = Calendar.getInstance();

        // Setup dialog appearance and onClick Listeners
        switch (dialog_id) {

            case DATE:

                DatePickerDialog.OnDateSetListener mDateListener = new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        ((DisplayEntryActivity) parent).onDateSet(year, monthOfYear,
                                dayOfMonth);
                    }
                };

                return new DatePickerDialog(getActivity(), mDateListener,
                        mDateAndTime.get(Calendar.YEAR), mDateAndTime.get(Calendar.MONTH),
                        mDateAndTime.get(Calendar.DAY_OF_MONTH));


            case TIME:
                TimePickerDialog.OnTimeSetListener mTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        ((DisplayEntryActivity) parent).onTimeSet(hourOfDay, minute);
                    }
                };

                return new TimePickerDialog(getActivity(), mTimeListener,
                        mDateAndTime.get(Calendar.HOUR_OF_DAY), mDateAndTime.get(Calendar.MINUTE),
                        true);

            case DURATION:

                //display an editText
                final EditText textDuration = new EditText(parent);
                textDuration.setInputType(InputType.TYPE_CLASS_NUMBER
                        | InputType.TYPE_NUMBER_FLAG_DECIMAL);

                return new AlertDialog.Builder(parent)
                        .setTitle(R.string.duration_tag)
                        .setView(textDuration)
                        .setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {

                                        String duration = textDuration.getText()
                                                .toString();
                                        if (!duration.isEmpty()) {
                                            ((DisplayEntryActivity) parent)
                                                    .onDurationSet(Double
                                                            .parseDouble(duration));
                                        }
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {
                                        // Cancelled.
                                        dismiss();
                                    }
                                }).create();

            case EVENTTYPE:
                //display an editText

                final String[] cities = {"Coughing", "Wheezing", "Dyspnea"};

                return new AlertDialog.Builder(parent)
                        //.setIcon(R.drawable.ic_launcher)
                        .setTitle("Select an event type")
                                //    指定下拉列表的显示数据

                                //    设置一个下拉的列表选择项
                        .setItems(cities, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                // Toast.makeText(getActivity(), "选择的城市为：" + cities[which], Toast.LENGTH_SHORT).show();
                                String dist = cities[which];
                                if (!dist.isEmpty()) {
                                    ((DisplayEntryActivity) parent)
                                            .onEventTypeSet(dist);
                                }
                            }
                        }).show();

//                final EditText textDistance = new EditText(parent);
//                textDistance.setInputType(InputType.TYPE_CLASS_TEXT);
//
//                return new AlertDialog.Builder(parent)
//
//                        .setTitle(R.string.eventtype_tag)
//                        .setView(textDistance)
//                        .setPositiveButton("Ok",
//                                new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog,
//                                                        int whichButton) {
//
//                                        String dist = textDistance.getText()
//                                                .toString();
//                                        if (!dist.isEmpty()) {
//                                            ((DisplayEntryActivity) parent)
//                                                    .onEventTypeSet(dist);
//                                        }
//                                    }
//                                })
//                        .setNegativeButton("Cancel",
//                                new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog,
//                                                        int whichButton) {
//                                        // Cancelled.
//                                        dismiss();
//                                    }
//                                }).create();

            case DEGREE:
                //display an editText
                final String[] degree = {"1", "2", "3", "4", "5", "6", "7", "8","9","10"};

                return new AlertDialog.Builder(parent)
                        //.setIcon(R.drawable.ic_launcher)
                        .setTitle("Select intensity degree")
                                //    指定下拉列表的显示数据

                                //    设置一个下拉的列表选择项
                        .setItems(degree, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                // Toast.makeText(getActivity(), "选择的城市为：" + cities[which], Toast.LENGTH_SHORT).show();
                                String dist = degree[which];
                                if (!dist.isEmpty()) {
                                    ((DisplayEntryActivity) parent)
                                            .onDegreeSet(Long.parseLong(dist));
                                }
                            }
                        }).show();
            case DETAIL_COUGHING:
                //display an editText
                final TextView tv = new TextView(parent);
                tv.setText("The average coughing duration is 15.4 minutes per day");


                return new AlertDialog.Builder(parent)
                        .setTitle(R.string.degree_tag)
                        .setView(tv)
                        .create();
            case PHOTO:
                // Build picture picker dialog for choosing from camera or gallery
                AlertDialog.Builder builder = new AlertDialog.Builder(parent);
                builder.setTitle(R.string.photo_title);
                // Set up click listener, firing intents open camera
                DialogInterface.OnClickListener dlistener = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Item is ID_PHOTO_PICKER_FROM_CAMERA
                        // Call the onPhotoPickerItemSelected in the parent
                        // activity, i.e., ameraControlActivity in this case
                        ((ProfileActivity) parent)
                                .photo_item_select(item);
                    }
                };
                // Set the item/s to display and create the dialog
                builder.setItems(R.array.photo_select, dlistener);
                return builder.create();

            default:
                return null;
        }
    }
}
