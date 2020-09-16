package com.example.ex072;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText t1, t2,t3;
    Float a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      t1=findViewById(R.id.etd1);
      t2=findViewById(R.id.etd2);
      t3= findViewById(R.id.etd3);

    }


    public void randomnum(View view) {
        Random rnd=new Random();
        a=(-100)+rnd.nextFloat()*(100-(-100));
        if(rnd.nextBoolean()) {
            a = a *-1;
        }
        b=(-100)+rnd.nextFloat()*(100-(-100));
        if(rnd.nextBoolean()) {
            b = b *-1;
        }
        c=(-100)+rnd.nextFloat()*(100-(-100));
        if(rnd.nextBoolean()) {
            c = c*-1;
        }

        t1.setText(""+a);
        t2.setText(""+b);
        t3.setText(""+c);

    }

    public void secend(View view) {
        if(a==null) {
            Toast.makeText(this, "please enter a number in a", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent se=new Intent(this,hishov.class);
            se.putExtra("aa",a);
            se.putExtra("bb", b);
            se.putExtra("cc", c);
            startActivity(se);


        }
    }
}