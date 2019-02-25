package com.example.fr3on.nourishlocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.fr3on.nourishlocal.adapter.communityListAdapter;
import com.example.fr3on.nourishlocal.adapter.communityRecyclerAdapter;
import com.example.fr3on.nourishlocal.model.community;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private RecyclerView typesListView;
    public static final String TAG = MainActivity.class.getSimpleName();

    private communityRecyclerAdapter communityRecyclerAdapter;
    private ArrayList<community> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.nameEditText);
        typesListView = findViewById(R.id.typesListView);
        typesListView.setHasFixedSize(true);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(this);
        typesListView.setLayoutManager(LinearLayoutManager);


        community community1 = new community(getString(R.string.eat),getString(R.string.eat_description),R.drawable.eat);
        community community2 = new community(getString(R.string.shop),getString(R.string.shop_description),R.drawable.shop);
        community community3 = new community(getString(R.string.cook),getString(R.string.cook_description),R.drawable.cook);
        community community4 = new community(getString(R.string.make),getString(R.string.make_description),R.drawable.make);
        community community5 = new community(getString(R.string.grow),getString(R.string.grow_description),R.drawable.grow);

        list.add(community1);
        list.add(community2);
        list.add(community3);
        list.add(community4);
        list.add(community5);

        communityRecyclerAdapter= new communityRecyclerAdapter(list,this);
        typesListView.setAdapter(communityRecyclerAdapter);




    }

    public void openDetailes (community community){
        Intent intent = new Intent(MainActivity.this,DetailesActivity.class);
        intent.putExtra(getString(R.string.frieng_name_key),nameEditText.getText().toString());
        intent.putExtra(getString(R.string.community_key),community);
        startActivity(intent);

    }
}
