/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ObjectDAO;

import classesJava.ArbitreDeLigne;
import classesJava.EquipeArbitreDeLigne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.interfaces.InterfaceEquipeArbitreDeLigne;

/**
 *
 * @author angel
 */
public class EquipeArbitreDeLigneDAO implements InterfaceEquipeArbitreDeLigne{

    private final Connection connexionBD;

    public EquipeArbitreDeLigneDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public EquipeArbitreDeLigne findById(int idEquipe) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        EquipeArbitreDeLigne equipe = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM EquipeArbitreDeLigne_ArbitreDeLigne WHERE idEquipeArbitreDeLigne=?");
            pst.setInt(1, idEquipe);
            rset = pst.executeQuery();
            ArbitreDeLigneDAO ALDAO = new ArbitreDeLigneDAO(connexionBD);
            ArrayList<ArbitreDeLigne> lesArbitres = new ArrayList<>();
            while (rset.next()) {
                ArbitreDeLigne al = ALDAO.findbyId(rset.getInt(2));
                lesArbitres.add(al);
            }
            equipe = new EquipeArbitreDeLigne(idEquipe, lesArbitres);
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
    public ArrayList<EquipeArbitreDeLigne> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<EquipeArbitreDeLigne> lesEquipe = new ArrayList<EquipeArbitreDeLigne>();
        EquipeArbitreDeLigne equipe = null;
        try{
            ResultSet rs = st.executeQuery("SELECT * from EquipeArbitreDeLigne");
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
