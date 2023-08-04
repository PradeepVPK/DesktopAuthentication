import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class login extends Frame implements ActionListener {
    Label loginpage,username,password,forgotpassword;
    TextField tf_username,tf_password;
    Button login,cancel;


    public login(){
        Frame log=new Frame();
        setTitle("LOGIN PAGE");
        setSize(2000,1200);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        setVisible(true);

        //Fonts
        Font titleFont = new Font("arial", Font.BOLD, 30);
        Font labelFont = new Font("arial", Font.PLAIN, 22);
        Font textFont = new Font("arial", Font.PLAIN, 18);

        loginpage=new Label("LOGIN PAGE");
        loginpage.setBounds( 250,130,400,50);
        loginpage.setFont(titleFont);
        loginpage.setForeground(Color.yellow);
        add(loginpage);

        username=new Label("Username :");
        username.setBounds( 300,250,100,30);
        username.setFont(labelFont);
        username.setForeground(Color.white);
        add(username);


        password=new Label("Password :");
        password.setBounds( 300,330,100,30);
        password.setFont(labelFont);
        password.setForeground(Color.white);
        add(password);


        forgotpassword=new Label("Forgot Password ?");
        forgotpassword.setBounds( 300,480,200,30);
        forgotpassword.setFont(textFont);
        forgotpassword.setForeground(Color.white);
        add(forgotpassword);



        tf_username=new TextField();
        tf_username.setBounds(470,250,280,30);
        tf_username.setFont(textFont);
        add(tf_username);


        tf_password=new TextField();
        tf_password.setBounds(470,330,280,30);
        tf_password.setFont(textFont);
        add(tf_password);

        login=new Button("LOGIN");
        login.setBounds(400,430,150,35);
        login.setFont(labelFont);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);


        cancel=new Button("CANCEL");
        cancel.setBounds(600,430,150,35);
        cancel.setFont(labelFont);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        //closee button
       this.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
       });
    }

    public static void main(String[] args) {
        login ob=new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
