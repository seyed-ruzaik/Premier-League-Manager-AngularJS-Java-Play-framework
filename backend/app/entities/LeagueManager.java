package entities;
import java.io.IOException;
import java.util.List;

//Interface
public interface LeagueManager {


    //add method for creating a new club
    public void addNewClub(FootballClub football,String clubName, String location, int wins, int draws, int defeats,
                           int numOfGoalsReceived, int numOfGoalsScored, int numOfPoints,
                           int numOfMatches, int numOfSeasons);

    //delete method
    public boolean deleteClub(String name);

    //show club stats
    public void showClubStats(String name);


    //show current standings in league table
    public void displayLeagueTable();


    //serialize club
    public void serializeClub();
    //deserialize club
    public void deserializeClub() throws IOException, ClassNotFoundException;


    //method for updating the scores from a played match in a league
    public void addPlayedMatch(String name1, int score1, String name2, int score2, String datePlayed);


}

