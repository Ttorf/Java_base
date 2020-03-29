package task1.itembase;

import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.general.Items;
import task1.lists.ListProperties;

import java.util.*;

public class StackItems extends Items {
    private final int maxNumberOfItems;
    private final String nameStackItem;
    private int curretNumberOfItems;
    private final static boolean flat = true;
    private boolean owner = false;
    private int curretWeight = 0;
    private Deque<Items> listItems;
    private String nameInContainer;

    public StackItems(Deque<Items> listItems, String nameStackItem,
                      int curretNumberOfItems, int maxNumberOfItems) {
        this.listItems = listItems;
        this.nameStackItem = nameStackItem;
        this.curretNumberOfItems = curretNumberOfItems;
        this.maxNumberOfItems = maxNumberOfItems;
    }

    public void setNameInContainer(String nameInContainer) {
        this.nameInContainer = nameInContainer;
    }


    public int getMaxNumberOfItems() {
        return maxNumberOfItems;
    }

    public int getCurretNumberOfItems() {
        return curretNumberOfItems;
    }

    public String getNameInContainer() {
        return nameInContainer;
    }

    public void setCurretNumberOfItems(int curretNumberOfItems) {
        this.curretNumberOfItems = curretNumberOfItems;
    }

    public void addItemToContainer(ItemImplementation item) throws ItemAlreadyPlacedException, ItemStoreException {

        boolean itemProperties = item.getAdditionalPropertiesItem().contains(ListProperties.FLAT.getPropertoies());
        int futureNumberOfItems = curretNumberOfItems + 1;
        if (itemProperties && futureNumberOfItems <= getMaxNumberOfItems() && !item.isOwner()) {
            listItems.addLast(item);
            System.out.println("Предмет " + "'" + item.getNameItem() + "'" + " добавлен в " + getNameStack());
            setCurretWeight(item.getWeightItem() + getCurretWeight());
            item.setOwner(true);
            item.setNameContainer(getNameStack());
            setCurretNumberOfItems(getCurretNumberOfItems() + 1);
        } else if (!itemProperties) {
            System.err.println("Предмет " + "'" + item.getNameItem() + "'" + " нельзя положить в " + "контейнер " + getNameStack());
        } else if (futureNumberOfItems > getMaxNumberOfItems()) {
            throw new ItemStoreException("Failed to save object");
        } else if (item.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }


    }


    public void getItem() {

        if (listItems.size() > 0) {
            if (listItems.getFirst().getClass().equals(ItemImplementation.class)) {
                ItemImplementation item = (ItemImplementation) listItems.peek();
                listItems.remove(item);
                setCurretWeight(getCurretWeight() - item.getWeightItem());
                this.curretNumberOfItems = curretNumberOfItems - 1;
                item.setOwner(false);
                item.setNameContainer("Null");
                System.out.println("Вытащили объект:" + item.getNameItem());
            } else if (listItems.getLast().getClass().equals(BoxItems.class)) {

                BoxItems item = (BoxItems) listItems.peek();
                listItems.remove(item);
                setCurretWeight(getCurretWeight() - item.getCurretWeight());
                this.curretNumberOfItems = curretNumberOfItems - 1;
                item.setOwner(false);
                item.setNameInContainer("Null");
                System.out.println("Вытащили объект:" + item.getNameContainer());
            }

        }
    }


    public void getInfoContainer() {
        this.listItems.forEach(System.out::println);

    }

    public String getNameStack() {
        return nameStackItem;
    }

    public boolean isFlat() {
        return flat;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public int getCurretWeight() {
        return curretWeight;
    }

    public void setCurretWeight(int curretWeight) {
        this.curretWeight = curretWeight;
    }


    public void addBoxToStack(BoxItems whichPutIniBoxItems) throws ItemStoreException, ItemAlreadyPlacedException {

        int futureNumberOfItems = getCurretNumberOfItems() + 1;

        if (futureNumberOfItems <= getMaxNumberOfItems() && !whichPutIniBoxItems.isOwner()) {
            setCurretWeight(getCurretWeight() + whichPutIniBoxItems.getCurretWeight());
            listItems.addFirst(whichPutIniBoxItems);
            whichPutIniBoxItems.setOwner(true);
            whichPutIniBoxItems.setNameInContainer(getNameStack());
            setCurretNumberOfItems(getCurretNumberOfItems() + 1);
            System.out.println("Предмет " + "'" + whichPutIniBoxItems.getNameContainer() + "'" + " добавлен в " + getNameStack());
        } else if (!isFlat()) {
            System.err.println("Предмет " + "'" + whichPutIniBoxItems.getNameContainer() + "'" + " нельзя положить в " + "контейнер " + getNameStack());
        } else if (futureNumberOfItems > getMaxNumberOfItems()) {
            throw new ItemStoreException("Failed to save object ");

        } else if (whichPutIniBoxItems.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }


    }

    @Override
    public String getName() {
        return getNameStack();
    }

    @Override
    public void getInfo() {
        System.out.println("Наименование контейнера " + getNameStack() + ", Максимальное количество предметов  " + getMaxNumberOfItems() + ", Текущее количество предметов " + getCurretNumberOfItems());
    }

    @Override
    public String toString() {
        return "StackItems{" +
                "maxNumberOfItems=" + maxNumberOfItems +
                ", curretNumberOfItems=" + curretNumberOfItems +
                ", listItems=" + listItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackItems that = (StackItems) o;
        return maxNumberOfItems == that.maxNumberOfItems &&
                curretNumberOfItems == that.curretNumberOfItems &&
                owner == that.owner &&
                curretWeight == that.curretWeight &&
                Objects.equals(nameStackItem, that.nameStackItem) &&
                Objects.equals(listItems, that.listItems) &&
                Objects.equals(nameInContainer, that.nameInContainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxNumberOfItems, nameStackItem, curretNumberOfItems, owner, curretWeight, listItems, nameInContainer);
    }
}
