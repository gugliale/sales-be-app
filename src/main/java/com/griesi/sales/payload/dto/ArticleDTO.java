package com.griesi.sales.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8896596645566129297L;

    @NotEmpty(message = "Nome prodotto non fornito")
    private String productName;
    private double price;
    @Min(value = 1, message = "Ci deve essere almeno un prodotto")
    private int quantity;
    @JsonProperty("isImported")
    private boolean isImported;
    @JsonProperty("isExempt")
    private boolean isExempt;

}
