package com.example.campuscode01.contactlist.tasks;

import android.os.AsyncTask;

import com.example.campuscode01.contactlist.models.Contact;
import com.example.campuscode01.contactlist.provider.WebApi;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetContactsTask extends AsyncTask<Void, List<Contact>, List<Contact>> {

    private OnSyncFinished sync;

    public GetContactsTask(OnSyncFinished sync) {
        this.sync = sync;
    }


    @Override
    protected List<Contact> doInBackground(Void... voids) {
        WebApi web = new WebApi();
        List<Contact> contactsList = new ArrayList<>();
        try {
            String json = web.getContacts();
            Gson gson = new Gson();
            contactsList = Arrays.asList(gson.fromJson(json, Contact[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactsList;
    }

    @Override
    protected void onPostExecute(List<Contact> contactsList) {
        super.onPostExecute(contactsList);
            sync.finishedSync(contactsList);
    }

    public interface OnSyncFinished {
        void finishedSync(List<Contact> contactsList);
    }

}
