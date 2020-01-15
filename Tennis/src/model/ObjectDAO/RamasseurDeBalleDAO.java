package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import classesJava.RamasseurDeBalle;
import model.interfaces.InterfaceRamasseurDeBalleDAO;


public class RamasseurDeBalleDAO implements InterfaceRamasseurDeBalleDAO {

    private final Connection connexionBD;

    public RamasseurDeBalleDAO(Connection c) {
        this.connexionBD = c;
    }

    public RamasseurDeBalle findbyId(int idRamasseur) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        RamasseurDeBalle a = null;
        try {
            pst = connexionBD.prepareStatement("SELECT * FROM RamasseurDeBalle WHERE idRamasseur=?");
            pst.setInt(1, idRamasseur);
            rset = pst.executeQuery();
            if (rset.next()) {
                a = new RamasseurDeBalle (rset.getInt(1), rset.getString(2), rset.getString(3));
            }
            else
            {
                throw new SQLException ("Contact " + idRamasseur + " inconnu");
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
        return a;
    }

    @Override
    public int create (RamasseurDeBalle r) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO RamasseurDeBalle VALUES (?,?,?)");
            pst.setInt(1, r.getIdRamasseur());
            pst.setString(2, r.getNomR());
            pst.setString(3, r.getPrenomR());
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
    public ArrayList<RamasseurDeBalle> findAll() throws SQLException {
        Statement st = connexionBD.createStatement() ;
        ArrayList<RamasseurDeBalle> lesRamasseur = new ArrayList<RamasseurDeBalle>();
        try{
            ResultSet rs = st.executeQuery("SELECT * from RamasseurDeBalle");
            int no;
            String nom;
            String pre;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                RamasseurDeBalle a = new RamasseurDeBalle(no, nom, pre);
                lesRamasseur.add(a);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesRamasseur;

    }

    public int delete(RamasseurDeBalle r) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from RamasseurDeBalle WHERE idRamasseur=?");
            pst.setInt(1, r.getIdRamasseur());
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


    public int update (RamasseurDeBalle a) throws SQLException {
        int rowCount;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE RamasseurDeBalle SET prenomR=?, nomR=? WHERE idRamasseur=?");
            pst.setString(1, a.getPrenomR());
            pst.setString(2, a.getNomR());
            pst.setInt(3, a.getIdRamasseur());
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
