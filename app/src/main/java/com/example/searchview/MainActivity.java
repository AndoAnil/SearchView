package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=(SearchView)findViewById(R.id.searchView);
        listView=(ListView)findViewById(R.id.searchList);
        list=new ArrayList<>();
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        list.add("Anil");
        list.add("Kumar");
        list.add("lalit");
        list.add("Chirag");
        list.add("Mummy");
        list.add("Papa");
        list.add("Jimmy");
        list.add("Kutta");
        list.add("Anil");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        listView.setAdapter(adapter);
        listView.deferNotifyDataSetChanged();

    }
}
