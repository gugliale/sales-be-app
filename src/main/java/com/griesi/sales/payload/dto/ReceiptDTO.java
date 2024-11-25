package com.griesi.sales.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -308030833719171575L;

    private List<ArticleDTO> articles;
    private double totalTaxes;
    private double total;

}
