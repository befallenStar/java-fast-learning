public class Client {
    public static void main(String[] args) {
        IGreatTemperamentGirl a = new GreatTemperamentGirl("三");
        AbstractSearcher searcher = new Searcher(a);
        searcher.show();
        IGoodBodyGirl b = new GoodBodyGirl("四");
        searcher = new Searcher(b);
        searcher.show();
        searcher = new Searcher("五");
        searcher.show();
    }
}