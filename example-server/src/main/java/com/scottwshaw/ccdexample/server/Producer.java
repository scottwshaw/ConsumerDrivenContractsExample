package com.scottwshaw.ccdexample.server;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.get;
/**
 * Created by sshaw on 6/12/2015.
 */
public class Producer {
    static class Sale {
        public Date date;
        public String item;
        public String price;
        Sale(Date d, String i, String p) {
            date = d;
            item = i;
            price = p;
        }
    }
    public static void main(String[] args) {
        Map model = new HashMap();
        List<Sale> sales = Arrays.asList(
                new Sale(new Date(), "first", "$29.95"),
                new Sale(new Date(), "second", "$2"),
                new Sale(new Date(), "third", "$999.99")
        );
        model.put("sales",sales);
        get("/sales",
                (req, res) -> new ModelAndView(model, "root.hbs"),
                new HandlebarsTemplateEngine());
    }
}
