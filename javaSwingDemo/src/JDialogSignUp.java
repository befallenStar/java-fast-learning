import javax.swing.*;
import java.awt.*;

public class JDialogSignUp extends JDialog {
    JDialogSignUp(Frame Frame, String title){
        super(Frame,title,true);
        this.setTitle(title);
        this.setSize(350,500);
        this.setLocation(300,300);
        this.setLayout(null);
        init();
    }
    void init(){
        //JL
        //JL JTF username
        //JL JPF password
        //JL JComboBox sex
        //JL JTF number
        //JL JComboBox*2 college+depart
    }
}
