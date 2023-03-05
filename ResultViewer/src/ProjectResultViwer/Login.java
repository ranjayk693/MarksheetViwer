package ProjectResultViwer;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

final class LoginFrame extends JFrame {

    LoginFrame() {
        FrameCreator();
    }

    LoginFrame(String s) {
        super(s);
        FrameCreator();
    }

    public void setScrren() {
        setLayout(null);
        setVisible(true);
        setSize(500, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void FrameCreator() {
        //defineing the compunent
        JLabel L_clgName, L_id, L_psd;
        JTextField T_id;
        JPasswordField P_Psd;

        JButton B_Login, B_ForgetPassword;

        //allocation of memmory to compunents
        L_clgName = new JLabel("Rjay Technology of college");
        L_id = new JLabel("USER ID");
        L_psd = new JLabel("PASSWORD");
        T_id = new JTextField();
        P_Psd = new JPasswordField();
        B_Login = new JButton("Login");
        B_ForgetPassword = new JButton("Forgot Password");

        //set the dimension  x  y    width  height
        L_clgName.setBounds(150, 29, 330, 66);
        L_id.setBounds(50, 152, 70, 15);
        T_id.setBounds(135, 146, 256, 27);
        L_psd.setBounds(50, 213, 70, 15);
        P_Psd.setBounds(135, 206, 256, 27);
        B_ForgetPassword.setBounds(90, 280, 130, 30);
        B_Login.setBounds(250, 280, 130, 30);

        //adding the element
        add(L_clgName);
        add(L_id);
        add(L_psd);
        add(T_id);
        add(P_Psd);
        add(B_Login);
        add(B_ForgetPassword);

        //event handling 
        B_Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idx = T_id.getText();
                char[] psd = P_Psd.getPassword();
                String temp = new String(psd);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rjayuniversity", "root", "");
                    Statement stmt = con.createStatement();
                    String sql = "select * from employee_id,studentdetails where (employee_id.id='" + idx + "' AND employee_id.passwordfield='" + temp + "') OR (studentdetails.Enrollment_no='"+idx+"' AND studentdetails.passwordfield='" + temp + "' ) ";
                    ResultSet rs = stmt.executeQuery(sql);
                    
                    if (idx.length() == 3) {
                        if (rs.next()) {
                            new TPotalFrame(idx,rs.getString("Name")).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "invalid credential, please try again later", "authentication", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    if(idx.length()==11)
                    {
                        if(rs.next())
                                new Student(idx).setVisible(true);
                        else
                            JOptionPane.showMessageDialog(null, "invalid credential, please try again later", "authentication", JOptionPane.WARNING_MESSAGE);    
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Server id down", "conncetion failed", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        B_ForgetPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                new ToolCreater();
            JOptionPane.showMessageDialog(null, "under constructor", "", JOptionPane.WARNING_MESSAGE);
//                dispose();
            }
        });

        //calling the frame
        setScrren();

    }
}

public class Login {

    public static void main(String[] args) {
        LoginFrame b = new LoginFrame("Rjay University login");
    }

}
