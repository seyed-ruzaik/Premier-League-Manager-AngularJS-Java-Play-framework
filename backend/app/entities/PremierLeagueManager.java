package entities;
import controllers.HomeController;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.*;


public class PremierLeagueManager implements LeagueManager {

    //ArrayLists
   public static List<FootballClub> fClub = new ArrayList<FootballClub>();
   public static List<String> names = new ArrayList<String>();
   public static List<String> exist = new ArrayList<String>();
   public static List<Integer> played = new ArrayList<Integer>();


    //add-method for footballClubs
    @Override
    public void addNewClub(FootballClub football,String clubName, String location, int wins, int draws, int defeats,
                           int numOfGoalsReceived, int numOfGoalsScored, int numOfPoints,
                           int numOfMatches, int numOfSeasons){

        football = new FootballClub(clubName,location,wins,draws,defeats,numOfGoalsReceived,numOfGoalsScored,numOfPoints,
                numOfMatches,numOfSeasons);
        //add all the info to fClub arrayList
        fClub.add(football);
        serializeClub();

    }

    //delete method for football club
    @Override
    public boolean deleteClub(String name) {
        for (int ij = 0; ij < fClub.size(); ij++) {
            if (fClub.get(ij).getClubName().equals(name)) {
                fClub.remove(ij);
                names.remove(name);
                exist.remove(name);
                MainApplication.teamNames.remove(name);
                System.out.println("");
                System.out.println("-------------------------------------");
                System.out.println("|Club:"+name.toUpperCase()+ "| Deleted Successfully!");
                System.out.println("-------------------------------------");
                System.out.println("");
                serializeClub();
                return true;
            }
        }

        //if club not found display an error message
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("Club not found!. Please try again.");
        System.out.println("----------------------------------");
        System.out.println("");
        return false;


    }
    //show club statistics method for football clubs
    @Override
    public void showClubStats(String name) {
        //add to names arrayList
        for (int ij = 0; ij < fClub.size(); ij++) {
            if (!names.contains(fClub.get(ij).getClubName())) {
                names.add(fClub.get(ij).getClubName());
            }

        }


        //football club
        for (FootballClub club : fClub) {
            //using string format method to display in a table format
            if (club.getClubName().equals(name)) {
                System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-16s%-15s%n", "_________", "__________", "__________",
                        "__________",
                        "__________", "__________", "__________", "__________",
                        "__________", "______________", " __________");

                System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-16s%-15s%n", "Club-Name", "Location", "Wins", "Draws",
                        "Defeats", "GR", "GS", "Points",
                        "Matches", "Seasons-Played", " GD");
                System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-16s%-15s%n", "_________", "__________", "__________",
                        "__________",
                        "__________", "__________", "__________", "__________",
                        "__________", "______________", " __________");

                System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-17s%-14d%n", club.getClubName(),
                        club.getLocation(),
                        club.getWins(), club.getDraws(), club.getDefeats(), club.getNumOfGoalsReceived(),
                        club.getNumOfGoalsScored(), club.getNumOfPoints(), club.getNumOfMatches(),
                        club.getNumOfSeasons(), club.getDiff());


            }
        }
        //football club not available

        if (!names.contains(name)) {
            System.out.println("");
            System.out.println("-------------------");
            System.out.println("Club not available!");
            System.out.println("-------------------");
            System.out.println("");

        }


    }


    //method for displaying premier league table
    @Override
    public void displayLeagueTable() {

        //sort them according to GD
        fClub.sort(new Comparator<FootballClub>() {

            public int compare(FootballClub footballClub, FootballClub footballClub2) {
                return footballClub.getDiff() - footballClub2.getDiff();
            }
        });  //sort them according to points
        fClub.sort(new Comparator<FootballClub>() {

            public int compare(FootballClub footballClub3, FootballClub footballClub4) {
                return footballClub3.getNumOfPoints() - footballClub4.getNumOfPoints();
            }
        });
        //string format method to display the table
        System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-16s%-13s%-15s%n", "_________", "__________", "__________",
                "__________",
                "__________","__________","__________","__________",
                "__________","______________"," __________"," __________");

        System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-16s%-13s%-15s%n", "Club-Name", "Location", "Wins","Draws",
                "Defeats","GR","GS","Points",
                "Matches","Seasons-Played"," GD"," Position");
        System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-16s%-13s%-15s%n", "_________", "__________", "__________",
                "__________",
                "__________","__________","__________","__________",
                "__________","______________"," __________"," __________");
        int position = 0;
        for (int ij = fClub.size(); ij > 0; ij--) {
            position++;
            System.out.printf("%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-13s%-17s%-17s%-14d%n", fClub.get(ij-1).getClubName(),
                    fClub.get(ij-1).getLocation(),
                    fClub.get(ij-1).getWins(),fClub.get(ij-1).getDraws(),fClub.get(ij-1).getDefeats(),fClub.get(ij-1).getNumOfGoalsReceived(),
                    fClub.get(ij-1).getNumOfGoalsScored(),fClub.get(ij-1).getNumOfPoints(),fClub.get(ij-1).getNumOfMatches(),
                    fClub.get(ij-1).getNumOfSeasons(),fClub.get(ij-1).getDiff(),position);

        }
    }

    //save all the information in a file
    @Override
    public void serializeClub() {
        try {
            //save all the information in a .ser file
            FileOutputStream stream = new FileOutputStream("Football.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(stream);

            objOut.writeObject(fClub);

            objOut.close();
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //load all the information in the file to the data structure
    @Override
    @SuppressWarnings("unchecked")
    public void deserializeClub() throws IOException, ClassNotFoundException {
        try {
            ArrayList<FootballClub> deSerialized = new ArrayList<FootballClub>();
            //from the file football.ser load the all the data to the data structure
            FileInputStream myFile = new FileInputStream("Football.ser");
            ObjectInputStream input = new ObjectInputStream(myFile);


            deSerialized = (ArrayList<FootballClub>) input.readObject();

            fClub.addAll(deSerialized);

        }catch (FileNotFoundException ignored){}

    }

    //add a played match between two teams and update their scores and get the dates
    @Override
    public void addPlayedMatch(String name1, int score1, String name2, int score2, String datePlayed) {
        //add to names arrayList
        for (int ik = 0; ik < fClub.size();ik++){
            if(!names.contains(fClub.get(ik).getClubName())) {
                names.add(fClub.get(ik).getClubName());
            }

        }
        //Dates
        SimpleDateFormat matchDate = new SimpleDateFormat("yyyy-MM-dd");
        Date resultDate = null;
        try {
            //Parsing the String
            matchDate.setLenient(false);
            resultDate = matchDate.parse(datePlayed);


        } catch (DateTimeParseException | ParseException ex) {
            System.out.println("");

        }

        //check if the names are stored in the data structure and check if date entered is a valid one
        if(names.contains(name1) && names.contains(name2) && resultDate != null) {
            for(int ij =0 ; ij<fClub.size();ij++){
                played.add(score1);
                played.add(score2);
                if(score1 > score2 && fClub.get(ij).getClubName().equals(name1)){
                    fClub.get(ij).setWins(fClub.get(ij).getWins()+1);
                    fClub.get(ij).setNumOfMatches(fClub.get(ij).getNumOfMatches()+1);
                    fClub.get(ij).setNumOfGoalsScored(fClub.get(ij).getNumOfGoalsScored()+score1);
                    fClub.get(ij).setNumOfPoints(fClub.get(ij).getNumOfPoints()+3);
                    fClub.get(ij).setNumOfGoalsReceived(fClub.get(ij).getNumOfGoalsReceived()+score2);
                } if(score1 > score2 && fClub.get(ij).getClubName().equals(name2)){
                    fClub.get(ij).setDefeats(fClub.get(ij).getDefeats()+1);
                    fClub.get(ij).setNumOfMatches(fClub.get(ij).getNumOfMatches()+1);
                    fClub.get(ij).setNumOfGoalsScored(fClub.get(ij).getNumOfGoalsScored()+score2);
                    fClub.get(ij).setNumOfGoalsReceived(fClub.get(ij).getNumOfGoalsReceived()+score1);

                } if(score2 > score1 && fClub.get(ij).getClubName().equals(name1)){
                    fClub.get(ij).setDefeats(fClub.get(ij).getDefeats()+1);
                    fClub.get(ij).setNumOfMatches(fClub.get(ij).getNumOfMatches()+1);
                    fClub.get(ij).setNumOfGoalsScored(fClub.get(ij).getNumOfGoalsScored()+score1);
                    fClub.get(ij).setNumOfGoalsReceived(fClub.get(ij).getNumOfGoalsReceived()+score2);

                } if (score2 > score1 && fClub.get(ij).getClubName().equals(name2)){
                    fClub.get(ij).setWins(fClub.get(ij).getWins()+1);
                    fClub.get(ij).setNumOfMatches(fClub.get(ij).getNumOfMatches()+1);
                    fClub.get(ij).setNumOfGoalsScored(fClub.get(ij).getNumOfGoalsScored()+score2);
                    fClub.get(ij).setNumOfGoalsReceived(fClub.get(ij).getNumOfGoalsReceived()+score1);
                    fClub.get(ij).setNumOfPoints(fClub.get(ij).getNumOfPoints()+3);

                } if( score1 == score2 && fClub.get(ij).getClubName().equals(name1)){
                    fClub.get(ij).setDraws(fClub.get(ij).getDraws()+1);
                    fClub.get(ij).setNumOfMatches(fClub.get(ij).getNumOfMatches()+1);
                    fClub.get(ij).setNumOfPoints(fClub.get(ij).getNumOfPoints()+1);
                    fClub.get(ij).setNumOfGoalsScored(fClub.get(ij).getNumOfGoalsScored()+score1);
                    fClub.get(ij).setNumOfGoalsReceived(fClub.get(ij).getNumOfGoalsReceived()+score2);

                } if (score2 == score1 && fClub.get(ij).getClubName().equals(name2)){

                    fClub.get(ij).setDraws(fClub.get(ij).getDraws()+1);
                    fClub.get(ij).setNumOfMatches(fClub.get(ij).getNumOfMatches()+1);
                    fClub.get(ij).setNumOfPoints(fClub.get(ij).getNumOfPoints()+1);
                    fClub.get(ij).setNumOfGoalsScored(fClub.get(ij).getNumOfGoalsScored()+score2);
                    fClub.get(ij).setNumOfGoalsReceived(fClub.get(ij).getNumOfGoalsReceived()+score1);

                }
                //display a message when scores are updated

            } serializeClub();
        }else {
            //if user enters wrong information display an error message
            System.out.println("-------------------------------------------");
            System.out.println("Error Can't Update Score. Please Try Again!");
            System.out.println("-------------------------------------------");
        }



    }



}


