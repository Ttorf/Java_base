package task1.models;

import task1.exceptions.ItemAlreadyPlacedException;
import task1.exceptions.ItemStoreException;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box extends AbstractContainer {
    private final int maxNumberOfItems;
    private final int totalWeight;
    private final String nameContainer;
    private String nameInContainer;
    private int curretWeight;
    private int curretNumberOfItems = 0;
    private boolean owner = false;
    private final boolean typeFlat = true;
    private List<Item> listItems;

    public Box(List<Item> listItems, int maxNumberOfItems, int totalWeight, String nameContainer, int curretWeight) {
        this.maxNumberOfItems = maxNumberOfItems;
        this.totalWeight = totalWeight;
        this.nameContainer = nameContainer;
        this.curretWeight = curretWeight;
        this.listItems = listItems;
    }

    public Box(int maxNumberOfItems, int totalWeight, String nameContainer) {
        this.maxNumberOfItems = maxNumberOfItems;
        this.totalWeight = totalWeight;
        this.nameContainer = nameContainer;
        this.curretWeight = 0;
        listItems = new ArrayList<>();
    }

    @Override
    public void addItemToContainer(Item item) throws ItemAlreadyPlacedException, ItemStoreException {
        int futureWeight = getCurretWeight() + item.getWeightItem();

        if (futureWeight <= getTotalWeight() && !item.isOwner()) {
            listItems.add(item);
            setCurretNumberOfItems(getCurretNumberOfItems() + 1);
            item.setOwner(true);
            item.setNameContainer(getNameContainer());
            System.out.println("Предмет" + "'" + item.getNameItem() + "'" + " добавлен в " + getNameContainer());
            this.curretWeight = curretWeight + item.getWeightItem();

        } else if (futureWeight > getTotalWeight()) {
            throw new ItemStoreException("Failed to save object");

        } else if (item.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }

    }

    @Override
    public String getName() {
        return getNameContainer();
    }


    public void addItemToContainer(Box whichPutIninBoxItem) throws ItemAlreadyPlacedException, ItemStoreException {


        int futureWeight = whichPutIninBoxItem.getCurretWeight() + getCurretWeight();
        if (!whichPutIninBoxItem.isOwner() && futureWeight <= getTotalWeight()) {
            int curretWeightTemp;
            curretWeightTemp = getCurretWeight() + whichPutIninBoxItem.getCurretWeight();
            setCurretWeight(curretWeightTemp);
            listItems.add(whichPutIninBoxItem);
            System.out.println("Предмет " + "'" + whichPutIninBoxItem.getNameContainer() + "'" + " добавлен в " + getNameContainer());
            setCurretNumberOfItems(1 + getCurretNumberOfItems());
            whichPutIninBoxItem.setOwner(true);
            whichPutIninBoxItem.setNameInContainer(getNameContainer());

        } else if (this.curretWeight > this.totalWeight || futureWeight > totalWeight) {
            throw new ItemStoreException("Failed to save object");

        } else if (isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }

    }

    public void addItemToContainer(Bag whichPutIninBagItem) throws ItemAlreadyPlacedException, ItemStoreException {


        System.err.println("Предмет " + whichPutIninBagItem.getNameContainer() + " нельзя добавить в данный контейнер");

    }

    public void addItemToContainer(Stack whichPutIninStackItem) throws ItemAlreadyPlacedException, ItemStoreException {


        boolean boxProperties = whichPutIninStackItem.isFlat();
        int futureWeight = curretWeight + whichPutIninStackItem.getCurretWeight();

        if (boxProperties && futureWeight <= getTotalWeight() && !whichPutIninStackItem.isOwner()) {

            listItems.add(whichPutIninStackItem);
            setCurretNumberOfItems(whichPutIninStackItem.getCurretNumberOfItems() + getCurretNumberOfItems());
            whichPutIninStackItem.setOwner(true);
            whichPutIninStackItem.setNameInContainer(getNameContainer());
            System.out.println("Предмет " + "'" + whichPutIninStackItem.getNameStack() + "'" + " добавлен в " + getNameContainer());
        } else if (futureWeight > getTotalWeight()) {
            throw new ItemStoreException("Failed to save object");
        } else if (whichPutIninStackItem.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }


    }

    public Item getItem() {
        if (!listItems.isEmpty()) {
            if (listItems.get(0).getClass() == Item.class) {
                Item item = listItems.get(0);
                this.curretNumberOfItems = curretNumberOfItems - 1;
                this.curretWeight = getCurretWeight() - item.getWeightItem();
                item.setOwner(false);
                item.setNameContainer("Null");
                System.out.println("Вытащили объект:" + item.getNameItem());

                return listItems.remove(0);
            } else if (listItems.get(0).getClass() == Stack.class) {


                Stack item = (Stack) listItems.get(0);
                this.curretWeight = getCurretWeight() - item.getWeightItem();
                this.curretNumberOfItems = curretNumberOfItems - 1;
                item.setOwner(false);
                item.setNameInContainer("Null");
                System.out.println("Вытащили объект:" + item.getNameStack());
                return listItems.remove(0);
            } else if (listItems.get(0).getClass() == Box.class) {


                Box item = (Box) listItems.get(0);
                this.curretWeight = getCurretWeight() - item.getCurretWeight();
                this.curretNumberOfItems = curretNumberOfItems - 1;
                item.setOwner(false);
                item.setNameInContainer("Null");
                System.out.println("Вытащили объект:" + item.getNameContainer());
                return listItems.remove(0);
            }

        } else
            System.out.println("Контейнер пуст!");
        return null;
    }

    @Override
    public void getInfo() {
        System.out.println(getNameContainer() + " " + getCurretWeight() + "кг");
    }

    @Override
    public void getInfoContainer() {
        this.listItems.forEach(System.out::println);
    }

    public int getMaxNumberOfItems() {
        return maxNumberOfItems;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public String getNameContainer() {
        return nameContainer;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public int getCurretNumberOfItems() {
        return curretNumberOfItems;
    }

    public void setCurretNumberOfItems(int curretNumberOfItems) {
        this.curretNumberOfItems = curretNumberOfItems;
    }

    public String getNameInContainer() {
        return nameInContainer;
    }

    public void setNameInContainer(String nameInContainer) {
        this.nameInContainer = nameInContainer;
    }

    public int getCurretWeight() {
        return this.curretWeight;
    }

    public void setCurretWeight(int curretWeight) {
        this.curretWeight = curretWeight;
    }

    public boolean isTypeFlat() {
        return typeFlat;
    }

    @Override
    public String toString() {
        return "BoxItems{" +
                "maxNumberOfItems=" + maxNumberOfItems +
                ", totalWeight=" + totalWeight +
                ", nameContainer='" + nameContainer + '\'' +
                ", nameInContainer='" + nameInContainer + '\'' +
                ", curretWeight=" + curretWeight +
                ", curretNumberOfItems=" + curretNumberOfItems +
                ", owner=" + owner +
                ", listItems=" + listItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return maxNumberOfItems == box.maxNumberOfItems &&
                totalWeight == box.totalWeight &&
                curretWeight == box.curretWeight &&
                curretNumberOfItems == box.curretNumberOfItems &&
                owner == box.owner &&
                Objects.equals(nameContainer, box.nameContainer) &&
                Objects.equals(nameInContainer, box.nameInContainer) &&
                Objects.equals(listItems, box.listItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxNumberOfItems, totalWeight, nameContainer, nameInContainer, curretWeight, curretNumberOfItems, owner, listItems);
    }
}
