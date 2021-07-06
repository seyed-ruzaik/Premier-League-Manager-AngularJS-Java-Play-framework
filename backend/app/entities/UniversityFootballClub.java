package entities;
import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {

//instance variables
    private String universityName;

    //default constructor
    public UniversityFootballClub(){

    }
    //args-constructor
    public UniversityFootballClub(String clubName, String location, int wins, int draws, int defeats, int numOfGoalsReceived,
                                  int numOfGoalsScored, int numOfPoints, int numOfMatches,
                                  int numOfSeasons, String universityName) {
        super(clubName, location, wins, draws, defeats, numOfGoalsReceived, numOfGoalsScored, numOfPoints, numOfMatches,
                numOfSeasons);
        this.universityName = universityName;
    }
//getters and setters
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public int getUniDiff() {
        return getNumOfGoalsScored()-getNumOfGoalsReceived();
    }

//toString Method
    @Override
public String toString() {
    return "UniversityFootballClub{" +"UniversityName= "+ universityName + ", ClubName='" + getClubName()
            + '\'' +
            ", location='" + getLocation() + '\''+
            ", wins=" + getWins() +
            ", draws=" + getDraws() +
            ", defeats=" + getDefeats() +
            ", NumOfGoalsReceived=" + getNumOfGoalsReceived()+
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
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(universityName, that.universityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), universityName);
    }
}
