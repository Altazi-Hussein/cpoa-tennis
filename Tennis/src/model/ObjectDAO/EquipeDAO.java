package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import model.interfaces.InterfaceEquipeDAO;
import classesJava.Equipe;
import classesJava.Joueur;

public class EquipeDAO implements InterfaceEquipeDAO {

    private final Connection connexionBD;

    public EquipeDAO(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public Equipe findById(int idEquipe) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        Equipe equipe = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM Equipe WHERE idEquipe=?");
            pst.setInt(1, idEquipe);
            rset = pst.executeQuery();
            if (rset.next()) {
                JoueurDAO joueurDAO = new JoueurDAO(connexionBD);
                ArrayList<Joueur> joueurs = new ArrayList<>();
                Joueur j1 = joueurDAO.findById(rset.getInt(2));
                Joueur j2 = joueurDAO.findById(rset.getInt(3));
                joueurs.add(j1);
                joueurs.add(j2);
                equipe = new Equipe(rset.getInt(1), joueurs);
            }
            else
            {
                throw new SQLException ("Contact " + idEquipe + " inconnu");
            }

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
    public int create (Equipe equipe) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO Equipe VALUES (?,?,?)");
            pst.setInt(1, equipe.getIdEquipe());
            ArrayList<Joueur> joueurs = equipe.getLesJoueurs();
            pst.setInt(2, joueurs.get(0).getIdJoueur());
            pst.setInt(3, joueurs.get(0).getIdJoueur());
            rowCount = pst.executeUpdate();

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Code d'erreur : "+ exc.getErrorCode() +"\nMessage d'erreur : "+ exc.getMessage());
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
        return rowCount;
    }

    @Override
    public ArrayList<Equipe> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<Equipe> lesEquipe = new ArrayList<Equipe>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from Equipe");
            int no;
            Joueur j1, j2;
            while (rs.next()){
                no = rs.getInt(1);
                ArrayList<Joueur> joueurs = null;
                JoueurDAO joueurDao = new JoueurDAO(connexionBD);
                j1 = joueurDao.findById(rs.getInt(2));
                j2 = joueurDao.findById(rs.getInt(3));
                joueurs.add(j1);
                joueurs.add(j2);
                Equipe equipe = new Equipe(no,joueurs);
                lesEquipe.add(equipe);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesEquipe;

    }


    public int delete(Equipe equipe) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from Equipe WHERE idEquipe=?");
            pst.setInt(1, equipe.getIdEquipe());
            rowCount = pst.executeUpdate();
        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Code d'erreur : "+ exc.getErrorCode() +"\nMessage d'erreur : "+ exc.getMessage());
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
        return rowCount;
    }


    public int update (Equipe equipe) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE Equipe SET idJoueur1=?, idJoueur2=? WHERE idEquipe=?");
            pst.setInt(1, equipe.getIdEquipe());
            pst.setInt(2, equipe.getJoueur1().getIdJoueur());
            pst.setInt(3, equipe.getJoueur2().getIdJoueur());
            rowCount = pst.executeUpdate();

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "Code d'erreur : "+ exc.getErrorCode() +"\nMessage d'erreur : "+ exc.getMessage());
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
        return rowCount;
    }

}
