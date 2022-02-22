package com.example.gallary;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends BaseExpandableListAdapter {

    private Context c;
    private ArrayList<Team> team;
    private LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Team> team) {
        this.c = c;
        this.team = team;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //GET A SINGLE PLAYER
    @Override
    public Object getChild(int groupPos, int childPos) {
        // TODO Auto-generated method stub
        return team.get(groupPos).players.get(childPos);
    }

    //GET PLAYER ID
    @Override
    public long getChildId(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

    //GET PLAYER ROW
    @Override
    public View getChildView(int groupPos, int childPos, boolean isLastChild, View convertView,
                             ViewGroup parent) {

        //ONLY INFLATER XML ROW LAYOUT IF ITS NOT PRESENT,OTHERWISE REUSE IT

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.festival, null);
        }

        //GET CHILD/PLAYER NAME
        String child = (String) getChild(groupPos, childPos);

        //SET CHILD NAME
        TextView nameTv = (TextView) convertView.findViewById(R.id.textView1);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView1);

        nameTv.setText(child);

        //GET TEAM NAME
        String teamName = getGroup(groupPos).toString();

        //ASSIGN IMAGES TO PLAYERS ACCORDING TO THEIR NAMES AN TEAMS
        if (teamName == "Diwali") {
            if (child == "2019") {
                img.setImageResource(R.drawable.diwali2019);
            } else if (child == "2020") {
                img.setImageResource(R.drawable.diwali2021);
            } else if (child == "2021") {
                img.setImageResource(R.drawable.diwalicelebration2);
            }
        }else if (teamName == "Dhuleti") {
            if (child == "2019") {
            img.setImageResource(R.drawable.dhuleti2019);
        } else if (child == "2020") {
            img.setImageResource(R.drawable.dhuleticelebration);
        } else if (child == "2021") {
            img.setImageResource(R.drawable.dhuleti2021);
        }
       }else if(teamName=="Uttrayan") {
            if(child=="2019") {
                img.setImageResource(R.drawable.uttrayan2019)   ;
            }else if(child=="2020") {
                img.setImageResource(R.drawable.uttrayan2020)    ;
            }else if(child=="2021") {
                img.setImageResource(R.drawable.uttrayancelebration) ;
            }
        } else if(teamName=="Navratri") {
            if(child=="2019") {
                img.setImageResource(R.drawable.navratri2019)   ;
            }else if(child=="2020") {
                img.setImageResource(R.drawable.navratri2020)    ;
            }else if(child=="2021") {
                img.setImageResource(R.drawable.navratricelebration) ;
            }
        } else if(teamName=="Gandhi jayanti") {
            if(child=="2019") {
                img.setImageResource(R.drawable.gandhijayanti2019)   ;
            }else if(child=="2020") {
                img.setImageResource(R.drawable.gandhijayanti2020)    ;
            }else if(child=="2021") {
                img.setImageResource(R.drawable.gandhijayanticelibration) ;
            }
        }


        return convertView;
    }

    //GET NUMBER OF PLAYERS
    @Override
    public int getChildrenCount(int groupPosw) {
        // TODO Auto-generated method stub
        return team.get(groupPosw).players.size();
    }

    //GET TEAM
    @Override
    public Object getGroup(int groupPos) {
        // TODO Auto-generated method stub
        return team.get(groupPos);
    }

    //GET NUMBER OF TEAMS
    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return team.size();
    }

    //GET TEAM ID
    @Override
    public long getGroupId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    //GET TEAM ROW
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        //ONLY INFLATE XML TEAM ROW MODEL IF ITS NOT PRESENT,OTHERWISE REUSE IT
        if(convertView == null)
        {
            convertView=inflater.inflate(R.layout.festival, null);
        }

        //GET GROUP/TEAM ITEM
        Team t=(Team) getGroup(groupPosition);

        //SET GROUP NAME
        TextView nameTv=(TextView) convertView.findViewById(R.id.textView1);
        ImageView img=(ImageView) convertView.findViewById(R.id.imageView1);

        String name=t.Name;
        nameTv.setText(name);

        //ASSIGN TEAM IMAGES ACCORDING TO TEAM NAME

        if(name=="Diwali")
        {
            img.setImageResource(R.drawable.diwalifest);
        }else if(name=="Dhuleti")
        {
            img.setImageResource(R.drawable.dhuleti);
        }else if(name=="Uttrayan")
        {
            img.setImageResource(R.drawable.utrayan);
        }else if(name=="Navratri")
        {
            img.setImageResource(R.drawable.navratifestival);
        }else if(name=="Gandhi jayanti")
        {
            img.setImageResource(R.drawable.gandhijayanti);
        }


        //SET TEAM ROW BACKGROUND COLOR
        convertView.setBackgroundColor(Color.LTGRAY);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }

}
