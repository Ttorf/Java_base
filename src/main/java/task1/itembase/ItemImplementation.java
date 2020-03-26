package task1.itembase;

import task1.general.Item;

import java.util.Objects;
import java.util.Set;

public class ItemImplementation implements Item {
    private final String nameItem;
    private final int weightItem;
    private final Set<String> additionalPropertiesItem;
    private boolean owner;
    private String nameContainer;

    public ItemImplementation(String nameItem, Set<String> additionalPropertiesItem) {
        this.weightItem = 0;
        this.nameItem = nameItem;
        this.additionalPropertiesItem = additionalPropertiesItem;
    }

    public ItemImplementation(String nameItem, Set<String> additionalPropertiesItem, int weightItem) {
        this.nameItem = nameItem;
        this.weightItem = weightItem;
        this.additionalPropertiesItem = additionalPropertiesItem;
    }

    protected void setNameContainer(String nameContainer) {
        this.nameContainer = nameContainer;
    }

    public String getNameContainer() {
        return nameContainer;
    }


    public int getWeightItem() {
        return weightItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public Set<String> getAdditionalPropertiesItem() {
        return additionalPropertiesItem;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public boolean isOwner() {
        return owner;
    }


    @Override
    public void getInfo(ItemImplementation nameItemImplementation) {
        if (weightItem == 0) {
            System.out.println("Наименование предмета:" + nameItemImplementation.nameItem + ", Доп.свойства: " + nameItemImplementation.additionalPropertiesItem);
        } else

            System.out.println("Наименование предмета:" + nameItemImplementation.nameItem + ", Вес:" + nameItemImplementation.weightItem + ", Доп.свойства: " + nameItemImplementation.additionalPropertiesItem);
    }


    @Override
    public String toString() {
        return nameItem +
                ", вес = " + weightItem + "кг" +
                ", дополнительные свойства=" + additionalPropertiesItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemImplementation itemImplementation = (ItemImplementation) o;
        return weightItem == itemImplementation.weightItem &&
                Objects.equals(nameItem, itemImplementation.nameItem) &&
                Objects.equals(additionalPropertiesItem, itemImplementation.additionalPropertiesItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameItem, weightItem, additionalPropertiesItem);
    }

}
