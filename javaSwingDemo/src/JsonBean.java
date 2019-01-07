import net.sf.json.JSONObject;

class JsonBean {
    private String username;
    private String password;
    private String name;
    private String gender;
    private String college;
    private String depart;

    JsonBean(String u, String p, String n, String g, String c, String d) {
        username = u;
        password = p;
        name = n;
        gender = g;
        college = c;
        depart = d;
    }

    JSONObject createJsonBean() {
        JSONObject jo = new JSONObject();
        jo.put("username", username);
        jo.put("password", password);
        jo.put("name", name);
        jo.put("gender", gender);
        jo.put("college", college);
        jo.put("depart", depart);
        return jo;
    }
}
