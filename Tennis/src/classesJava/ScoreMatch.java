/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesJava;

/**
 *
 * @author angel
 */
public class ScoreMatch {
    
    private int idMatch;
    
    /**
     * Les lignes de scoreMatch correspondent aux différentes manches, la premiere colonne le score du joueur ou de l'equipe 1, la deuxième celle de l'autre
     */
    private int[][] scoreMatch;

    public ScoreMatch(int idMatch, int[][] scoreMatch) {
        this.idMatch = idMatch;
        this.scoreMatch = scoreMatch;
    }

    public ScoreMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int[][] getScoreMatch() {
        return scoreMatch;
    }

    public void setScoreMatch(int[][] scoreMatch) {
        this.scoreMatch = scoreMatch;
    }
    
    public int getGagnant(){
        int num1 = 0;
        int num2 = 0;
        int numGagnant = 0;
        
        for(int i = 0; i<scoreMatch.length; i++){
            if (scoreMatch[i][0] > scoreMatch[i][1])num1++;
            else if (scoreMatch[i][0] > scoreMatch[i][1]) num2++;
        }
        
        if (num1>num2) numGagnant = 0;
        if (num1<num2) numGagnant = 1;
        
        return numGagnant;
    }
    
    public String getScoreJ1(){
        String score = "|";
            for(int i=0; i<this.scoreMatch.length; i++) score += scoreMatch[i][0] + "|";
        return score;
    }
    
    public String getScoreJ2(){
    String score = "|";
        for(int i=0; i<this.scoreMatch.length; i++) score += scoreMatch[i][1] + "|";
    return score;
}
    
}
