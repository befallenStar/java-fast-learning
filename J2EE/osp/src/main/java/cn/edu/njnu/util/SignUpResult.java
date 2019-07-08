package cn.edu.njnu.util;


public class SignUpResult {

    private String type;
    private String msg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SignUpResult(String type, String msg) {
        this.type = type;
        this.msg = msg;
    }
}
