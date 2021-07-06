package entities;
import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {
    //instance variables
    private String clubName;
    private String location;

    //default constructor
    public SportsClub(){

    }

    //args-constructor
    public SportsClub(String clubName, String location) {
        this.clubName = clubName;
        this.location = location;
    }
    //getters and setters
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    //toString Method
    @Override
    public String toString() {
        return "SportsClub{" +
                "clubName='" + clubName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    //equals and hashcode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return Objects.equals(clubName, that.clubName) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, location);
    }
}

