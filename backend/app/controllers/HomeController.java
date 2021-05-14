package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.mvc.*;
import entities.*;
import service.*;
import entities.*;
import utills.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
     public static List<FootballClub> foot = new ArrayList<>();
    PremierLeagueManager plm = new PremierLeagueManager();

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */


    public Result index2 (){
        PremierLeagueManager.fClub.clear();

            try {
                plm.deserializeClub();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
//       load data from file
//        create new arraylist and equal it to the loaded array
//        convert new arraylist to json
//        create response;
        PremierLeagueManager.fClub.sort(new Comparator<FootballClub>() {

            public int compare(FootballClub footballClub, FootballClub footballClub2) {
                return footballClub.getDiff() - footballClub2.getDiff();
            }
        });  //sort them according to points
        PremierLeagueManager.fClub.sort(new Comparator<FootballClub>() {

            public int compare(FootballClub footballClub3, FootballClub footballClub4) {
                return footballClub3.getNumOfPoints() - footballClub4.getNumOfPoints();
            }
        });
        Collections.reverse(PremierLeagueManager.fClub);
        logger.debug("In EmployeeController.listEmployees(), result is: {}",PremierLeagueManager.fClub);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(PremierLeagueManager.fClub, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));

    }
    public Result matches(){
        MainApplication.playedMatches.clear();
        try {
            MainApplication.loadPlayedMatches();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        logger.debug("In EmployeeController.listEmployees(), result is: {}",MainApplication.playedMatches);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(MainApplication.playedMatches, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }
    public Result generateRandMatch(){
        PremierLeagueManager.fClub.clear();
        try {
            plm.deserializeClub();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        PremierLeagueManager.fClub.sort(new Comparator<FootballClub>() {

            public int compare(FootballClub footballClub, FootballClub footballClub2) {
                return footballClub.getDiff() - footballClub2.getDiff();
            }
        });  //sort them according to points
        PremierLeagueManager.fClub.sort(new Comparator<FootballClub>() {

            public int compare(FootballClub footballClub3, FootballClub footballClub4) {
                return footballClub3.getNumOfPoints() - footballClub4.getNumOfPoints();
            }
        });
        Collections.reverse(PremierLeagueManager.fClub);
        MainApplication.generatethis();
        logger.debug("In EmployeeController.listEmployees(), result is: {}",PremierLeagueManager.fClub);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(PremierLeagueManager.fClub, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));

    }


}
