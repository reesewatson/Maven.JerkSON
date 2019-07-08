package io.zipcoder;

import io.zipcoder.ItemParser;
import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import java.util.ArrayList;
import java.util.List;

public class GroceryReporter {

    private final String originalFileText;
    private ItemParser parser;
    private List<Item> parsed;

    public GroceryReporter(String jerksonFileName) {

        originalFileText = FileReader.readFile(jerksonFileName);
        ItemParser parser = new ItemParser();
        List<Item> parsed = parser.parseItemList(originalFileText);
    }

    //Create a count method that will count up the amount of times an item is seen.
    public int nameCount(String name) {
        int count = 0;
        for (Item i : parsed) {
            if (i.getName().equals(name)) {
                count++;
            }
        } return count;
    }

    //Create a count method that will count up the amount of times an item's prices are seen.
    public int priceCount(Double price, String name) {
        int count = 0;
        for (Item i : parsed) {
            if (i.getName().equalsIgnoreCase(name) && i.getPrice().equals(price)) {
                count++;
            }
        } return count;
    }

    //Create a method that returns an arraylist containing all the instances of a certain item.
    public List<String> getSingleItemList(String name) {
        List<String> singleItemList = new ArrayList();
        for (Item i : parsed) {
            if (i.getName().equals(name)) {
                singleItemList.add(name);
            }
        } return singleItemList;
    }

    //Create a method that returns an arraylist containing all prices for a given item.
    public List<Double> getSingleItemPrices(String name) {
        List<Double> singleItemPrices = new ArrayList();
        for (Item i : parsed) {
            if (i.getName().equalsIgnoreCase(name)) {
                singleItemPrices.add(i.getPrice());
            }
        } return singleItemPrices;
    }

    public String priceString(String name) {
        String result = "";
        for (Double price : getSingleItemPrices(name)) {
              result += String.format("Price:  %.2f        seen:  %d times\n", price, priceCount(price, name));
              result += "-------------        -------------\n";
        } return result;
    }

    public String nameString(String name) {
        String result = "";
        for (String names : getSingleItemList(name)) {
            result += String.format("name:  %s        seen:  %d times\n", names, nameCount(names));
            result += "==============        =============\n";
        } return result;
    }

    public String nameAndPriceString() {

        return null;

    }

    @Override
    public String toString() {

        return null;
    }
}