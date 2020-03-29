package task1.itembase;

import task1.exeptions.ItemAlreadyPlacedException;
import task1.exeptions.ItemStoreException;
import task1.general.Items;

import java.util.List;
import java.util.Objects;

public class BoxItems extends Items {
    private final int maxNumberOfItems;
    private final int totalWeight;
    private final String nameContainer;
    private String nameInContainer;
    private int curretWeight;
    private int curretNumberOfItems = 0;
    private boolean owner = false;

    private List<Items> listItems;

    public BoxItems(List<Items> listItems, int maxNumberOfItems, int totalWeight, String nameContainer, int curretWeight) {
        this.maxNumberOfItems = maxNumberOfItems;
        this.totalWeight = totalWeight;
        this.nameContainer = nameContainer;
        this.curretWeight = curretWeight;
        this.listItems = listItems;
    }

    public void addItemToContainer(ItemImplementation item) throws ItemAlreadyPlacedException, ItemStoreException {
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


    public void addItemToContainer(BoxItems whichPutIninBoxItem) throws ItemAlreadyPlacedException, ItemStoreException {


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

    public void addItemToContainer(StackItems whichPutIninStackItem) throws ItemAlreadyPlacedException, ItemStoreException {


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

    public void getItem() {
        if (listItems.size() > 0) {
            if (listItems.get(0).getClass() == ItemImplementation.class) {
                ItemImplementation item = (ItemImplementation) listItems.get(0);
                listItems.remove(item);
                this.curretNumberOfItems = curretNumberOfItems - 1;
                item.setOwner(false);
                item.setNameContainer("Null");
                System.out.println("Вытащили объект:" + item.getNameItem());
            } else if (listItems.get(0).getClass() == StackItems.class) {


                StackItems item = (StackItems) listItems.get(0);
                listItems.remove(item);
                this.curretNumberOfItems = curretNumberOfItems - 1;
                item.setOwner(false);
                item.setNameInContainer("Null");
                System.out.println("Вытащили объект:" + item.getNameStack());
            } else if (listItems.get(0).getClass() == BoxItems.class) {


                BoxItems item = (BoxItems) listItems.get(0);
                listItems.remove(item);
                this.curretNumberOfItems = curretNumberOfItems - 1;
                item.setOwner(false);
                item.setNameInContainer("Null");
                System.out.println("Вытащили объект:" + item.getNameContainer());
            }

        }else {
            System.out.println("Контейнер пуст!");
        }
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
        return curretWeight;
    }

    public void setCurretWeight(int curretWeight) {
        this.curretWeight = curretWeight;
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
        BoxItems boxItems = (BoxItems) o;
        return maxNumberOfItems == boxItems.maxNumberOfItems &&
                totalWeight == boxItems.totalWeight &&
                curretWeight == boxItems.curretWeight &&
                curretNumberOfItems == boxItems.curretNumberOfItems &&
                owner == boxItems.owner &&
                Objects.equals(nameContainer, boxItems.nameContainer) &&
                Objects.equals(nameInContainer, boxItems.nameInContainer) &&
                Objects.equals(listItems, boxItems.listItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxNumberOfItems, totalWeight, nameContainer, nameInContainer, curretWeight, curretNumberOfItems, owner, listItems);
    }
}
