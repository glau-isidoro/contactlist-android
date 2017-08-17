package com.example.campuscode01.contactlist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.campuscode01.contactlist.adapters.ContactsAdapter;
import com.example.campuscode01.contactlist.models.Contact;
import com.example.campuscode01.contactlist.provider.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView contacts;
    private List<Contact> model;
    private FloatingActionButton addButton;
    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = (ListView) findViewById(R.id.lv_contacts);

        model = new ArrayList<>();

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, model);
        adapter = new ContactsAdapter(this, model);

        contacts.setAdapter(adapter);

        addButton = (FloatingActionButton) findViewById(R.id.btn_add);
        addButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, AddActivity.class);
//        startActivityForResult(intent, 1);
        startActivity(intent);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Bundle bundle = data.getBundleExtra("data");
//        Toast.makeText(this, "EITA", Toast.LENGTH_SHORT).show();
//        Contact contact = new Contact(bundle.get("nome").toString(), bundle.get("telefone").toString());
//        model.add(contact);
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
    }

    private void refreshList() {
        Cursor cursor = getContentResolver().query(ContactModel.CONTENT_URI, null, null, null, null);

        model.clear();
        if(cursor != null) {
            while(cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ContactModel.NAME));
                String phone = cursor.getString(cursor.getColumnIndex(ContactModel.PHONE));
                Long id = cursor.getLong(cursor.getColumnIndex(ContactModel._ID));
                Contact contact = new Contact(id, name, phone);
                model.add(contact);
            }
            cursor.close();
        }
        adapter.notifyDataSetChanged();

    }

}
