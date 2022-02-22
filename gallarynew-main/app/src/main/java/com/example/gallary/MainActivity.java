package com.example.gallary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //THE EXPANDABLE
        ExpandableListView elv=(ExpandableListView) findViewById(R.id.expandablelistview1);

        final ArrayList<Team> team=getData();

        //CREATE AND BIND TO ADAPTER
        CustomAdapter adapter=new CustomAdapter(this, team);
        elv.setAdapter(adapter);


        //SET ONCLICK LISTENER
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPos,
                                        int childPos, long id) {

                Toast.makeText(getApplicationContext(), team.get(groupPos).players.get(childPos), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    //ADD AND GET DATA

    private ArrayList<Team> getData()
    {

        Team t1=new Team("Diwali");
        t1.players.add("2019");
        t1.players.add("2020");
        t1.players.add("2021");


        Team t2=new Team("Dhuleti");
        t2.players.add("2019");
        t2.players.add("2020");
        t2.players.add("2021");


        Team t3=new Team("Uttrayan");
        t3.players.add("2019");
        t3.players.add("2020");
        t3.players.add("2021");

        Team t4=new Team("Navratri");
        t4.players.add("2019");
        t4.players.add("2020");
        t4.players.add("2021");

        Team t5=new Team("Gandhi jayanti");
        t5.players.add("2019");
        t5.players.add("2020");
        t5.players.add("2021");



        ArrayList<Team> allTeams=new ArrayList<Team>();
        allTeams.add(t1);
        allTeams.add(t2);
        allTeams.add(t3);
        allTeams.add(t4);
        allTeams.add(t5);

        return allTeams;
    }
}