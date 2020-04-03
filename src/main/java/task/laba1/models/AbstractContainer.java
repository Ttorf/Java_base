package task.laba1.models;

import task.laba1.exceptions.ItemAlreadyPlacedException;
import task.laba1.exceptions.ItemStoreException;

public abstract class AbstractContainer  extends  Item{

    public abstract void getInfoContainer();

    abstract public void addItemToContainer(Item item) throws ItemAlreadyPlacedException, ItemStoreException;
}
