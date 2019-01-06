import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Vector;

class JMain extends JFrame {
    private String username;
    private int authority;
    Vector<String> cs;
    Vector<String> cals;
    String cInfo;

    JMain(String username, int authority) {
        this.username = username;
        this.authority = authority;
        this.setSize(500, 500);
        cs = new Vector<>();
        cals = new Vector<>();
        init();
    }

    private void init() {
        Container container = getContentPane();
        container.setLayout(null);
        JLabel usr = new JLabel();
        usr.setBounds(10, 10, 100, 50);
        JLabel name = new JLabel();
        name.setBounds(10, 60, 100, 50);
        JList<String> infoList = new JList<>();
        infoList.setBounds(10, 110, 100, 50);
        JList<String> calsInfoList = new JList<>();
        calsInfoList.setBounds(200, 110, 100, 50);
        JLabel calInfo = new JLabel();
        calInfo.setBounds(10, 200, 200, 50);
        JButton search = new JButton("查询");
        search.setBounds(10, 420, 200, 50);
        search.addActionListener(e -> {
            if (authority == 0) {
                JsonRead jr = new JsonRead("src/json/calInfo.json");
                String content = jr.readContent();
                JSONArray courses = JSONArray.fromObject(JSONObject.fromObject(content).get("courses"));
                for (int i = 0; i < courses.size(); i++) {
                    JSONObject cal = JSONObject.fromObject(courses.get(i));
                    cals.add(cal.get("name").toString());
                }
                calsInfoList.setListData(cals);
                calsInfoList.setSize(200, (cals.size() + 1) * 20);
                calsInfoList.addListSelectionListener(e1 -> {
                    int index = calsInfoList.getSelectedIndex();
                    JSONObject cal = JSONObject.fromObject(courses.get(index));
                    cInfo = cal.get("credit").toString() + '\t' + cal.get("teacher");
                    calInfo.setText(cInfo);
                });
            } else {
            }
        });
        if (authority == 0) {//学生
            JsonRead jr = new JsonRead("src/json/stuInfo.json");
            String content = jr.readContent();
            JSONObject all = JSONObject.fromObject(content);
            JSONArray students = all.getJSONArray("students");
            for (int i = 0; i < students.size(); i++) {
                JSONObject stu = JSONObject.fromObject(students.get(i));
                if (!stu.get("username").equals(username))
                    continue;
                usr.setText(username);
                name.setText(stu.get("name").toString());
                JSONArray courses = JSONArray.fromObject(stu.get("courses"));
                for (int j = 0; j < courses.size(); j++)
                    cs.add(JSONObject.fromObject(courses.get(j)).get("name").toString());
                infoList.setListData(cs);
                infoList.setSize(100, (cs.size() + 1) * 20);
            }
        } else {//教师
            JsonRead jr = new JsonRead("src/json/tchInfo.json");
            String content = jr.readContent();
            JSONObject all = JSONObject.fromObject(content);
            JSONArray teachers = all.getJSONArray("teachers");
            for (int i = 0; i < teachers.size(); i++) {
                JSONObject tch = JSONObject.fromObject(teachers.get(i));
                if (!tch.get("username").equals(username))
                    continue;
                usr.setText(username);
                name.setText(tch.get("name").toString());
                JSONArray courses = JSONArray.fromObject(tch.get("courses"));
                for (int j = 0; j < courses.size(); j++)
                    cs.add(JSONObject.fromObject(courses.get(j)).get("name").toString());
                infoList.setListData(cs);
                infoList.setSize(100, (cs.size() + 1) * 20);
            }
        }
        container.add(usr);
        container.add(name);
        container.add(infoList);
        container.add(calsInfoList);
        container.add(search);
        container.add(calInfo);
    }
}
