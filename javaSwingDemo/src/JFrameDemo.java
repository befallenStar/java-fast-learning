import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JFrameDemo extends JFrame {
    private String username,password;
    private JDialogSignUp signUpDialog;
    private JDialogSignIn signInDialog;
    private JFrameDemo(){
        this.setVisible(true);
        this.setSize(500,300);
        this.setLocation(200,200);
        this.setTitle("Demo");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
    }
    private void init(){
        Container c=this.getContentPane();
        c.setLayout(null);
        JLabel test=new JLabel("test");
        test.setSize(100,100);
        test.setLocation(0,0);
        JButton signUp=new JButton("注册");
        signUp.setBounds(30,30,200,50);
        signUp.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpDialog=new JDialogSignUp(JFrameDemo.this,"signUpDemo");
                signUpDialog.setSize(400,300);
                signUpDialog.setModal(true);
                signUpDialog.setVisible(true);
            }
        });
        JButton signIn=new JButton("登录");
        signIn.setBounds(30,100,200,50);
        signIn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signInDialog=new JDialogSignIn(JFrameDemo.this,"signInDemo");
                signInDialog.setSize(400,300);
                signInDialog.setModal(true);
                signInDialog.setVisible(true);
                username=signInDialog.getUsername();
                password=signInDialog.getPassword();
                test.setText(username+" "+password);
            }
        });
        c.add(test);
        c.add(signUp);
        c.add(signIn);
    }
    public static void main(String[] args){
        new JFrameDemo();
    }
}
