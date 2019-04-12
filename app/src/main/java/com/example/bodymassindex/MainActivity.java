package com.example.bodymassindex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCompute;
    EditText txtHeight,txtWeight,txtBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCompute = findViewById(R.id.btnCalculate);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        txtBMI = findViewById(R.id.txtBMI);

        btnCompute.setOnClickListener(this);

    }

    private void showToast(String message){
        Toast toast=Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG);
        toast.show();
    }

    private String categoriseBMI(float BMI){

        String category = null;

        if ( BMI < 18.5 ){
            category = "Underweight";
        }else if( BMI >= 18.5 && BMI < 24.9 ){
            category = "Normal Weight";
        }else if ( BMI >= 25 &&  BMI < 29.9 ){
            category = "Overweight";
        }else if( BMI >= 30 ){
            category = "Obesity";
        }
        return category;
    }

    @Override
    public void onClick(View v) {

        if ( v.getId() == R.id.btnCalculate ){

            float heightInCm = Float.parseFloat(txtHeight.getText().toString());
            float weightInKg = Float.parseFloat(txtWeight.getText().toString());

            float heightInM = heightInCm / 100;

            float BMI = weightInKg / (heightInM * heightInM);

            txtBMI.setText( BMI + "" );

            showToast(" Your BMI category is : "+categoriseBMI(BMI));

        }

    }
}
