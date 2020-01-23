package model.ObjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

import classesJava.ArbitreDeChaise;
import classesJava.EquipeJoueur;
import classesJava.Joueur;
import java.util.ArrayList;
import model.interfaces.InterfaceArbitreDeChaiseDAO;

public class ArbitreDeChaiseDAO implements InterfaceArbitreDeChaiseDAO {

    private final Connection connexionBD;

    public ArbitreDeChaiseDAO(Connection c) {
        this.connexionBD = c;
    }

    public ArbitreDeChaise findbyId(int idArbitre) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rset;
        ArbitreDeChaise a = null;
        try {
            pst = connexionBD.prepareStatement("SELECT idArbitreC, nom, prenom, nationalite, categorie, nbMatchSimple, nbMatchDouble FROM ArbitreDeChaise join Arbitre on idArbitreC=idArbitre WHERE idArbitreC = ?");
            pst.setInt(1, idArbitre);
            rset = pst.executeQuery();
            if (rset.next()) {
                a = new ArbitreDeChaise (rset.getInt(1), rset.getString(2), rset.getString(3) ,rset.getString(4), rset.getString(5), rset.getInt(6),rset.getInt(7));
            }
            else
            {
                throw new SQLException ("Contact " + idArbitre + " inconnu");
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
    public int create (ArbitreDeChaise a) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("INSERT INTO ArbitreDeChaise VALUES (?,?,?)");
            pst.setInt(1, a.getIdArbitre());
            pst.setInt(2, a.getNbMatchSimple());
            pst.setInt(3, a.getNbMatchDouble());
            rowCount += pst.executeUpdate();
            pst = connexionBD.prepareStatement("INSERT INTO Arbitre VALUES (?,?,?,?,?)");
            pst.setInt(1, a.getIdArbitre());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getPrenom());
            pst.setString(4, a.getNationalite());
            pst.setString(5, a.getCategorie());
            rowCount += pst.executeUpdate();

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
    public List<ArbitreDeChaise> findAll() throws SQLException {
        Statement st = connexionBD.createStatement();
        ArrayList<ArbitreDeChaise> lesArbitre = new ArrayList<ArbitreDeChaise>();
        try{
            ResultSet rs = st.executeQuery("SELECT idArbitreC, nom, prenom, nationalite, categorie, nbMatchSimple, nbMatchDouble FROM ArbitreDeChaise join Arbitre on idArbitreC=idArbitre");
            int no;
            String nom;
            String pre;
            String nat;
            String cat;
            int maS, maD;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                nat = rs.getString(4);
                cat = rs.getString(5);
                maS = rs.getInt(6);
                maD = rs.getInt(7);
                ArbitreDeChaise a = new ArbitreDeChaise(no, nom, pre, nat, cat, maS, maD);
                lesArbitre.add(a);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesArbitre;

    }

    public int delete(ArbitreDeChaise a) throws SQLException {
        PreparedStatement pst = null;
        int rowCount;
        try{
            pst = connexionBD.prepareStatement("delete from ArbitreDeChaise WHERE idArbitreC=?");
            pst.setInt(1, a.getIdArbitre());
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


    public int update (ArbitreDeChaise a) throws SQLException {
        int rowCount = 0;
        PreparedStatement pst = null;
        try {
            pst = connexionBD.prepareStatement("UPDATE ArbitreDeChaise SET nbMatchSimple=?, nbMatchDouble=? WHERE idArbitreC=?");
            pst.setInt(1, a.getNbMatchSimple());
            pst.setInt(2, a.getNbMatchDouble());
            rowCount += pst.executeUpdate();
            
            pst = connexionBD.prepareStatement("UPDATE Arbitre SET nom=?, prenom=?, nationalite=?, categorie=? WHERE idArbitre=?");
            pst.setString(1, a.getPrenom());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getNationalite());
            pst.setString(4, a.getCategorie());
            pst.setInt(5, a.getIdArbitre());
            rowCount += pst.executeUpdate();
            
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
    public List<ArbitreDeChaise> findArbitresLibresNationaliteMS(Joueur j1, Joueur j2) throws SQLException {
        PreparedStatement pst = null;
        ArrayList<ArbitreDeChaise> lesArbitre = new ArrayList<ArbitreDeChaise>();
        try{
            pst = connexionBD.prepareStatement("SELECT idArbitreC, nom, prenom, nationalite, categorie, nbMatchSimple, nbMatchDouble FROM ArbitreDeChaise join Arbitre on idArbitreC=idArbitre where nationalite not in (?,?) and nbMatchSimple<2");
            pst.setString(1, j1.getNationaliteJ());
            pst.setString(2, j2.getNationaliteJ());
            ResultSet rs = pst.executeQuery();
            int no;
            String nom;
            String pre;
            String nat;
            String cat;
            int maS, maD;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                nat = rs.getString(4);
                cat = rs.getString(5);
                maS = rs.getInt(6);
                maD = rs.getInt(7);
                ArbitreDeChaise a = new ArbitreDeChaise(no, nom, pre, nat, cat, maS, maD);
                lesArbitre.add(a);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesArbitre;
    }

    @Override
    public List<ArbitreDeChaise> findArbitresLibresNationaliteMD(EquipeJoueur e1, EquipeJoueur e2) throws SQLException {
        PreparedStatement pst = null;
        ArrayList<ArbitreDeChaise> lesArbitre = new ArrayList<ArbitreDeChaise>();
        try{
            pst = connexionBD.prepareStatement("SELECT idArbitreC, nom, prenom, nationalite, categorie, nbMatchSimple, nbMatchDouble FROM ArbitreDeChaise join Arbitre on idArbitreC=idArbitre where nationalite not in (?,?,?,?) and nbMatchDouble<2");
            ArrayList<Joueur> lesJoueursE1 = e1.getLesJoueurs();
            pst.setString(1, lesJoueursE1.get(0).getNationaliteJ());
            pst.setString(2, lesJoueursE1.get(0).getNationaliteJ());
            ArrayList<Joueur> lesJoueursE2 = e1.getLesJoueurs();
            pst.setString(3, lesJoueursE2.get(0).getNationaliteJ());
            pst.setString(4, lesJoueursE2.get(0).getNationaliteJ());
            ResultSet rs = pst.executeQuery();
            int no;
            String nom;
            String pre;
            String nat;
            String cat;
            int maS, maD;
            while (rs.next()){
                no = rs.getInt(1);
                nom = rs.getString(2);
                pre = rs.getString(3);
                nat = rs.getString(4);
                cat = rs.getString(5);
                maS = rs.getInt(6);
                maD = rs.getInt(7);
                ArbitreDeChaise a = new ArbitreDeChaise(no, nom, pre, nat, cat, maS, maD);
                lesArbitre.add(a);
            }
        }catch (SQLException exc) {
            throw exc;
        }
        return lesArbitre;
    }


}
