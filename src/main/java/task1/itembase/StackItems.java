package task1.itembase;

import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.general.Container;
import task1.lists.ListProperties;

import java.util.*;

public class StackItems implements Container {
    private final int maxNumberOfItems;
    private final String nameStackItem;
    private final String type = "bag";
    private int curretNumberOfItems;
    private final boolean flat = true;
    private boolean owner = false;
    private Deque<StackItems> listStack;
    private Deque<ItemImplementation> listItems;
    private String nameInContainer;

    public StackItems(Deque<ItemImplementation> listItems, String nameStackItem,
                      int curretNumberOfItems, int maxNumberOfItems) {
        this.listItems = listItems;
        this.nameStackItem = nameStackItem;
        this.curretNumberOfItems = curretNumberOfItems;
        this.maxNumberOfItems = maxNumberOfItems;
    }

    private void setNameInContainer(String nameInContainer) {
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

    public void addItemToContainer(ItemImplementation item) throws ItemAlreadyPlacedException, ItemStoreException {

        boolean itemProperties = item.getAdditionalPropertiesItem().contains(ListProperties.FLAT.getPropertoies());
        int futureNumberOfItems = curretNumberOfItems + 1;
        if (itemProperties && futureNumberOfItems <= getMaxNumberOfItems() && !item.isOwner()) {

            listItems.addFirst(item);
            item.setOwner(true);
            item.setNameContainer(getNameStack());
            System.out.println("Предмет " + "'" + item.getNameItem() + "'" + " добавлен в " + getNameStack());
            this.curretNumberOfItems = curretNumberOfItems + 1;
        } else if (!itemProperties) {
            System.err.println("Предмет " + "'" + item.getNameItem() + "'" + " нельзя положить в " + "контейнер " + getNameStack());
        } else if (this.curretNumberOfItems > this.maxNumberOfItems || futureNumberOfItems > maxNumberOfItems) {
            throw new ItemStoreException("Failed to save object");
        } else if (item.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }


    }

    @Override
    public void getInfoContainer() {
        this.listItems.forEach(System.out::println);
        // this.listStack.forEach(System.out::println);
    }
    public String getNameStack() {
        return nameStackItem;
    }

    public String getType() {
        return type;
    }

    public void getItem() {
        if (listItems.size() > 0) {
            ItemImplementation item = listItems.peek();
            listItems.remove(item);
            this.curretNumberOfItems = curretNumberOfItems - 1;
            item.setOwner(false);
            item.setNameContainer("Null");
            System.out.println("Вытащили объект:" + item.getNameItem());
        }
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

    public void addStackToStack(StackItems whichPutIninstackItems) throws ItemStoreException, ItemAlreadyPlacedException {


        boolean stackProperties = whichPutIninstackItems.isFlat();
        int futureNumberOfItems = curretNumberOfItems + whichPutIninstackItems.getCurretNumberOfItems() + 1;
        if (stackProperties && futureNumberOfItems <= getMaxNumberOfItems() && !whichPutIninstackItems.isOwner()) {

            listStack.addFirst(whichPutIninstackItems);
            whichPutIninstackItems.setOwner(true);
            whichPutIninstackItems.setNameInContainer(getNameStack());
            System.out.println("Предмет " + "'" + whichPutIninstackItems.getNameStack() + "'" + " добавлен в " + getNameStack());
            this.curretNumberOfItems = curretNumberOfItems + 1;
        } else if (!isFlat()) {
            System.err.println("Предмет " + "'" + whichPutIninstackItems.getNameStack() + "'" + " нельзя положить в " + "контейнер " + getNameStack());
        } else if (this.curretNumberOfItems > this.maxNumberOfItems || futureNumberOfItems > maxNumberOfItems) {
            throw new ItemStoreException("Failed to save object");
        } else if (whichPutIninstackItems.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }


    }

    @Override
    public String toString() {
        return "StackItems{" +
                "maxNumberOfItems=" + maxNumberOfItems +
                ", curretNumberOfItems=" + curretNumberOfItems +
                ", listItems=" + listItems +
                '}';
    }
}
