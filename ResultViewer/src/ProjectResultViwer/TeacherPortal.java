/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectResultViwer;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import static javax.swing.UIManager.getInt;

/**
 *
 * @author ranja
 */
class TPotalFrame extends JFrame {
    String T_id;
    String T_Name;
    TPotalFrame() {
        FrameCreator();
    }

    TPotalFrame(String id,String n) {
        super("Teacher Portal");
        T_id=id;
        T_Name=n;
        
        FrameCreator();
    }

    public void setScrren() {
        setLayout(null);
        setVisible(true);
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   

    public void FrameCreator() {
        //defineing the compunent
        JLabel Teacher_name;
        

        JButton Add_marks,Show_details;

        //allocation of memmory to compunents
        
        Teacher_name = new JLabel("welcome prof "+T_Name);
        Add_marks = new JButton("Add Marks");
        Show_details = new JButton("Show Student Details");

        //set the dimension  x  y    width  height
        Teacher_name.setBounds(190, 80, 300, 50);
        Add_marks.setBounds(150, 150, 300, 50);
        Show_details.setBounds(150, 250, 300, 50);
        
        //adding desing to compunents
        Add_marks.setBackground(Color.yellow);
        Show_details.setBackground(Color.yellow);
        

        //adding the element
        add(Teacher_name);
        add(Add_marks);
        add(Show_details);
        

        //event handling 
        Add_marks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new OperationData().setVisible(true);

            }
        });

        Show_details.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                new SearchDetails().setVisible(true);
//                dispose();
            }
        });

        //calling the frame
        setScrren();

    }
}




//class AddMarks extends JFrame {
//
//    AddMarks() {
//        FrameCreator();
//    }
//
//    AddMarks(String s) {
//        super(s);
//        FrameCreator();
//    }
//
//    public void setScrren() {
//        setLayout(null);
//        setVisible(true);
//        setSize(700, 400);
//        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        dispatchEvent(new WindowEvent(null, WindowEvent.WINDOW_CLOSING));
//    }
//
//   
//
//    public void FrameCreator() {
//        //defineing the compunent
//        JLabel Teacher_name;
//        
//
//        JButton Add_marks,Show_details;
//
//        //allocation of memmory to compunents
//        Teacher_name = new JLabel();
//        Add_marks = new JButton("Add Marks");
//        Show_details = new JButton("Show Student Details");
//
//        //set the dimension  x  y    width  height
//        Teacher_name.setBounds(250, 30, 350, 50);
//        Add_marks.setBounds(200, 160, 230, 50);
//        Show_details.setBounds(200, 250, 230, 50);
//        
//        //adding desing to compunents
//        Add_marks.setBackground(Color.yellow);
//        Show_details.setBackground(Color.yellow);
//        
//
//        //adding the element
//        add(Teacher_name);
//        add(Add_marks);
//        add(Show_details);
//        
//
//        //event handling 
//        Add_marks.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//
//            }
//        });
//
//        Show_details.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
////                new ToolCreater();
//                dispose();
//            }
//        });
//
//        //calling the frame
//        setScrren();
//
//    }
//}



class Grade extends JFrame {
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
    Grade(String enr) {
        super("Details");
        id=enr;
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
            String sql = "select * from studentdetails,marksheet where studentdetails.Enrollment_no='"+id+"' && marksheet.Enrollment_no='"+id+"'";
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









class SearchDetails extends JFrame {
    
    SearchDetails() {
        super("Student Details");
        FrameCreator();
    }

    public void setScrren() {
        setLayout(null);
        setVisible(true);
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void FrameCreator() {
        //defineing the compunent
        JLabel JEnrollment_no;
        JTextField id;
        JButton Show_details;

        //allocation of memmory to compunents
        JEnrollment_no = new JLabel("Enter Enrollment number");
        id=new JTextField();
        Show_details = new JButton("show details");

        //set the dimension  x  y    width  height
        JEnrollment_no.setBounds(50, 160, 150, 50)  ;
        id.setBounds(210, 160, 300, 50);
        Show_details.setBounds(250, 230, 150, 50);
        
        //adding desing to compunents
        JEnrollment_no.setBackground(Color.pink);
        id.setBackground(Color.pink);
        Show_details.setBackground(Color.pink);
        
        

        //adding the element
        add(JEnrollment_no);
        add(id);
        add(Show_details);
        

        //event handling 

        Show_details.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                String idx = id.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rjayuniversity", "root", "");
                    Statement stmt = con.createStatement();
                    String sql = "select * from studentdetails where Enrollment_no='"+idx+"' ";
                    ResultSet rs = stmt.executeQuery(sql);
                    if(rs.next())
                    {
                        new Grade(idx).setVisible(true);
//                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "No record found", "", JOptionPane.WARNING_MESSAGE);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Server dowm hai", "", JOptionPane.WARNING_MESSAGE);
                }
                
                
                
                
            }
        });

        //calling the frame
        setScrren();

    }
}



//deleteing and adding data
class OperationData extends JFrame {
    
    OperationData() {
        super("Student Details");
        FrameCreator();
    }

    public void setScrren() {
        setLayout(null);
        setVisible(true);
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void FrameCreator() {
        //defineing the compunent
        JLabel JEnrollment_no;
        JTextField id;
        JButton deleteData;

        //allocation of memmory to compunents
        JEnrollment_no = new JLabel("Enter Enrollment number");
        id=new JTextField();
        deleteData = new JButton("Delete data");

        //set the dimension  x  y    width  height
        JEnrollment_no.setBounds(50, 160, 150, 50)  ;
        id.setBounds(210, 160, 300, 50);
        deleteData.setBounds(250, 230, 150, 50);
        
        //adding desing to compunents
        JEnrollment_no.setBackground(Color.pink);
        id.setBackground(Color.pink);
        deleteData.setBackground(Color.pink);
        
        

        //adding the element
        add(JEnrollment_no);
        add(id);
        add(deleteData);
        

        //event handling 

        deleteData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                
                String idx = id.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rjayuniversity", "root", "");
                    Statement stmt = con.createStatement();
                    String sql = "delete from marksheet where Enrollment_no='"+idx+"' ";
                    int a=stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Record is deleted from marksheet sucessfully", "", JOptionPane.WARNING_MESSAGE);
//                    ResultSet rs = stmt.executeQuery(sql);
                      
//                    if(rs.next())
//                    {
//                          
////                        dispose();
//                    }
//                    else
//                        JOptionPane.showMessageDialog(null, "No record found", "", JOptionPane.WARNING_MESSAGE);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Server dowm hai", "", JOptionPane.WARNING_MESSAGE);
                }
                
                
                
                
            }
        });

        //calling the frame
        setScrren();

    }
}






























//
//public class TeacherPortal {
//    public static void main(String[] args) {
//        TPotalFrame tf=new TPotalFrame("Teacher Portal");
//    }
//
//    void setVisible(boolean b) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}
