import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Vector;

class JsonFind {
    JsonFind() {

    }

    Vector<Vector<String>> findStuByCourse(String courseName) {
        Vector<Vector<String>> results = new Vector<>();
        JsonRead jr = new JsonRead("src/json/stuInfo.json");
        String content = jr.readContent();
        JSONObject all = JSONObject.fromObject(content);
        for (Object s : all.getJSONArray("students")) {
            JSONObject stu = JSONObject.fromObject(s);
            for (Object c : stu.getJSONArray("courses")) {
                JSONObject cal = JSONObject.fromObject(c);
                if (cal.get("name").equals(courseName)) {
                    Vector<String> result = getStuInfo(stu);
                    results.add(result);
                }
            }
        }
        return results;
    }

    Vector<String> getStuInfo(JSONObject stu) {
        Vector<String> result = new Vector<>();
        result.add(stu.get("username").toString());
        result.add(stu.get("name").toString());
        result.add(stu.get("gender").toString());
        result.add(stu.get("college").toString());
        result.add(stu.get("depart").toString());
        return result;
    }

    Vector<String> getCourseInfo(JSONObject cal) {
        Vector<String> result = new Vector<>();
        result.add(cal.get("name").toString());
        result.add(cal.get("credit").toString());
        result.add(cal.get("teacher").toString());
        return result;
    }

    Vector<Vector<String>> getGrade(JSONObject stu) {
        Vector<Vector<String>> results = new Vector<>();
        JSONArray ja = stu.getJSONArray("courses");
        for (Object o : ja) {
            Vector<String> result = new Vector<>();
            result.add(JSONObject.fromObject(o).get("name").toString());
            result.add(JSONObject.fromObject(o).get("grade").toString());
            results.add(result);
        }
        return results;
    }
}
