abstract class AbstractSearcher {
    IGreatTemperamentGirl greatTemperamentGirl;
    IGoodBodyGirl goodBodyGirl;

    AbstractSearcher(IGreatTemperamentGirl _greatTemperamentGirl) {
        this.greatTemperamentGirl = _greatTemperamentGirl;
    }

    AbstractSearcher(IGoodBodyGirl _goodBodyGirl) {
        this.goodBodyGirl = _goodBodyGirl;
    }

    AbstractSearcher(String _name) {
        this.greatTemperamentGirl = new GreatTemperamentGirl(_name);
        this.goodBodyGirl = new GoodBodyGirl(_name);
    }

    abstract void show();
}
