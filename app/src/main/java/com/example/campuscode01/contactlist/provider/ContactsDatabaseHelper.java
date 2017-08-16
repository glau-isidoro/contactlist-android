package com.example.campuscode01.contactlist.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "campus_contacts.db";
    public static final int DATABASE_VERSION = 1;

    public ContactsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ContactModel.CREATE_CONTACTS_TABLE);
        //se tiver mais tabelas no mesmo banco, criar todas aqui. Ex:
        //sqLiteDatabase.execSQL(AddressModel.CREATE_ADDRESS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //em atualizacao do app, se atualizar banco, precisa atualizar todas as versoes entre a nova e a velha em cascata
        if(newVersion > oldVersion) {
            switch(oldVersion) {
                case 1:
            }
        }
    }
}
