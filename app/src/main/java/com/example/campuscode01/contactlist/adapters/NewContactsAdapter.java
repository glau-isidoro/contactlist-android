package com.example.campuscode01.contactlist.adapters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.campuscode01.contactlist.R;
import com.example.campuscode01.contactlist.provider.ContactModel;

public class NewContactsAdapter extends CursorAdapter {

    private Context context;

    public NewContactsAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.context = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.contacts_item_layout, null);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.tv_contact_item_name);
        TextView phone = (TextView) view.findViewById(R.id.tv_contact_item_phone);
        ImageButton delBtn = (ImageButton) view.findViewById(R.id.btn_delete);

        name.setText(cursor.getString(cursor.getColumnIndex(ContactModel.NAME)));
        phone.setText(cursor.getString(cursor.getColumnIndex(ContactModel.PHONE)));
        final String id = cursor.getString(cursor.getColumnIndex(ContactModel._ID));
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.getContentResolver().delete(Uri.withAppendedPath(ContactModel.CONTENT_URI, id), null, null);
                notifyDataSetChanged();
            }
        });
    }
}