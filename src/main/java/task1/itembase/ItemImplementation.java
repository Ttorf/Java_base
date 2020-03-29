package task1.itembase;

import task1.general.Items;

import java.util.Objects;
import java.util.Set;

public class ItemImplementation extends Items {
    private String nameItem;
    private int weightItem;
    private Set<String> additionalPropertiesItem;
    private boolean ownerbyContainer;
    private String nameContainer;

    public ItemImplementation(String nameItem, Set<String> additionalPropertiesItem) {
        this.weightItem = 0;
        this.nameItem = nameItem;
        this.additionalPropertiesItem = additionalPropertiesItem;
    }


    @Override
    public String getName() {
        return getNameItem();
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

    public void setOwner(boolean ownerbyContainer) {
        this.ownerbyContainer = ownerbyContainer;
    }

    public boolean isOwner() {
        return ownerbyContainer;
    }

    @Override
    public void getInfo() {
        if (weightItem == 0) {
            System.out.println("Наименование предмета:" + getNameItem() + ", Доп.свойства: " + getAdditionalPropertiesItem());
        } else

            System.out.println("Наименование предмета:" + getNameItem() + ", Вес:" + getWeightItem() + ", Доп.свойства: " + getAdditionalPropertiesItem());
    }

    @Override
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
        ItemImplementation that = (ItemImplementation) o;
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
