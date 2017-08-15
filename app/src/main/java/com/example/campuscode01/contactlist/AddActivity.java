package com.example.campuscode01.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private Button saveBtn;
    private EditText nome;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        saveBtn = (Button) findViewById(R.id.btn_save);

        saveBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        Bundle data = new Bundle();
        nome = (EditText) findViewById(R.id.et_name);
        phone = (EditText) findViewById(R.id.et_phone);
        data.putString("nome", nome.getText().toString());
        data.putString("telefone", phone.getText().toString());
        intent.putExtra("data", data);
        setResult(200, intent);
        finish();

    }

}
