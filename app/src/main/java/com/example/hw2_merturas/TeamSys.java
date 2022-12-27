package com.example.hw2_merturas;

import java.util.ArrayList;

public class TeamSys {
    private static ArrayList<Teams> teamList=new ArrayList<Teams>();

    public static void prepareData()
    {
        teamList.add(new Teams("Bilkent Judges","Champion - 5W 0L",250,R.drawable.judges));
        teamList.add(new Teams("Gorillas"," 3W-2L",102,R.drawable.gorillas));
        teamList.add(new Teams("Hacettepe Reddeers","2W-3L",56,R.drawable.hacet));
        teamList.add(new Teams("METU Falcons","4W-1L",130,R.drawable.metu));
        teamList.add(new Teams("Mersin Mustangs","2W-3L",75,R.drawable.mustangs));

    }

    public static ArrayList<Teams> getTeamList() {
        return teamList;
    }
    public static Teams getItem(int selectedPos) {
        return teamList.get(selectedPos);
    }
}
