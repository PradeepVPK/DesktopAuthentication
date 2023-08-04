import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;


class register_design extends Frame implements ActionListener{
    Label title,firstname,lastname,Username,Passsword,confirmpasssword,DOB,address, status;
    TextField tf_firstname,tf_lastname,tf_Username,tf_Passsword,tf_confirmpasssword,tf_DOB;
    TextArea ta_address;
    Button cancel,register;

    String qry = "";
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    Statement stmt = null;

    //creating connection to database
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/register_login";
            String username = "pradeepro45";
            String password = "pradeepro45";
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //method to clear all textfields
    public void clear() {
        tf_firstname.setText("");
        tf_lastname.setText("");
        tf_Username.setText("");
        tf_Passsword.setText("");
        tf_confirmpasssword.setText("");
        tf_DOB.setText("");
        ta_address.setText("");
        tf_firstname.requestFocus();
    }
    public register_design(){

        connect();

        //creating A Frame
        Frame registerframe= new Frame();
        setTitle("REGISTRATION PAGE");
        setSize(2000,1200);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        setVisible(true);


        Font titleFont = new Font("arial", Font.BOLD, 25);
        Font labelFont = new Font("arial", Font.PLAIN, 18);
        Font textFont = new Font("arial", Font.PLAIN, 18);


        title=new Label("REGISTRATION PAGE");
        title.setBounds( 150,50,400,50);
        title.setFont(titleFont);
        title.setForeground(Color.yellow);
        add(title);

        firstname=new Label("First Name :");
        firstname.setBounds( 150,150,100,30);
        firstname.setFont(labelFont);
        firstname.setForeground(Color.white);
        add(firstname);

        lastname=new Label("Last Name :");
        lastname.setBounds( 150,200,100,30);
        lastname.setFont(labelFont);
        lastname.setForeground(Color.white);
        add(lastname);

        Username=new Label("Username :");
        Username.setBounds( 150,250,100,30);
        Username.setFont(labelFont);
        Username.setForeground(Color.white);
        add(Username);

        Passsword=new Label("Passord:");
        Passsword.setBounds( 150,300,100,30);
        Passsword.setFont(labelFont);
        Passsword.setForeground(Color.white);
        add(Passsword);


        confirmpasssword=new Label("Confirm Password :");
        confirmpasssword.setBounds( 150,350,200,30);
        confirmpasssword.setFont(labelFont);
        confirmpasssword.setForeground(Color.white);
        add(confirmpasssword);

        DOB=new Label("DOB :");
        DOB.setBounds( 150,400,100,30);
        DOB.setFont(labelFont);
        DOB.setForeground(Color.white);
        add(DOB);

        address=new Label("Address :");
        address.setBounds( 150,450,100,30);
        address.setFont(labelFont);
        address.setForeground(Color.white);
        add(address);


        tf_firstname=new TextField();
        tf_firstname.setBounds(350,150,200,30);
        tf_firstname.setFont(textFont);
        add(tf_firstname);

        tf_lastname=new TextField();
        tf_lastname.setBounds(350,200,200,30);
        tf_lastname.setFont(textFont);
        add(tf_lastname);

        tf_Username=new TextField();
        tf_Username.setBounds(350,250,200,30);
        tf_Username.setFont(textFont);
        add(tf_Username);

        tf_Passsword=new TextField();
        tf_Passsword.setBounds(350,300,200,30);
        tf_Passsword.setFont(textFont);
        add(tf_Passsword);

        tf_confirmpasssword=new TextField();
        tf_confirmpasssword.setBounds(350,350,200,30);
        tf_confirmpasssword.setFont(textFont);
        add(tf_confirmpasssword);

        tf_DOB=new TextField();
        tf_DOB.setBounds(350,400,200,30);
        tf_DOB.setFont(textFont);
        add(tf_DOB);

        ta_address=new TextArea(10,30);
        ta_address.setBounds(350,450,200,120);
        add(ta_address);

        register=new Button("Register");
        register.setBounds(200,600,100,30);
        register.setBackground(Color.blue);
        register.setFont(labelFont);
        register.addActionListener(this);
        add(register);

        cancel =new Button("Cancel");
        cancel.setBounds(400,600,100,30);
        cancel.setBackground(Color.RED);
        cancel.setFont(labelFont);
        cancel.addActionListener(this);
        add(cancel);



        //close button code
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       try{
           String firstname=tf_firstname.getText();
           String lastname=tf_lastname.getText();
           String username=tf_Username.getText();
           String password=tf_Passsword.getText();
           String confirmpassword=tf_confirmpasssword.getText();
           String dob=tf_DOB.getText();
           String address=ta_address.getText();

           if (e.getSource().equals(register)){
               //Save Details
               qry = "insert into register_info(firstname,lastname,username,password,confirmpassword,dob,address) values(?,?,?,?,?,?,?)";
               st = con.prepareStatement(qry);
               st.setString(1, firstname);
               st.setString(2, lastname);
               st.setString(3, username);
               st.setString(4, password);
               st.setString(5, confirmpassword);
               st.setString(6, dob);
               st.setString(7, address);
               st.executeUpdate();
               clear();
               login o=new login();
           }


           if (e.getSource().equals(cancel)) {
               clear();
           }


       } catch (Exception ex) {
           ex.printStackTrace();
       }

    }
}


public class register {
    public static void main(String[] args) {
register_design obj=new register_design();
    }
}
