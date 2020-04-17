package task.laba1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;


public class Bag extends AbstractContainer {
    private final int totalWeight;
    private final boolean typeFlat = false;
    public final String nameContainer;
    private String nameInContainer;
    private boolean owner = false;
    private int curretWeight;
    private List<Item> listItems;
    private int id;

    public Bag(List<Item> listItems, String nameContainer, int totalWeight) {
        super();
        this.listItems = listItems;
        this.nameContainer = nameContainer;
        this.totalWeight = totalWeight;
        this.id = (int) (0 + Math.random() * 100);
        if (listItems.isEmpty()) {
            for (Item list : listItems) {
                curretWeight = curretWeight + list.getWeightItem();
            }
        }
        curretWeight = 0;

    }

    public Bag(String nameContainer, int totalWeight) {
        super();
        this.listItems = new ArrayList<>();
        this.curretWeight = 0;
        this.nameContainer = nameContainer;
        this.totalWeight = totalWeight;
        this.id = (int) (0 + Math.random() * 100);
    }


    private Item randomItem() {
        List<Item> mainList = new ArrayList<>();
        mainList.addAll(listItems);
        int startNumber = 0;
        int random_number = startNumber + (int) (Math.random() * listItems.size());
        if (random_number > startNumber) {

            return mainList.get(random_number);
        } else {
            return mainList.get(startNumber);
        }
    }

    public boolean isTypeFlat() {
        return typeFlat;
    }

    private void setCurretWeight(int curretWeight) {
        this.curretWeight = curretWeight;
    }

    @Override
    void setOwnerContainer(boolean owner) {
        this.owner = owner;
    }


    public String getNameContainer() {
        return nameContainer;
    }

    private void setNameInContainer(String nameInContainer) {
        this.nameInContainer = nameInContainer;
    }

    public String getNameInContainer() {
        return nameInContainer;
    }

    public boolean isOwner() {
        return owner;
    }

    @Override
    public void addItemToContainer(Item item) throws ItemAlreadyPlacedException, ItemStoreException {

        int futureWeight = curretWeight + item.getWeightItem();
        if (futureWeight <= totalWeight && !item.isOwner()) {
            listItems.add(item);
            item.setOwner(true);
            item.setNameContainer(getNameContainer());
            System.out.println("Предмет" + "'" + item.getNameItem() + "'" + " добавлен в " + getNameContainer());
            this.curretWeight = curretWeight + item.getWeightItem();

        } else if (this.curretWeight > this.totalWeight || futureWeight > totalWeight) {
            throw new ItemStoreException("Failed to save object");

        } else if (item.isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }


    }


    public void addItemToContainer(Bag whichPutInnBagItem) throws ItemAlreadyPlacedException, ItemStoreException {

        int futureWeight = whichPutInnBagItem.getCurretWeight() + getCurretWeight();
        if (whichPutInnBagItem.id != (id) && !whichPutInnBagItem.isOwner() && futureWeight <= getTotalWeight()) {
            int curretWeightTemp;
            curretWeightTemp = getCurretWeight() + whichPutInnBagItem.getCurretWeight();
            setCurretWeight(curretWeightTemp);
            listItems.add(whichPutInnBagItem);
            System.out.println("Контейнер" + "'" + whichPutInnBagItem.getNameContainer() + "'" + " добавлен в " + getNameContainer());
            whichPutInnBagItem.setOwnerContainer(true);
            whichPutInnBagItem.setNameInContainer(getNameContainer());

        } else if (this.curretWeight > this.totalWeight || futureWeight > totalWeight) {
            throw new ItemStoreException("Failed to save object");

        } else if (isOwner()) {
            throw new ItemAlreadyPlacedException("Item is already in another container ");
        }

    }

    public Item getItemByName(String itemName) {
        for (Item item : listItems) {
            if (item.getName().equals(itemName) && item.getClass().equals(Item.class)) {
                Item curretItem = item;
                getItem(curretItem);
                return curretItem;
            } else if (item.getName().equals(itemName) && item.getClass().equals(Bag.class)) {
                Bag curretItem = (Bag) item;
                getItem(curretItem);
                return curretItem;
            }
        }
        System.out.println(itemName + " не найден");
        return null;
    }


    public void getItem(Item item) {

        if (listItems.size() > 0 && listItems.contains(item)) {
            this.curretWeight = curretWeight - item.getWeightItem();
            listItems.remove(item);
            item.setOwner(false);
            item.setNameContainer("Null");
            System.out.println("Вытащили объект:" + item.getNameItem());
        } else if (!listItems.contains(item)) {
            System.err.println("Данного объекта нет в контейнере");
        }
    }

    public Bag getItem(Bag bagItem) {

        if (listItems.size() > 0 && listItems.contains(bagItem)) {
            this.curretWeight = curretWeight - bagItem.getCurretWeight();
            listItems.remove(bagItem);
            bagItem.setOwnerContainer(false);
            bagItem.setNameInContainer("Null");
            System.out.println("Вытащили объект:" + bagItem.getNameContainer());
            return bagItem;
        } else if (!listItems.contains(bagItem)) {
            System.err.println("Данного объекта нет в контейнере");
            return null;
        }
        return null;
    }

    public void getRandomItem() {

        if (!listItems.isEmpty()) {
            Item randomItemOf = randomItem();
            if (randomItemOf.getClass().equals(Bag.class)) {
                Bag randomItem = (Bag) randomItemOf;
                this.curretWeight = curretWeight - randomItem.getCurretWeight();
                randomItem.setOwnerContainer(false);
                randomItem.setNameInContainer("Null");
                listItems.remove(randomItem);

                System.out.println("Вытащили объект:" + randomItem.getNameContainer());
            } else {
                Item randomItem = randomItemOf;

                this.curretWeight = curretWeight - randomItem.getWeightItem();
                randomItem.setOwner(false);
                randomItem.setNameContainer("Null");
                listItems.remove(randomItem);

                System.out.println("Вытащили объект:" + randomItem.getNameItem());
            }
        } else if (listItems.isEmpty()) {
            System.err.println("Контейнер пуст");
        }
    }


    public String getName() {
        return getNameContainer();
    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    @Override
    public int getCurretWeight() {
        return this.curretWeight;
    }


    @Override
    public void getInfoContainer() {
        this.listItems.forEach(System.out::println);
    }

    public List<Item> getListFromContainer() {
        return listItems;
    }

    @Override
    public String toString() {
        return "BagItems{" +
                "totalWeight=" + totalWeight +
                ", nameContainer='" + nameContainer + '\'' +
                ", nameInContainer='" + nameInContainer + '\'' +
                ", owner=" + owner +
                ", curretWeight=" + curretWeight +
                ", listItems=" + listItems +
                '}';
    }


    public void getInfo() {
        System.out.println("Наименование контейнера " + getNameContainer() + ", Максимальный вес  " + getTotalWeight() + ", Текущий вес " + getCurretWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bag bag = (Bag) o;
        return totalWeight == bag.totalWeight &&
                owner == bag.owner &&
                curretWeight == bag.curretWeight &&
                Objects.equals(nameContainer, bag.nameContainer) &&
                Objects.equals(nameInContainer, bag.nameInContainer) &&
                Objects.equals(listItems, bag.listItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalWeight, nameContainer, nameInContainer, owner, curretWeight, listItems);
    }
}




