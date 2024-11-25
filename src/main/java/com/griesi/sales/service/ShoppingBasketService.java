package com.griesi.sales.service;

import com.griesi.sales.payload.dto.ArticleDTO;
import com.griesi.sales.payload.dto.ReceiptDTO;
import com.griesi.sales.utils.TaxUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingBasketService {

    private static final double BASIC_TAX_RATE = 0.10;
    private static final double IMPORT_TAX_RATE = 0.05;

    public ReceiptDTO calculateReceipt(List<ArticleDTO> listArticle) {

        double totalTaxes = 0;
        double total = 0;

        for (ArticleDTO ar : listArticle) {
            double tax = calculateTax(ar);
            System.out.println("Item: " + ar.getProductName());
            System.out.println("Tax per item: " + tax);
            double itemTotal = (ar.getPrice() + tax) * ar.getQuantity();
            System.out.println("Item total: " + itemTotal);
            totalTaxes += tax * ar.getQuantity();
            System.out.println("Running total taxes: " + totalTaxes);
            total += itemTotal;
            System.out.println("Running total: " + total);
            System.out.println("Item: " + ar.getProductName() + ", isExempt: " + ar.isExempt());
            System.out.println("-------------------");

        }

        return new ReceiptDTO(listArticle, TaxUtils.round(totalTaxes), TaxUtils.round(total));

    }

    public static double calculateTax(ArticleDTO article) {

        double tax = 0;

        if (!article.isExempt()) {
            tax += article.getPrice() * BASIC_TAX_RATE;
        }

        if (article.isImported()) {
            tax += article.getPrice() * IMPORT_TAX_RATE;
        }

        return TaxUtils.roundingUp(tax);

    }

}
