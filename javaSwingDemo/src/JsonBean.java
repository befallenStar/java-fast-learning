import net.sf.json.JSONObject;

class JsonBean {
    private String username;
    private String password;
    private String gender;
    private String number;
    private String college;
    private String depart;
    JsonBean(String u,String p,String g,String n,String c,String d){
        username=u;
        password=p;
        gender=g;
        number=n;
        college=c;
        depart=d;
    }
    JSONObject createJsonBean(){
        JSONObject jo=new JSONObject();
        jo.put("username",username);
        jo.put("password",password);
        jo.put("gender",gender);
        jo.put("number",number);
        jo.put("college",college);
        jo.put("depart",depart);
        return jo;
    }
}
