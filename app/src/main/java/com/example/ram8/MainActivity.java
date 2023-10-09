package com.example.ram8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tabLayout;
TabItem mhome,mscience,mhealth,mtech,mentertaintainment,msport;
PageAdapter pageAdapter;
Toolbar mtoolbar;
    EditText editText;
   public static String country;
   String api="3351e79e040343a28cb14a60cd8d5637";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.edit);
        SharedPreferences getshrd=getSharedPreferences("demo",MODE_PRIVATE);
        String value=getshrd.getString("str1","in");
        editText.setText(value);
        country=value;

        mtoolbar=findViewById(R.id.toolbar);
      ///  setSupportActionBar(mtoolbar);
        mhome=findViewById(R.id.ram);
        mscience=findViewById(R.id.science);
        mhealth=findViewById(R.id.health);
        mtech=findViewById(R.id.technology);
        mentertaintainment=findViewById(R.id.entertainment);
        msport=findViewById(R.id.sport);
        ViewPager viewPager=findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.include);

        pageAdapter=new PageAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pageAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() ==0  || tab.getPosition() ==1|| tab.getPosition()==2||tab.getPosition() ==3||tab.getPosition()==4||tab.getPosition()==5){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        Button  button=findViewById(R.id.click);
        EditText editText=findViewById(R.id.edit);

        String[] country={"india","usa","china","Argentina","Greece " ,"Netherlands","South Africa"};
        Spinner spinner=findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,country);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String msg=editText.getText().toString().trim();
                SharedPreferences shrd=getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor=shrd.edit();
             //   editor.putString("str1",msg);
             //   editor.apply();
                //

               // String value=sp

                String string=spinner.getSelectedItem().toString();
                switch (string){
                    case "india":editor.putString("str1","in");
                        editor.apply();
                      //  Toast.makeText(MainActivity.this, "A", Toast.LENGTH_SHORT).show();
                        break;
                    case "usa":editor.putString("str1", "us");
                    editor.apply();
                     //   Toast.makeText(MainActivity.this, "B", Toast.LENGTH_SHORT).show();
                    break;
                    case "china":editor.putString("str1","ch");
                    editor.apply();
                        //Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
                    break;

                    case "Argentina":editor.putString("str1","ar");
                        editor.apply();
                        //Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
                        break;
                    case "Greece":editor.putString("str1","gr");
                        editor.apply();
                        //Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
                        break;
                    case "Netherlands":editor.putString("str1","nl");
                        editor.apply();
                        //Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
                        break;
                    case "South Africa":editor.putString("str1","za");
                        editor.apply();
                        //Toast.makeText(MainActivity.this, "C", Toast.LENGTH_SHORT).show();
                        break;

                }

               // String string=spinner.getSelectedItem().toString();
                SharedPreferences getshrd=getSharedPreferences("demo",MODE_PRIVATE);
                String value=getshrd.getString("str1","in");
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                finish();
                 startActivity(getIntent());
            }
        });
     //   SharedPreferences getshrd=getSharedPreferences("demo",MODE_PRIVATE);
      //  String value=getshrd.getString("str","in");
     //   editText.setText(value);

    }
}