package com.poapper.wowmuchapp.wowmuchapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.poapper.wowmuchapp.wowmuchapp.math.Adder;
import com.poapper.wowmuchapp.wowmuchapp.math.BinaryOperator;
import com.poapper.wowmuchapp.wowmuchapp.math.Operator;
import com.poapper.wowmuchapp.wowmuchapp.math.Subtractor;
import com.poapper.wowmuchapp.wowmuchapp.math.WowFyer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Our Entry Point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Main Code

        //Generate binary operators and set its operands
        BinaryOperator adder = new Adder();
        adder.setOperands(1, 2);
        BinaryOperator subtractor = new Subtractor();
        subtractor.setOperands(3, 4);
        BinaryOperator wowfyer = new WowFyer();
        wowfyer.setOperands(5, 6);

        //You can even make an operator on the fly
        BinaryOperator multifler = new BinaryOperator() {
            @Override
            public int apply() {
                return getLeft() + getRight();
            }

            @Override
            public String toString() {
                return String.format("%d * %d", getLeft(), getRight());
            }
        };
        multifler.setOperands(7, 8);

        //make a list of Operators
        List<Operator> operators = new ArrayList<>();
        //put items into the list
        operators.add(adder);
        operators.add(subtractor);
        operators.add(wowfyer);
        operators.add(multifler);

        //Iterate this list and prints the value
        for (Operator op : operators) {
            Log.d("TEST", op.toString() + " is " + op.apply());
        }
    }
}
