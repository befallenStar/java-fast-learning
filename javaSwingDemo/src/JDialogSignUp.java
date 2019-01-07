import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class JDialogSignUp extends JDialog {
    private Frame parent;

    JDialogSignUp(Frame Frame, String title) {
        super(Frame, title, true);
        parent = Frame;
        this.setTitle(title);
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        init();
    }

    private void init() {
        Container c = this.getContentPane();
        c.setLayout(null);

        JLabel l_un = new JLabel("用户名：");
        l_un.setSize(100, 50);
        l_un.setLocation(30, 30);
        JTextField t_un = new JTextField("");
        t_un.setSize(220, 50);
        t_un.setLocation(130, 30);

        JLabel l_pw = new JLabel("密码：");
        l_pw.setSize(100, 50);
        l_pw.setLocation(30, 100);
        JPasswordField t_pw = new JPasswordField("");
        t_pw.setSize(220, 50);
        t_pw.setEchoChar('*');
        t_pw.setLocation(130, 100);

        JLabel l_n = new JLabel("姓名：");
        l_n.setSize(100, 50);
        l_n.setLocation(30, 170);
        JTextField t_n = new JTextField("");
        t_n.setSize(220, 50);
        t_n.setLocation(130, 170);

        JLabel l_gender = new JLabel("性别：");
        l_gender.setSize(100, 50);
        l_gender.setLocation(30, 240);
        JComboBox<String> cb_gender = new JComboBox<>(new String[]{"男", "女"});
        cb_gender.setSize(120, 50);
        cb_gender.setLocation(130, 240);

        JLabel l_de = new JLabel("院系：");
        l_de.setSize(100, 50);
        l_de.setLocation(30, 310);
        String[] cols = {"文学院", "社会发展学院", "公共管理学院", "教育科学学院", "外国语学院", "数学科学学院", "物理科学与技术学院", "化学与材料科学学院", "生命科学学院",
                "地理科学学院", "音乐学院", "美术学院", "新闻与传播学院", "体育科学学院", "商学院", "金陵女子学院", "法学院", "心理学院",
                "计算机科学与技术学院", "能源与机械工程学院", "南瑞电气与自动化学院", "教师教育学院", "强化培养学院", "国际文化教育学院", "马克思主义学院", "环境学院", "海洋科学与工程学院"};
        JComboBox<String> cb_col = new JComboBox<>(cols);
        cb_col.setSize(110, 50);
        cb_col.setLocation(130, 310);
        String[][] departs = {{"中国语言文学类（含汉语言文学（国家文科基地）、秘书学）", "古典文献学", "汉语言", "播音与主持技术"},
                {"历史学", "文物与博物馆学", "社会学"},
                {"哲学", "行政管理"},
                {"教育学（师范）", "教育学类（含小学教育（师范）、学前教育（师范））", "教育技术学（师范）"},
                {"翻译", "英语", "外国语言文学类（含俄语、西班牙语、法语、日语、朝鲜语）"},
                {"数学类（含数学与应用数学（基地班）、信息与计算科学）", "金融数学", "统计学"},
                {"物理学", "电子信息类（含电子信息工程、通信工程光电信息科学与工程）"},
                {"化学类（含化学、应用化学）"},
                {"生物科学类（含生物科学（国家理科基地班）、生物技术）", "生物工程"},
                {"旅游管理", "测绘工程", "地理科学类（含自然地理与资源环境、人文地理与城乡规划、地理信息科学）"},
                {"音乐学（师范）", "舞蹈学（师范）"},
                {"美术学类（含美术学、绘画、中国画）", "设计学类（含视觉传达设计、环境设计、产品设计）"},
                {"新闻传播学类（含新闻学、广播电视学、广告学、网络与新媒体）"},
                {"体育学类（含体育教育、社会体育指导与管理）"},
                {"经济学", "金融学", "国际经济与贸易", "工商管理类（含工商管理、人力资源管理）"},
                {"会计学", " 财务管理", "劳动与社会保障", "英语", "食品科学与工程"},
                {"法学"},
                {"应用心理学"},
                {"计算机科学与技术", "软件工程（嵌入式培养）"},
                {"建筑环境与能源应用工程", "能源动力类（含能源与动力工程、能源与环境系统工程）"},
                {"电气工程及其自动化", "自动化"},
                {"地理科学（师范）", "汉语言文学（师范）", "历史学（师范）", "思想政治教育（师范）", "英语（师范）", "化学（师范）",
                        "计算机科学与技术（师范）", "生物科学（师范）", "数学与应用数学（师范）", "物理学（师范）"},
                {"文科强化班", "理科强化班", "工科强化班"},
                {"汉语国际教育"},
                {"思想政治教育"},
                {"环境科学与工程类（含环境工程、环境科学）"},
                {"海洋资源开发技术"}};
        JComboBox<String> cb_de = new JComboBox<>(departs[0]);
        cb_de.setSize(110, 50);
        cb_de.setLocation(240, 310);
        cb_col.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cb_de.removeAllItems();
                    int index = cb_col.getSelectedIndex();
                    for (int i = 0; i < departs[index].length; i++)
                        cb_de.addItem(departs[index][i]);
                }
            }
        });

        JButton confirm = new JButton("确定");
        confirm.setSize(100, 50);
        confirm.setLocation(150, 380);
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = t_un.getText();
                String password = String.valueOf(t_pw.getPassword());
                String name = String.valueOf(t_n.getText());
                String gender = cb_gender.getSelectedItem().toString();
                String college = cb_col.getSelectedItem().toString();
                String depart = cb_de.getSelectedItem().toString();
                String content = new JsonRead("src/json/stuInfo.json").readContent();
                if (!content.equals("")) {
                    JSONArray users = JSONObject.fromObject(content).getJSONArray("students");
                    JSONObject newStu = new JsonBean(username, password, name, gender, college, depart).createJsonBean();
                    JSONObject all = new JSONObject();
                    users.add(newStu);
                    all.put("students", users);
                    new JsonWrite("src/json/stuInfo.json").writeContent(all.toString());
                } else {
                    JSONArray users = new JSONArray();
                    JSONObject newStu = new JsonBean(username, password, name, gender, college, depart).createJsonBean();
                    JSONObject all = new JSONObject();
                    users.add(newStu);
                    all.put("students", users);
                    new JsonWrite("src/json/stuInfo.json").writeContent(all.toString());
                }
                setVisible(false);
                JMain main = new JMain(username, 0);
                main.setVisible(true);
                parent.dispose();
            }
        });

        c.add(l_un);
        c.add(t_un);
        c.add(l_pw);
        c.add(t_pw);
        c.add(l_gender);
        c.add(cb_gender);
        c.add(l_n);
        c.add(t_n);
        c.add(l_de);
        c.add(cb_col);
        c.add(cb_de);
        c.add(confirm);
    }
}
