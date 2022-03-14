package com.better.nutritiontherapy;

import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pedro on 15/9/2015.
 */
public class Utils {

    public static String formatDateToString(Date date, String pattern) {
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static boolean isEmptyField(EditText et) {
        return (et.getText() == null || et.getText().toString().isEmpty());
    }


}
