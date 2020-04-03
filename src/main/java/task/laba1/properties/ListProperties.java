package task.laba1.properties;

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
