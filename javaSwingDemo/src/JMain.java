import javax.swing.*;

public class JMain extends JFrame {
    private String username;
    private int authority;
    JMain(String username,int authority){
        this.username=username;
        this.authority=authority;
        init(authority);
    }
    public void init(int authority){
        if(authority==0){//学生

        }else{//教师

        }
    }
}
