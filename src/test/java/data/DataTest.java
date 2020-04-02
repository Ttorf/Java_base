package data;

import task1.data.properties.ListProperties;
import task1.models.Bag;
import task1.models.Box;
import task1.models.Item;
import task1.models.Stack;

import java.util.*;

public class DataTest {
   public String nameBox1 = "пакет";
    public  String nameBox2 = "мешок";
    public String nameBox3 = "корзина";
    public  String nameItem1 = "кирпич";
    public String nameItem2 = "доска";
    public String nameItem3 = "блок";
    public  String nameItem4 = "верёвка";
    public  String nameItem5 = "лопата";
    public  String nameItem6 = "кирка";
    public  String nameStack = "стопка";
    public   int weightItem1 = 20;
    public  int weightItem2 = 90;
    public   int weightItem3 = 30;
    public   int weightItem4 = 10;
    public   int curretWeight1 = 2;
    public   int curretWeight2 = 2;
    public   int curretWeight3 = 0;
    public   int totalWeight = 100;
    public   int curretNumberOfItems = 18;
    public   int curretNumberOfItems2 = 1;
    public   int maxNumberOfItems = 20;
    public    ArrayList<Item> batList3 = new ArrayList<>();
    public    ArrayList<Item> batList2 = new ArrayList<>();
    public    ArrayList<Item> batList1 = new ArrayList<>();
    public    ArrayList<Item> listItems = new ArrayList<>();
    public   Deque<Item> ItemDeque = new ArrayDeque<>();
    public  Set<ListProperties> testPropertiesSetItem1 = new HashSet<>();
    public   Set<ListProperties> testPropertiesSetItem2 = new HashSet<>();
    public   Set<ListProperties> testPropertiesSetItem3 = new HashSet<>();
    public   Item materialBuild = new Item(nameItem1, testPropertiesSetItem1, weightItem1);
    public   Item materialBuild2 = new Item(nameItem2, testPropertiesSetItem2, weightItem2);
    public   Item materialBuild6 = new Item(nameItem6, testPropertiesSetItem2, weightItem4);
    public   Item materialBuild3 = new Item(nameItem3, testPropertiesSetItem2, weightItem3);
    public   Item materialBuild4 = new Item(nameItem4, testPropertiesSetItem3, weightItem4);
    public   Item materialBuild5 = new Item(nameItem5, testPropertiesSetItem3, weightItem4);
    public   Bag bagItem = new Bag(nameBox1,totalWeight);
    public   Bag bagItem2 = new Bag(nameBox2, totalWeight);
    public   Bag bagItem3 = new Bag(nameBox3, totalWeight);
    public   task1.models.Stack stack1 = new task1.models.Stack(ItemDeque, nameStack, curretNumberOfItems, maxNumberOfItems);
    public   task1.models.Stack stack2 = new Stack(ItemDeque, nameStack, curretNumberOfItems2, maxNumberOfItems);
    public   Box box = new Box(listItems, maxNumberOfItems, totalWeight, "Коробка картонная", curretWeight3);
    public   Box box2 = new Box(batList1, maxNumberOfItems, totalWeight, "Коробка пластиковая", curretWeight3);


 public void addProperties() {
  testPropertiesSetItem1.add(ListProperties.COLLORWHITE);
  testPropertiesSetItem2.add(ListProperties.HEAVY);
  testPropertiesSetItem2.add(ListProperties.FLAT);
  testPropertiesSetItem3.add(ListProperties.COLLORBLACK);
 }

}
