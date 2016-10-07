package com.lozyukartem.vegetarianrestaurant.menu.util;

import com.lozyukartem.vegetarianrestaurant.salad.Salad;
import com.lozyukartem.vegetarianrestaurant.vegetable.Vegetable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class MenuHandler extends DefaultHandler {

    private static final String SALAD = "salad";
    private static final String INGREDIENT = "ingredient";
    private static final String PORTION = "portion";
    private static final String VEGETABLE = "vegetable";

    private Map<String, Salad> menu = null;
    private Map<Vegetable, Integer> ingredients = null;
    private int portion;
    private String currentTag = null;
    private Salad salad = null;
    private Vegetable vegetable = null;

    public MenuHandler() {
        menu = new HashMap<>();
    }

    public Map<String, Salad> getMenu() {
        return menu;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (localName) {
            case SALAD:
                salad = new Salad();
                ingredients = new HashMap<>();
                salad.setName(attributes.getValue(0));
                break;
            case PORTION:
                currentTag = PORTION;
                break;
            case VEGETABLE:
                currentTag = VEGETABLE;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (localName) {
            case SALAD:
                menu.put(salad.getName(), salad);
                break;
            case INGREDIENT:
                ingredients.put(vegetable, portion);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (currentTag) {
            case VEGETABLE:
                vegetable = Vegetable.valueOf(ch.toString());
                break;
            case PORTION:
                portion = Integer.parseInt(ch.toString());
                break;
        }
    }
}
