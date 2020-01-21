package tennis;


import java.awt.Frame;
import java.net.PasswordAuthentication;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class JDAuthentificationBD extends javax.swing.JDialog {
    
    private JButton jButtonOK;
    private JLabel lblUser;
    private JLabel lblPwd;
    private JPasswordField tfPwd;
    private JTextField tfUser;


    /**
    * Creates new form JDAuthentificationBD
    */
    public JDAuthentificationBD (Frame parent) {
        super(parent, "Identification BD", true);
        initComponents();
    }

    JDAuthentificationBD() {
        initComponents();
    }
    
    private void initComponents() {
        jButtonOK = new JButton("S'authentifier");
        jButtonOK.addActionListener(e ->  this.dispose() );
        lblUser = new JLabel("Utilisateur: ");
        lblPwd =  new JLabel("Mot de passe: ");
        tfPwd = new JPasswordField("Mot de passe");
        tfUser = new JTextField("Utilisateur");
        setVisible(true);
    }

    public PasswordAuthentication recuperer() {
        setVisible(true);
        return new PasswordAuthentication( tfUser.getText(), tfPwd.getPassword());
    }
    
    private void Quitter(WindowEvent evt) {
        System.exit(0);
    }
}