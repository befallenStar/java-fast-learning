public class WhiteHumanFactory implements HumanFactory {
    @Override
    public Human createMale() {
        return new MaleWhiteHuman();
    }

    @Override
    public Human createFemale() {
        return new FemaleWhiteHuman();
    }
}
