package service;
import entities.*;

import java.util.*;

public class clubService {
    private static clubService instance;
    private List<FootballClub> myClub = new ArrayList<>();
    public static clubService getInstance() {
        if (instance == null) {
            instance = new clubService();
        }
        return instance;
    }

    public List<FootballClub> getAll() {
        for (int i = 0 ; i < PremierLeagueManager.fClub.size();i++) {
            if (!myClub.contains(PremierLeagueManager.fClub.get(i))) {
                myClub.add(PremierLeagueManager.fClub.get(i));
            }
        }
        return myClub;

    }





}
