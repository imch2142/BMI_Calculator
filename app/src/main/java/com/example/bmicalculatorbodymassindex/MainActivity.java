package com.example.bmicalculatorbodymassindex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    TextView textView1;
    TextView textView2;
    EditText editText1,editText2;
    float num1,num2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        editText1=findViewById(R.id.number1);
        editText2=findViewById(R.id.number2);
        textView1=findViewById(R.id.result1);
        textView2=findViewById(R.id.result2);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(this);



    }
    public float empty(EditText editText){
        if(editText.getText().toString().equals("")){
            Toast.makeText(this,"Enter an number ",Toast.LENGTH_LONG).show();
            return 0;
        }
        else return Float.parseFloat(editText.getText().toString());

    }

    @Override
    public void onClick(View v) {
        num1=empty(editText1);
        num2=empty(editText2);
        if (num2 == 0) {
            Toast.makeText(this, "الطول لا يمكن أن يكون صفر", Toast.LENGTH_SHORT).show();
            return;
        }

        float res=num2/(num1*num1);
        textView1.setText(String.format("BMI = %.2f", res));


        if (res < 18.5) {
                textView2.setText("less then normal weight");



            } else if (18.5 < res && res < 29.4) {
                textView2.setText(" normal weight");


            } else if (25 < res && res < 29.9) {
                textView2.setText(" more weight");

            } else {
                textView2.setText(" Fatt !!! ");

            }





    }
}