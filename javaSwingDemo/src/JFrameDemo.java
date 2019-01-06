import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JFrameDemo extends JFrame {
    private JDialogSignUp signUpDialog;
    private JDialogSignIn signInDialog;
    private JFrameDemo(){
        this.setVisible(true);
        this.setSize(300,250);
        this.setLocationRelativeTo(null);
        this.setTitle("Demo");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init();
    }
    private void init(){
        Container c=this.getContentPane();
        c.setLayout(null);
        JButton signUp=new JButton("注册");
        signUp.setBounds(50,30,200,50);
        signUp.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpDialog=new JDialogSignUp(JFrameDemo.this,"注册");
                signUpDialog.setModal(true);
                signUpDialog.setVisible(true);
            }
        });
        JButton signIn=new JButton("登录");
        signIn.setBounds(50,100,200,50);
        signIn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signInDialog=new JDialogSignIn(JFrameDemo.this,"登录");
                signInDialog.setModal(true);
                signInDialog.setVisible(true);
            }
        });
        c.add(signUp);
        c.add(signIn);
    }
    public static void main(String[] args){
        new JFrameDemo();
    }
}
