package com.lozyukartem.vegetarianrestaurant.menu.util;

import com.lozyukartem.vegetarianrestaurant.salad.Salad;
import com.lozyukartem.vegetarianrestaurant.vegetable.Vegetable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuHandler extends DefaultHandler {

    private static final String SALAD = "salad";
    private static final String VEGETABLE = "vegetable";

    private List<Salad> menu = null;
    private String currentTag = null;
    private Salad salad = null;
    private Vegetable vegetable = null;

    public MenuHandler() {
        menu = new ArrayList<>();
    }

    public List<Salad> getMenu() {
        return menu;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (localName) {
            case SALAD:
                salad = new Salad();
                salad.setName(attributes.getValue(0));
                break;
        }

        currentTag = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (localName) {
            case SALAD:
                menu.add(salad);
                break;
            case VEGETABLE:
                salad.addIngredient(vegetable);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if (value.isEmpty()) {
            return;
        }

        switch (currentTag) {
            case VEGETABLE:
                vegetable = Vegetable.valueOf(value);
                break;
        }
    }
}
