package com.lozyukartem.vegetarianrestaurant.menu.util;

import com.lozyukartem.vegetarianrestaurant.menu.Menu;
import com.lozyukartem.vegetarianrestaurant.salad.Salad;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public final class MenuUtil {

    private static final String menuFilename = "menu.xml";

    private MenuUtil() {}

    public static List<Salad> loadSaladList() {
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

    public static Salad findSalad(Menu menu, String saladName) {
        return menu.getSalads()
                .stream()
                .filter(salad1 -> salad1.getName().equals(saladName))
                .findFirst()
                .orElse(null);
    }
}
