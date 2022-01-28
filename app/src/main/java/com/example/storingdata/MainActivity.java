package com.example.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityViewCommand;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);


        sharedPreferences =this.getSharedPreferences("com.example.storingdata", Context.MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt("StoredAge",0);
        textView.setText("Your Age:" + storedAge);
    }
    public void save (View view){
        int age1=Integer.parseInt(editText1.getText().toString());
        textView.setText("Age :" + age1);
        sharedPreferences.edit().putInt("StoredAge" ,age1).apply();

    }
    public void clear(View view){
        int StoredData =sharedPreferences.getInt("StoredAge" ,0);
        if (StoredData !=0){
            sharedPreferences.edit().remove("StoredAge").apply();
            textView.setText("Age: ");
        }


    }

}