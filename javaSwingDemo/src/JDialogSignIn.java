import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class JDialogSignIn extends JDialog {
    private String username,password;
    private boolean isLogin=false;
    JDialogSignIn(Frame Frame, String title){
        super(Frame,title,true);
        this.setTitle(title);
        this.setSize(350,500);
        this.setLocation(300,300);
        this.setLayout(null);
        init();
    }
    private void init() {
        Container container=this.getContentPane();
        JLabel title=new JLabel("登录",SwingConstants.CENTER);
        title.setSize(200,50);
        title.setLocation(100,0);

        JLabel l_un=new JLabel("用户名：");
        l_un.setSize(100,50);
        l_un.setLocation(50,60);

        JTextField t_un=new JTextField("");
        t_un.setSize(200,50);
        t_un.setLocation(170,60);

        JLabel l_pw=new JLabel("密码：");
        l_pw.setSize(100,50);
        l_pw.setLocation(50,120);
        JPasswordField t_pw=new JPasswordField("");
        t_pw.setSize(200,50);
        t_pw.setEchoChar('*');
        t_pw.setLocation(170,120);

        JButton confirm=new JButton("确定");
        confirm.setSize(100,50);
        confirm.setLocation(100,180);
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username=t_un.getText();
                password=String.valueOf(t_pw.getPassword());
                if(username.equals("111")&&password.equals("111")) {
                    isLogin = true;
                    setVisible(false);
                }
            }
        });
        container.add(title);
        container.add(l_un);
        container.add(t_un);
        container.add(l_pw);
        container.add(t_pw);
        container.add(confirm);
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
