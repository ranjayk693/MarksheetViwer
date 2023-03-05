/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectResultViwer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ranja
 */

class Student extends JFrame {
    String id;
    String name;
    String Branch;
    String sem;
    int daa;
    int ajp;
    int ip;
    int mfp;
    int tafl;
    float total;
    Student(String enr) {
        super("Details");
        id=enr;
        this.name=name;
        FrameCreator();
    }

    public void setScrren() {
        setLayout(null);
        setVisible(true);
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void detials(String id)
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rjayuniversity", "root", "");
            Statement stmt = con.createStatement();
            String sql = "select * from studentdetails,marksheet where studentdetails.Enrollment_no='"+id+"'&& marksheet.Enrollment_no='"+id+"'";
            ResultSet rs = stmt.executeQuery(sql);
//            ResultSet ps = stmt.executeQuery("select * from marksheet where Enrollment_no='"+id+"'");
            if(rs.next())
            {
                  name=rs.getString("Name");
                  Branch=rs.getString("Branch");
                  sem=rs.getString("Sem");
                  daa=rs.getInt("DAA");
                  mfp=rs.getInt("MFP");
                  ip=rs.getInt("IP");
                  ajp=rs.getInt("AJP");
                  tafl=rs.getInt("TAFL");
                  total=(daa+mfp+ip+ajp+tafl)/5;
            }
            
            
            
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Server dowm", "", JOptionPane.WARNING_MESSAGE);
            System.out.println(ex);
        }
    }
   

    public void FrameCreator() {
        
        //Calling function to fetch data
        detials(id);
        
        
        //defineing the compunent
        JLabel JEnrollment_no,Jname,Jbranch,Jsem,Jdaa,Jmfp,Jip,Jajp,Jtafl,Jtotal,Jpf;

        //allocation of memmory to compunents
        JEnrollment_no = new JLabel("Enrollment number: "+id);
        Jname = new JLabel("Name: "+name);
        Jbranch = new JLabel("Branch: "+Branch);
        Jsem = new JLabel("Semester: "+sem);
        Jdaa= new JLabel("DAA: "+daa);
        Jmfp= new JLabel("MFP: "+mfp);
        Jip= new JLabel("IP: "+ip);  
        Jajp= new JLabel("AJP: "+ajp);
        Jtafl= new JLabel("TAFL: "+tafl);
        Jtotal= new JLabel("Percentage: "+total+"%");
        if(total<33.0)
                Jpf=new JLabel("Status: Fail ");
        else
                Jpf=new JLabel("Status: pass ");
        

        //set the dimension  x  y    width  height
        JEnrollment_no.setBounds(50, 150, 300, 50)  ;
        Jname.setBounds(50, 200, 300, 50);
        Jbranch.setBounds(50, 250, 150, 50);
        Jsem.setBounds(50, 300, 150, 50);
        Jdaa.setBounds(50, 350, 150, 50);
        Jmfp.setBounds(50, 380, 150, 50);
        Jip.setBounds(50, 410, 150, 50);
        Jajp.setBounds(50, 440, 150, 50);
        Jtafl.setBounds(50, 470, 150, 50);
        Jtotal.setBounds(50, 500, 150, 50);
        Jpf.setBounds(50, 530, 150, 50);
        
        //adding desing to compunents
//        JEnrollment_no.setBackground(Color.pink);
//        id.setBackground(Color.pink);
//        Show_details.setBackground(Color.pink);
        
        

        //adding the element
        add(JEnrollment_no);
        add(Jname);
        add(Jbranch);
        add(Jsem);
        add(Jdaa);
        add(Jmfp);
        add(Jip);
        add(Jajp);
        add(Jtafl);
        add(Jtotal);
        add(Jpf);
        
        
        

        //event handling 

//        Show_details.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                //code
//                dispose();
//            }
//        });

        //calling the frame
        setScrren();

    }
}
