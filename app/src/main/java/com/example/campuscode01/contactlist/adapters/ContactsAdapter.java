package com.example.campuscode01.contactlist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.campuscode01.contactlist.R;
import com.example.campuscode01.contactlist.models.Contact;

import org.w3c.dom.Text;

import java.util.List;

public class ContactsAdapter extends BaseAdapter {

    private List<Contact> contacts;
    private Context context;

    public ContactsAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewHolder = view;
        if(viewHolder == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            viewHolder = inflater.inflate(R.layout.contacts_item_layout, null);
        }
        TextView name = (TextView) viewHolder.findViewById(R.id.tv_contact_item_name);
        TextView phone = (TextView) viewHolder.findViewById(R.id.tv_contact_item_phone);

        name.setText(contacts.get(i).getName());
        phone.setText(contacts.get(i).getPhone());

        return viewHolder;
    }
}
