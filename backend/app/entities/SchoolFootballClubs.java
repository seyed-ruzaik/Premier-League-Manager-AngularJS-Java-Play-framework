package entities;
import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClubs extends FootballClub implements Serializable {

    //instance variables
    private String schoolName;

    //default constructor
    public SchoolFootballClubs (){

    }

    //args-constructor

    public SchoolFootballClubs(String clubName, String location, int wins, int draws, int defeats, int numOfGoalsReceived,
                               int numOfGoalsScored, int numOfPoints, int numOfMatches, int numOfSeasons, String schoolName) {
        super(clubName, location, wins, draws, defeats, numOfGoalsReceived, numOfGoalsScored, numOfPoints, numOfMatches,
                numOfSeasons);
        this.schoolName = schoolName;
    }

    //getters and setters


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSchoolDiff() {
        return getNumOfGoalsScored()-getNumOfGoalsReceived();
    }


    //toString Method
    @Override
    public String toString() {
        return "SchoolFootballClubs{" + "SchoolName= " + schoolName + ", ClubName='" + getClubName() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", wins=" + getWins() +
                ", draws=" + getDraws() +
                ", defeats=" + getDefeats() +
                ", NumOfGoalsReceived=" + getNumOfGoalsReceived() +
                ", NumOfGoalsScored=" + getNumOfGoalsScored() +
                ", NumOfPoints=" + getNumOfPoints() +
                ", NumOfMatches=" + getNumOfMatches() +
                ", NumOfSeasons=" + getNumOfSeasons()+", GD=" +(getNumOfGoalsScored()-getNumOfGoalsReceived())+"}" ;

    }

    //equals and hashcode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClubs that = (SchoolFootballClubs) o;
        return Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName);
    }
}
