package com.thanhtam.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    ArrayList<String> arrayMonHoc;
    int vitri = -1;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc = (ListView)findViewById(R.id.listViewMonhoc);
        arrayMonHoc = new ArrayList<>();

        arrayMonHoc.add("Andoird");
        arrayMonHoc.add("IOS");
        arrayMonHoc.add("PHP");
        arrayMonHoc.add("Unity");
        arrayMonHoc.add("Cocos");
        arrayMonHoc.add("ASP");


        arrayAdapter = new ArrayAdapter(
                MainActivity.this,android.R.layout.simple_list_item_1,arrayMonHoc);
        lvMonHoc.setAdapter(arrayAdapter);

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDiaLogItem();
                vitri = position;
//                Toast.makeText(MainActivity.this,"ABC",Toast.LENGTH_SHORT).show();


                return false;
            }
        });
    }



    /*Tạo báo cáo xác nhận*/
    private void ShowAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận xóa");
        builder.setMessage("Bạn có muốn xóa môn học này");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Xóa item của môn học đó
                arrayMonHoc.remove(vitri);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Đã xóa",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//           Không làm j hết

            }
        });
        builder.setNeutralButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();




    }
    private void AlertDiaLogItem(){
        String [] item = {"Yes", "No", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Delete");
        builder.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which){
                    case 0 : Toast.makeText(MainActivity.this,"Yes",Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :Toast.makeText(MainActivity.this,"No",Toast.LENGTH_SHORT).show();
                        break;
                    case 2 : Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
                        break;



                }

            }
        }).show();

    }
}
