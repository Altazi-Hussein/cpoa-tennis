/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ObjectDAO;

import classesJava.ArbitreDeLigne;
import classesJava.EquipeRamasseur;
import classesJava.RamasseurDeBalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.interfaces.InterfaceEquipeRamasseurDAO;
/**
 *
 * @author p1806052
 */
public class EquipeRamasseurDAO implements InterfaceEquipeRamasseurDAO{
    private final Connection connexionBD;

    public EquipeRamasseurDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public EquipeRamasseur findById(int idEquipe) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        EquipeRamasseur equipe = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM RamasseurDeBalle WHERE idEquipeR=?");
            pst.setInt(1, idEquipe);
            rset = pst.executeQuery();
            RamasseurDeBalleDAO RDAO = new RamasseurDeBalleDAO(connexionBD);
            ArrayList<RamasseurDeBalle> lesRamasseurs = new ArrayList<>();
            while (rset.next()) {
                RamasseurDeBalle r = RDAO.findbyId(rset.getInt(2));
                lesRamasseurs.add(r);
            }
            equipe = new EquipeRamasseur(idEquipe, lesRamasseurs);
        } catch (SQLException exc) {
            throw exc;
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException exc) {
                throw exc;
            }
        }
        return equipe;
    }

    @Override
    public ArrayList<EquipeRamasseur> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<EquipeRamasseur> lesEquipe = new ArrayList<EquipeRamasseur>();
        EquipeRamasseur equipe = null;
        try{
            ResultSet rs = st.executeQuery("SELECT distinct idEquipeR from EquipeRamasseur");
            int no;
            while (rs.next()){
                no = rs.getInt(1);
                equipe = this.findById(no);
                lesEquipe.add(equipe);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesEquipe;

    }
}
