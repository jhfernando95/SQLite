package com.jonmid.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.jonmid.sqlite.Data.DataUser;
import com.jonmid.sqlite.Models.User;

public class CreateUserActivity extends AppCompatActivity {
    Button create;
    EditText name,email;
    DataUser dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        create = (Button) findViewById(R.id.id_btn_joinUs);
        name = (EditText) findViewById(R.id.id_tie_name);
        email = (EditText) findViewById(R.id.id_tie_email);
        dataUser = new DataUser(this);
        dataUser.open();


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createData();
                onShowAccount2();

            }
        });
    }

    private void createData(){
        User user = new User();
        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        dataUser.create(user);

    }

    public void onShowAccount2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
