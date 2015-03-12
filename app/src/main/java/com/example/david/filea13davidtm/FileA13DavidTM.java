package com.example.david.filea13davidtm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class FileA13DavidTM extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_a13_david_tm);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_file_a13_david_tm, menu);
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

    public void writeBoton(View v){
        CheckBox checkBoton=(CheckBox) findViewById(R.id.btnOverWrite);
        EditText ed=(EditText)findViewById(R.id.editText);
        try {
            FileOutputStream fos;
            if(checkBoton.isChecked()) fos=openFileOutput("fileM.txt", Context.MODE_PRIVATE);
            else fos=openFileOutput("fileM.txt", Context.MODE_APPEND);

            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(ed.getText().toString());
            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readBoton(View v){
        TextView tv=(TextView) findViewById(R.id.tvTexto);
        tv.setMovementMethod(new ScrollingMovementMethod());
        try {
            FileInputStream fis=openFileInput("fileM.txt");

            BufferedReader br=new BufferedReader(new InputStreamReader(fis));
            String texto,texto2="";
            while((texto=br.readLine())!=null)
                texto2+=texto;
            br.close();
            tv.setText(texto2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
