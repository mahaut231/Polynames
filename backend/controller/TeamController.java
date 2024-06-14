package controller;

import dao.TeamDAO;
import java.util.ArrayList;
import models.Team;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class TeamController {
    public TeamController() {}  //Constructeur

    public static ArrayList<Team> getAllTeam(WebServerContext context) {    
        ArrayList<Team> teamList = new ArrayList<>();

        try {
            TeamDAO teamDAO = new TeamDAO();

            teamList = teamDAO.getAllTeam();

            WebServerResponse response = context.getResponse();
            response.json((teamList));

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return (teamList);
    }

    public static Team getTeam(WebServerContext context) {      
        try {
            TeamDAO teamDAO = new TeamDAO();
            int teamId = Integer.parseInt(context.getRequest().getParam("teamId"));

            Team team = teamDAO.getTeam(teamId);

            WebServerResponse response = context.getResponse();
            response.json((team));
            response.ok("Print team");
            return (team);
        } catch (Exception e) {
            System.out.println("Error : " + e);
            return (null);
        }

    }

    public static void createTeam(WebServerContext context) {
        try {
            TeamDAO teamDAO = new TeamDAO();
            int player1 = Integer.parseInt(context.getRequest().getParam("player1"));
            int player2 = Integer.parseInt(context.getRequest().getParam("player2"));

            teamDAO.createTeam(player1, player2);

            WebServerResponse response = context.getResponse();
            response.ok("Team created");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public static void deleteTeam(WebServerContext context) {
        try {
            TeamDAO teamDAO = new TeamDAO();
            int indTeam = Integer.parseInt(context.getRequest().getParam("indTeam"));

            teamDAO.deleteTeam(indTeam);

            WebServerResponse response = context.getResponse();
            response.ok("Team deleted");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

}
