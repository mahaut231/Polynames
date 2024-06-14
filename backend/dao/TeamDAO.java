package dao;

import database.PolynamesDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Team;

public class TeamDAO {

    public TeamDAO() {
    }

    public ArrayList<Team> getAllTeam() {       //Méthode de récupération de toutes les équipes
        ArrayList<Team> teamList = new ArrayList<>();

        try {

            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "Select * from `team`;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            ResultSet resultsSQL = prepRequestSQL.executeQuery();

            while (resultsSQL.next()) {
                int teamId = resultsSQL.getInt("teamId");
                int player1 = resultsSQL.getInt("player1");
                int player2 = resultsSQL.getInt("player2");
                Team team = new Team(teamId, player1, player2);
                teamList.add(team);
            }

        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
        return (teamList);
    }

    public Team getTeam(int i) {        //Méthode de récupération d'équipe par son ID
        int player1 = 0;
        int player2 = 0;

        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();        
            String requestSQL = "Select * from `team`;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            ResultSet resultSQL = prepRequestSQL.executeQuery();

            while (resultSQL.next()) {
                player1 = resultSQL.getInt("player1");
                player2 = resultSQL.getInt("player2");
                if (resultSQL.getInt("teamId") == i) {
                    Team team = new Team(i, player1, player2);
                    return (team);
                }
            }

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return (null);
    }

    public void createTeam(int player1, int player2) {      //Méthode de création d'équipe

        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "insert into team (player1,player2) values (? , ?);";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setInt(1, player1);
            prepRequestSQL.setInt(2, player2);
            prepRequestSQL.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void deleteTeam(int ind) {   //Méthode de suppression d'une équipe par son ID

        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "delete from team where teamId == ?;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setInt(1, ind);
            prepRequestSQL.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}
