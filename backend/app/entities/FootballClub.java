package entities;
import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable {
    //instance Variables
    private int wins;
    private int draws;
    private int defeats;
    private int numOfGoalsReceived;
    private int numOfGoalsScored;
    private int numOfPoints;
    private int numOfMatches;
    private int numOfSeasons;


    //default constructor
    public FootballClub(){

    }


    //args-constructor
    public FootballClub(String clubName, String location, int wins, int draws, int defeats, int numOfGoalsReceived,
                        int numOfGoalsScored, int numOfPoints, int numOfMatches, int numOfSeasons) {
        super(clubName, location);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.numOfGoalsReceived = numOfGoalsReceived;
        this.numOfGoalsScored = numOfGoalsScored;
        this.numOfPoints = numOfPoints;
        this.numOfMatches = numOfMatches;
        this.numOfSeasons = numOfSeasons;
    }

    //getters and setters
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getNumOfGoalsReceived() {
        return numOfGoalsReceived;
    }

    public void setNumOfGoalsReceived(int numOfGoalsReceived) {
        this.numOfGoalsReceived = numOfGoalsReceived;
    }

    public int getNumOfGoalsScored() {
        return numOfGoalsScored;
    }

    public void setNumOfGoalsScored(int numOfGoalsScored) {
        this.numOfGoalsScored = numOfGoalsScored;
    }

    public int getNumOfPoints() {
        return numOfPoints;
    }

    public void setNumOfPoints(int numOfPoints) {
        this.numOfPoints = numOfPoints;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }

    public void setNumOfMatches(int numOfMatches) {
        this.numOfMatches = numOfMatches;
    }

    public int getNumOfSeasons() {
        return numOfSeasons;
    }

    public void setNumOfSeasons(int numOfSeasons) {
        this.numOfSeasons = numOfSeasons;
    }

    public int getDiff() {
        return numOfGoalsScored-numOfGoalsReceived;
    }

    //toString Method
    @Override
    public String toString() {
        return  "FootballClub{" + "ClubName='" + getClubName() + '\'' +
                ", location='" + getLocation() + '\''+
                ", wins=" + wins +
                ", draws=" + draws +
                ", defeats=" + defeats +
                ", NumOfGoalsReceived=" + numOfGoalsReceived +
                ", NumOfGoalsScored=" + numOfGoalsScored +
                ", NumOfPoints=" + numOfPoints +
                ", NumOfMatches=" + numOfMatches +
                ", NumOfSeasons=" + numOfSeasons+", GD=" +(numOfGoalsScored-numOfGoalsReceived)+"}"
                ;
    }

    //equals and hashcode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return wins == that.wins &&
                draws == that.draws &&
                defeats == that.defeats &&
                numOfGoalsReceived == that.numOfGoalsReceived &&
                numOfGoalsScored == that.numOfGoalsScored &&
                numOfPoints == that.numOfPoints &&
                numOfMatches == that.numOfMatches &&
                numOfSeasons == that.numOfSeasons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wins, draws, defeats, numOfGoalsReceived, numOfGoalsScored, numOfPoints,
                numOfMatches, numOfSeasons);
    }
}
