/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesJava;

import java.util.ArrayList;

/**
 *
 * @author angel
 */
public class EquipeArbitreDeLigne {
    private int idEquipe;
    private ArrayList<ArbitreDeLigne> lesArbitresDeLigne;

    public EquipeArbitreDeLigne(int idEquipe, ArrayList<ArbitreDeLigne> lesArbitresDeLignes) {
        this.idEquipe = idEquipe;
        this.lesArbitresDeLigne = lesArbitresDeLignes;
    }

    
    
    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public ArrayList<ArbitreDeLigne> getLesArbitresDeLigne() {
        return lesArbitresDeLigne;
    }

    public void setLesArbitresDeLigne(ArrayList<ArbitreDeLigne> lesArbitresDeLignes) {
        this.lesArbitresDeLigne = lesArbitresDeLignes;
    }
}
