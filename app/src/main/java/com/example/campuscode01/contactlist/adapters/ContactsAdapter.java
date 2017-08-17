package com.example.campuscode01.contactlist.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campuscode01.contactlist.MainActivity;
import com.example.campuscode01.contactlist.R;
import com.example.campuscode01.contactlist.models.Contact;
import com.example.campuscode01.contactlist.provider.ContactModel;

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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View viewHolder = view;
        if(viewHolder == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            viewHolder = inflater.inflate(R.layout.contacts_item_layout, null);
        }
        TextView name = (TextView) viewHolder.findViewById(R.id.tv_contact_item_name);
        TextView phone = (TextView) viewHolder.findViewById(R.id.tv_contact_item_phone);
        ImageButton delBtn = (ImageButton) viewHolder.findViewById(R.id.btn_delete);

        name.setText(contacts.get(i).getName());
        phone.setText(contacts.get(i).getPhone());
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), contacts.get(i).getId().toString(), Toast.LENGTH_SHORT).show();
                context.getContentResolver().delete(Uri.withAppendedPath(ContactModel.CONTENT_URI, contacts.get(i).getId().toString()), null, null);

                contacts.remove(i);

                notifyDataSetChanged();

            }
        });

        return viewHolder;
    }

}
