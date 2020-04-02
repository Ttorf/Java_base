package task1.models;

import task1.exceptions.ItemAlreadyPlacedException;
import task1.exceptions.ItemStoreException;

public abstract class AbstractContainer  extends  Item{

    public abstract void getInfoContainer();

    abstract public void addItemToContainer(Item item) throws ItemAlreadyPlacedException, ItemStoreException;
}
