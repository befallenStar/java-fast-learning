import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

class JMain extends JFrame {
    private String username;
    private int authority;
    private Vector<String> cs;
    private Vector<Vector<String>> findInfo;
    private String calSelected;
    private JsonFind jf;
    private JSONObject all;
    private JSONObject currentUser;

    JMain(String username, int authority) {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.username = username;
        this.authority = authority;
        cs = new Vector<>();
        findInfo = new Vector<>();
        calSelected = null;
        jf = new JsonFind();
        if (authority == 0)
            all = JSONObject.fromObject(new JsonRead("src/json/stuInfo.json").readContent());
        else
            all = JSONObject.fromObject(new JsonRead("src/json/tchInfo.json").readContent());
        init();
    }

    private void init() {
        Container container = getContentPane();
        container.setLayout(null);
        JLabel usr = new JLabel();
        usr.setBounds(10, 10, 100, 30);
        JLabel name = new JLabel();
        name.setBounds(10, 50, 100, 30);
        JList<String> infoList = new JList<>();
        JButton search = new JButton("查询");
        search.setBounds(380, 10, 80, 30);
        JScrollPane jsp = new JScrollPane();
        search.addActionListener(e -> {
            if (authority == 0) {
                findInfo.clear();
                for (Object cours : JSONArray.fromObject(JSONObject.fromObject(new JsonRead("src/json/calInfo.json").readContent()).get("courses"))) {
                    JSONObject cal = JSONObject.fromObject(cours);
                    Vector<String> singleInfo = jf.getCourseInfo(cal);
                    findInfo.addElement(singleInfo);
                }
                Vector<String> header = new Vector<>();
                header.add("课程名");
                header.add("学分");
                header.add("授课教师");
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.setDataVector(findInfo, header);
                JTable findInfoTable = new JTable(dtm) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                findInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                jsp.setBounds(10, 110, 350, (findInfo.size() + 1) * 20);
                jsp.setViewportView(findInfoTable);
                findInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                findInfoTable.setVisible(true);
                JButton choose = new JButton("选课");
                choose.setBounds(380, 110, 80, 50);
                choose.addActionListener(e1 -> {
                    if (findInfoTable.getSelectedRow() >= 0) {
                        String name1 = String.valueOf(findInfoTable.getValueAt(findInfoTable.getSelectedRow(), 0));
                        JSONArray students = all.getJSONArray("students");
                        for (int i = 0; i < students.size(); i++) {
                            Object o = students.get(i);
                            JSONObject find = JSONObject.fromObject(o);
                            if (!find.get("username").equals(currentUser.get("username")))
                                continue;
                            students.remove(i);
                            JSONArray choices = find.getJSONArray("courses");
                            JSONObject choice = new JSONObject();
                            choice.put("name", name1);
                            choice.put("grade", 0);
                            choices.add(choice);
                            find.put("courses", choices);
                            students.add(i,find);
                        }
                        new JsonWrite("src/json/stuInfo.json").writeContent(String.valueOf(all));
                    }
                });
                container.add(choose);
            } else {
                Vector<String> header = new Vector<>();
                header.add("学号");
                header.add("姓名");
                header.add("性别");
                header.add("学院");
                header.add("专业");
                Vector<Vector<String>> re = jf.findStuByCourse(calSelected);
                DefaultTableModel dtm = new DefaultTableModel();
                dtm.setDataVector(re, header);
                JTable findInfoTable = new JTable(dtm) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                findInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                jsp.setBounds(10, 110, 350, (re.size() + 1) * 20);
                jsp.setViewportView(findInfoTable);
                findInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                findInfoTable.setVisible(true);
                jsp.setVisible(true);
            }
        });
        if (authority == 0) {//学生
            JSONArray students = all.getJSONArray("students");
            for (Object student : students) {
                JSONObject stu = JSONObject.fromObject(student);
                if (!stu.get("username").equals(username))
                    continue;
                currentUser = stu;
                usr.setText(username);
                name.setText(stu.get("name").toString());
                JSONArray courses = JSONArray.fromObject(stu.get("courses"));
                for (Object cours : courses) cs.add(JSONObject.fromObject(cours).get("name").toString());
                infoList.setListData(cs);
                infoList.setBounds(150, 10, 200, (cs.size() + 1) * 20);
            }
        } else {//教师
            JSONArray teachers = all.getJSONArray("teachers");
            for (Object teacher : teachers) {
                JSONObject tch = JSONObject.fromObject(teacher);
                if (!tch.get("username").equals(username))
                    continue;
                currentUser = tch;
                usr.setText(username);
                name.setText(tch.get("name").toString());
                JSONArray courses = JSONArray.fromObject(tch.get("courses"));
                for (Object cours : courses) cs.add(JSONObject.fromObject(cours).get("name").toString());
                infoList.setListData(cs);
                infoList.setBounds(150, 10, 200, (cs.size() + 1) * 20);
                infoList.addListSelectionListener(e -> calSelected = infoList.getSelectedValue());
            }
        }
        container.add(usr);
        container.add(name);
        container.add(infoList);
        container.add(search);
        container.add(jsp);
    }
}
