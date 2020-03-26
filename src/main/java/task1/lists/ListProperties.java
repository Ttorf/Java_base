package task1.lists;

public enum ListProperties {

    FLAT("плоский"), COLLORBLACK("цвет=Чёрный"), COLLORWHITE("цвет=Белый"), HEAVY("тяжелый");

    private String propertoies;

    ListProperties(String propertoies) {
        this.propertoies = propertoies;
    }

    public String getPropertoies() {
        return propertoies;
    }
}
