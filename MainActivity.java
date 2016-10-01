package com.example.admin.unitconvertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText tempText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempText= (EditText)findViewById(R.id.EditText1);
    }

    public void convert(View view){

        switch (view.getId()) {
            case R.id.button1:
                RadioButton FarenheitButton = (RadioButton) findViewById(R.id.FarenheitButton);
                RadioButton CelciusButton = (RadioButton) findViewById(R.id.CelsiusButton);
                if (tempText.getText().length() == 0){
                    Toast.makeText(this, "Please Enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }
                float temp= Float.parseFloat(tempText.getText().toString());
                if(CelciusButton.isChecked()){
                    tempText.setText(String.valueOf(convertfar2cel(temp)));
                }else if(FarenheitButton.isChecked())
                    tempText.setText(String.valueOf(convertcel2far(temp)));
                break;
        }

    }

    private double convertfar2cel(float t){
        return ((t-32)*0.556);
    }

    private double convertcel2far(float t){
        return ((t*(1.8))+32);
    }


}
