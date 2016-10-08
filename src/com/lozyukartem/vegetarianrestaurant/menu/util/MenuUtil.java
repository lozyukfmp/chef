package com.lozyukartem.vegetarianrestaurant.menu.util;

import com.lozyukartem.vegetarianrestaurant.salad.Salad;
import com.lozyukartem.vegetarianrestaurant.vegetable.Vegetable;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class MenuUtil {

    private static final String menuFilename = "menu.xml";

    private MenuUtil() {}

    public static Map<String, Salad> getSalads() {
        MenuHandler menuHandler = new MenuHandler();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(menuHandler);
            reader.parse(menuFilename);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return menuHandler.getMenu();
    }

    public static double getSaladCalories(Salad salad) {
        return salad.getVegetableList().stream().mapToDouble(vegetable -> vegetable.getCalories()).sum();
    }

    public static List<Vegetable> getSortedByCaloriesVegetableList(Salad salad) {
        List<Vegetable> result = salad.getVegetableList();
        result.sort((value1, value2) -> Double.compare(value1.getCalories(),value2.getCalories()));

        return result;
    }

    public static List<Vegetable> getSortedByFatsVegetableList(Salad salad) {
        List<Vegetable> result = salad.getVegetableList();
        result.sort((value1, value2) -> Double.compare(value1.getFats(), value2.getFats()));

        return result;
    }

    public static List<Vegetable> getSortedByProteinsVegetableList(Salad salad) {
        List<Vegetable> result = salad.getVegetableList();
        result.sort((value1, value2) -> Double.compare(value1.getProteins(), value2.getProteins()));

        return result;
    }

    public static List<Vegetable> getSortedByCarbohydratesVegetableList(Salad salad) {
        List<Vegetable> result = salad.getVegetableList();
        result.sort((value1, value2) -> Double.compare(value1.getCarbohydrates(), value2.getCarbohydrates()));

        return result;
    }

}
