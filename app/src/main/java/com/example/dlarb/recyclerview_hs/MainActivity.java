package com.example.dlarb.recyclerview_hs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    EditText edt;
    SharedPreferences mprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.text1);
        btn = findViewById(R.id.btn);
        edt=findViewById(R.id.text2);

        mprefs = getSharedPreferences("UserName",MODE_PRIVATE);
        String values = mprefs.getString("value","");

        tv.setText(values);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences.Editor nEditor = mprefs.edit();
                nEditor.putString("value", edt.getText().toString());
                nEditor.apply();


                tv.setText(edt.getText().toString());
                edt.setText("");
            }
        });
    }
}
