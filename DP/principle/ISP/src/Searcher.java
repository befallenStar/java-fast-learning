class Searcher extends AbstractSearcher {
    Searcher(IGreatTemperamentGirl _greatTemperamentGirl) {
        super(_greatTemperamentGirl);
    }

    Searcher(IGoodBodyGirl _goodBodyGirl) {
        super(_goodBodyGirl);
    }

    Searcher(String _name) {
        super(_name);
    }

    @Override
    void show() {
        if (super.greatTemperamentGirl != null)
            super.greatTemperamentGirl.greatTemperament();
        if (super.goodBodyGirl != null) {
            super.goodBodyGirl.goodLooking();
            super.goodBodyGirl.niceFigure();
        }
    }
}
