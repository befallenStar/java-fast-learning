public class NvWa {
    public static void main(String[] args) {
        HumanFactory blackHumanFactory = new BlackHumanFactory();
        HumanFactory whiteHumanFactory = new WhiteHumanFactory();
        HumanFactory yellowHumanFactory = new YellowHumanFactory();
        Human maleBlackHuman = blackHumanFactory.createMale();
        Human femaleWhiteHuman = whiteHumanFactory.createFemale();
        Human maleYellowHuman = yellowHumanFactory.createMale();
        maleBlackHuman.getSex();
        maleBlackHuman.getColor();
        maleBlackHuman.talk();
        femaleWhiteHuman.getSex();
        femaleWhiteHuman.getColor();
        femaleWhiteHuman.talk();
        maleYellowHuman.getSex();
        maleYellowHuman.getColor();
        maleYellowHuman.talk();
    }
}
