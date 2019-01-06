import net.sf.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

class JDialogSignIn extends JDialog {
    private String username, password;
    private boolean isLogin = false;
    private Frame parent;
    private int authority=0;
    JDialogSignIn(Frame Frame, String title) {
        super(Frame, title, true);
        parent=Frame;
        this.setTitle(title);
        this.setSize(400, 350);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        init();
    }

    private void init() {
        Container container = this.getContentPane();

        JLabel l_un = new JLabel("用户名：");
        l_un.setSize(100, 50);
        l_un.setLocation(30, 40);
        JTextField t_un = new JTextField("");
        t_un.setSize(220, 50);
        t_un.setLocation(130, 40);

        JLabel l_pw = new JLabel("密码：");
        l_pw.setSize(100, 50);
        l_pw.setLocation(30, 110);
        JPasswordField t_pw = new JPasswordField("");
        t_pw.setSize(220, 50);
        t_pw.setEchoChar('*');
        t_pw.setLocation(130, 110);

        JRadioButton stu=new JRadioButton("学生");
        stu.setBounds(130,180,100,20);
        stu.setSelected(true);
        JRadioButton tch=new JRadioButton("教师");
        tch.setBounds(250,180,100,20);
        stu.addItemListener(e -> {
            if(e.getStateChange()==ItemEvent.SELECTED)
                authority=0;
        });
        tch.addItemListener(e -> {
            if(e.getStateChange()==ItemEvent.SELECTED)
                authority=1;
        });
        ButtonGroup bg=new ButtonGroup();
        bg.add(stu);
        bg.add(tch);

        JButton confirm = new JButton("确定");
        confirm.setSize(100, 50);
        confirm.setLocation(150, 220);
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = t_un.getText();
                password = String.valueOf(t_pw.getPassword());
                if(authority==0) {
                    JSONObject all = JSONObject.fromObject(new JsonRead("src/json/stuInfo.json").readContent());
                    if (all.has("students")) {
                        for (Object student : all.getJSONArray("students")) {
                            JSONObject stu = JSONObject.fromObject(student);
                            if (username.equals(stu.getString("username")) && password.equals(stu.getString("password"))) {
                                isLogin = true;
                                setVisible(false);
                                JMain main = new JMain(username, authority);
                                main.setVisible(true);
                                main.setLocationRelativeTo(null);
                                parent.dispose();
                            }
                        }
                    }
                }else{
                    JSONObject all = JSONObject.fromObject(new JsonRead("src/json/tchInfo.json").readContent());
                    if (all.has("teachers")) {
                        for (Object teacher : all.getJSONArray("teachers")) {
                            JSONObject tch = JSONObject.fromObject(teacher);
                            if (username.equals(tch.getString("username")) && password.equals(tch.getString("password"))) {
                                isLogin = true;
                                setVisible(false);
                                JMain main = new JMain(username, authority);
                                main.setVisible(true);
                                parent.dispose();
                            }
                        }
                    }
                }
            }
        });
        container.add(l_un);
        container.add(t_un);
        container.add(l_pw);
        container.add(t_pw);
        container.add(confirm);
        container.add(stu);
        container.add(tch);
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
