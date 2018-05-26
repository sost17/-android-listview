package com.col.commo.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<HashMap<String, Object>> dataList;
    private SimpleAdapter adapter;
    private ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_listview_layout);

        dataList = new ArrayList<HashMap<String,Object>>();
        HashMap<String, Object> map;
        for (int i = 0; i < 50; i++) {
            map = new HashMap<String, Object>();
            map.put("img", R.mipmap.ic_launcher);
            map.put("text", "第"+(i+1)+"个测试文本");
            map.put("cbx", "");
            map.put("btn", "详情");
            dataList.add(map);
        }
        adapter = new SimpleAdapter(this, dataList,R.layout.simple_list_item_layout,
                new String[]{"img","text","cbx","btn"},
                new int[]{R.id.simple_image,R.id.simple_text,R.id.simple_cbx,R.id.simple_btn});

        simpleList = (ListView) findViewById(R.id.array_listview);
        simpleList.setAdapter(adapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "你点击的是"+(position+1)+"项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
