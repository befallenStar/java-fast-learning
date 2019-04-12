public class GoodBodyGirl implements IGoodBodyGirl {
    private String name;

    GoodBodyGirl(String _name) {
        this.name = _name;
    }

    @Override
    public void goodLooking() {
        System.out.println(this.name + "---脸蛋很好看...");
    }

    @Override
    public void niceFigure() {
        System.out.println(this.name + "---身材非常棒...");
    }
}
