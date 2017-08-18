package com.example.campuscode01.contactlist.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.campuscode01.contactlist.MainActivity;
import com.example.campuscode01.contactlist.provider.ContactsProvider;
import com.example.campuscode01.contactlist.provider.WebApi;

import java.io.IOException;

public class SendContactTask extends AsyncTask<Void, Integer, Integer> {

    private String name;
    private String phone;
    private Context context;

    public SendContactTask(Context context, String name, String phone) {
        this.context = context;
        this.name = name;
        this.phone = phone;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        WebApi web = new WebApi();
        int result = -1;
        try {
            web.postContact(name, phone);
            result = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        switch(integer) {
            case -1:
                Toast.makeText(context, "Falhou...", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, "Contato salvo!", Toast.LENGTH_SHORT).show();

        }
    }
}
