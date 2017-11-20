package com.example.gdrakpa.gdcal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.output);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public class store {

        private
        int top=-1,i=-1;
        double sum=0;
        String s0="";
        double[] ary=new double[3];
        double[] ary2=new double[10];

        void push(double el) {

            if (top < 2) {
                if (el != '+' && el != '-' && el != '/' && el != '*' && el != '=') {
                    // ary[++top] = el;
                    ary2[++i] = el;
                    //top++;
                    //t1.setText("in if");
                } else {
                    for (int j = 0; j <= i; j++) {
                        sum = sum + ary2[j] * Math.pow(10, i - j);// find a way to make the power logic work.
                    }
                    ary[++top] = sum;
                    sum = 0;//check if its correct plz
                    i = -1;
                    ;//check if its correct plz
                    if (top < 2) {//if ary is not full add the
                        ary[++top] = el;//some thing missing in this logic what if an operaor comes check!!
                    } else {
                        push(el);
                    }
                }
            } else {
                if (ary[1] == '+') {
                    ary[0] = ary[0] + ary[2];
                    if (el != '=') {
                        ary[1] = el;
                        top = top - 1;
                    } else {
                        top = top - 2;
                    }
                    //brings the top down to the second element which is an operator

                }
                if (ary[1] == '-') {

                    ary[0] = ary[0] - ary[2];
                    if (el != '=') {
                        ary[1] = el;
                        top = top - 1;
                    } else {
                        top = top - 2;
                    }

                }
                if (ary[1] == '*') {

                    ary[0] = ary[0] * ary[2];
                    if (el != '=') {
                        ary[1] = el;
                        top = top - 1;
                    } else {
                        top = top - 2;
                    }
                }
                if (ary[1] == '/') {

                    ary[0] = ary[0] / ary[2];
                    if (el != '=') {
                        ary[1] = el;
                        top = top - 1;
                    } else {
                        top = top - 2;
                    }
                }
                // t1.setText("done pulling");
            }
        }

        void pop() {
            double result = ary[0];// we put the value stored in the 0 idex of array in the result
            t1.setText(""+result);
            textset(""+result);

           s0="";
            top=-1;
        }
        void clear(){
            top=-1;
            t1.setText(R.string.myname);
            s0="";
        }
        void textset(String s){

            s0=s0+s;
            t1.setText(s0);
        }

    }

    store s1=new store();


public void store(View view){
    switch(view.getId()){

        case R.id.button: {
            s1.textset("1");
            s1.push(1);

            break;
        }
        case R.id.button2: {
            s1.textset("2");
            s1.push(2);
            break;

        }
        case R.id.button3: {
            s1.textset("3");
            s1.push(3);

            break;
        }
        case R.id.button4: {
            s1.textset("4");
            s1.push(4);
            break;
        }
        case R.id.button5: {
            s1.textset("5");
            s1.push(5);
            break;
        }
        case R.id.button6: {
            s1.textset("6");
            s1.push(6);

            break;
        }
        case R.id.button7: {
            s1.textset("7");
            s1.push(7);
            break;

        }
        case R.id.button8: {
            s1.textset("8");
            s1.push(8);
            break;
        }
        case R.id.button9: {
            s1.textset("9");
            s1.push(9);
            break;
        }
        case R.id.button10: {
            s1.textset("0");
            s1.push(0);
            break;
        }
        case R.id.button11: {
            s1.textset("+");
            s1.push('+');
            break;
        }
        case R.id.button12: {
            s1.textset("-");
            s1.push('-');
            break;
        }
        case R.id.button13: {
            s1.textset("/");
            s1.push('/');
            break;
        }
        case R.id.button14: {
            s1.textset("x");
            s1.push('*');

            break;
        }
        case R.id.button15: {
            s1.textset("=");
            s1.push('=');
            s1.pop();
            break;
        }
        case R.id.button16:
        {
            s1.clear();
        }
default:





}


}








        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
