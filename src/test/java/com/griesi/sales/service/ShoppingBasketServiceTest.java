package com.griesi.sales.service;

import com.griesi.sales.payload.dto.ArticleDTO;
import com.griesi.sales.payload.dto.ReceiptDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ShoppingBasketServiceTest {

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @Test
    @DisplayName("Test for first articles list")
    void test_CalculateReceiptForFirstArticlesList() {
        List<ArticleDTO> articles = Arrays.asList(
                new ArticleDTO("book", 12.49, 2, false, true),
                new ArticleDTO("music CD", 14.99, 1, false, false),
                new ArticleDTO("chocolate bar", 0.85, 1, false, true)
        );

        ReceiptDTO receipt = shoppingBasketService.calculateReceipt(articles);

        assertThat(receipt).isNotNull();
        assertEquals(1.50, receipt.getTotalTaxes(), 0.001);
        assertEquals(42.32, receipt.getTotal(), 0.001);
    }

    @Test
    @DisplayName("Test for second articles list")
    void test_CalculateReceiptForSecondArticlesList() {
        List<ArticleDTO> articles = Arrays.asList(
                new ArticleDTO("imported box of chocolates", 10.00, 1, true, true),
                new ArticleDTO("imported bottle of perfume", 47.50, 1, true, false)
        );

        ReceiptDTO receipt = shoppingBasketService.calculateReceipt(articles);

        assertEquals(7.65, receipt.getTotalTaxes(), 0.001);
        assertThat(receipt.getTotal()).isEqualTo(65.15);
        assertEquals(65.15, receipt.getTotal(), 0.001);
        assertThat(receipt.getTotalTaxes()).isEqualTo(7.65);
    }

    @Test
    @DisplayName("Test for third articles list")
    void test_CalculateReceiptForThirdArticlesList() {
        List<ArticleDTO> articles = Arrays.asList(
                new ArticleDTO("imported bottle of perfume", 27.99, 1, true, false),
                new ArticleDTO("bottle of perfume", 18.99, 1, false, false),
                new ArticleDTO("packet of headache pills", 9.75, 1, false, true),
                new ArticleDTO("imported box of chocolates", 11.25, 3, true, true)
        );

        ReceiptDTO receipt = shoppingBasketService.calculateReceipt(articles);

        assertThat(receipt.getArticles().size()).isEqualTo(4);
        assertThat(receipt.getArticles()).extracting(ArticleDTO::getProductName).containsAnyOf("imported box of chocolates");
        assertEquals(7.90, receipt.getTotalTaxes(), 0.001);
        assertEquals(98.38, receipt.getTotal(), 0.001);

    }

}
