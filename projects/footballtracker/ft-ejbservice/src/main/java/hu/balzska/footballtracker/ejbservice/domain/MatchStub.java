package hu.balzska.footballtracker.ejbservice.domain;

import java.util.Random;

public class MatchStub {

    private int matchId;
    private String team1;
    private String team2;
    private int team1Score;
    private int team2Score;
    private boolean isFinished;

    public MatchStub() {
        this(0, null, null);
    }

    public MatchStub(int matchId, String team1, String team2) {
        super();
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.isFinished = false;
        this.team1Score = 0;
        this.team2Score = 0;
    }
    
    public void setRandomScore(){
    	Random r = new Random();
    	this.team1Score = r.nextInt(5);
    	this.team2Score = r.nextInt(5);
    }

    public String getTeam1(){
    	return this.team1;
    }
    
    public String getTeam2(){
    	return this.team2;
    }
    
    public int getTeam1Score(){
    	return this.team1Score;
    }
    
    public int getTeam2Score(){
    	return this.team2Score;
    }
    
    public boolean getIsFinished(){
    	return this.isFinished;
    }
    
    public String getScore(){
    	return team1Score + " - " + team2Score;
    }
    
    @Override
    public String toString() {
        return team1 + " " + team1Score + " - " + team2Score + " " + team2;
    }

}
