package task.laba1.models;

import task.laba1.properties.ListProperties;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Item {
    public final String nameItem;
    private int weightItem;
    private Set<ListProperties> additionalPropertiesItem;
    private boolean ownerbyContainer;
    private String nameContainer;

    public Item(String nameItem, Set<ListProperties> additionalPropertiesItem) {
        this.weightItem = 0;
        this.nameItem = nameItem;
        this.additionalPropertiesItem = additionalPropertiesItem;
    }

    public Item(String nameItem) {
        this.weightItem = 0;
        this.nameItem = nameItem;
        additionalPropertiesItem = new HashSet<>();
    }

    public Item(String nameItem, int weightItem) {
        this.weightItem = weightItem;
        this.nameItem = nameItem;
        additionalPropertiesItem = new HashSet<>();
    }

    public Item(String nameItem, Set<ListProperties> additionalPropertiesItem, int weightItem) {
        this.nameItem = nameItem;
        this.weightItem = weightItem;
        this.additionalPropertiesItem = additionalPropertiesItem;
    }

    protected Item() {
        nameItem = null;
    }

    public String getName() {
        return getNameItem();
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

    public Set<ListProperties> getAdditionalPropertiesItem() {
        return additionalPropertiesItem;
    }

    public void setAdditionalPropertiesItem(ListProperties properties) {
        additionalPropertiesItem.add(properties);
    }


    public void setOwner(boolean ownerbyContainer) {
        this.ownerbyContainer = ownerbyContainer;
    }

    public boolean isOwner() {
        return ownerbyContainer;
    }


    public void getInfo() {
        if (weightItem == 0) {
            System.out.println("Наименование предмета:" + getNameItem() + ", Доп.свойства: " + getAdditionalPropertiesItem());
        } else

            System.out.println("Наименование предмета:" + getNameItem() + ", Вес:" + getWeightItem() + ", Доп.свойства: " + getAdditionalPropertiesItem());
    }


    public void getInfoContainer() {
        System.out.println(getNameContainer());
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
        Item that = (Item) o;
        return weightItem == that.weightItem &&
                ownerbyContainer == that.ownerbyContainer &&
                Objects.equals(nameItem, that.nameItem) &&
                Objects.equals(additionalPropertiesItem, that.additionalPropertiesItem) &&
                Objects.equals(nameContainer, that.nameContainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameItem, weightItem, additionalPropertiesItem, ownerbyContainer, nameContainer);
    }
}
