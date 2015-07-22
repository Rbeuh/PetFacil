package br.com.rbeuh.petfacil.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by enzo on 22/07/2015.
 */
public class ShowMessage
{
    public static void showToast(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG);
    }

    public static void showDialog(Context context, String title, String message)
    {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton("Ok", null)
                .show();
    }
}
