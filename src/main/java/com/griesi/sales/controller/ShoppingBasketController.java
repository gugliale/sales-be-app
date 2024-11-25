package com.griesi.sales.controller;

import com.griesi.sales.payload.dto.ArticleDTO;
import com.griesi.sales.payload.dto.ReceiptDTO;
import com.griesi.sales.service.ShoppingBasketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/carrello")
public class ShoppingBasketController {

    @Autowired
    private ShoppingBasketService shoppingBasketService;

    @PostMapping
    @Operation(summary = "Calculate shopping cart taxes and produce receipt")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Receipt retrieved successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReceiptDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input provided") })
    public ResponseEntity<Object> retrieveReceipt(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Articles to process", required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ArticleDTO.class),
                    examples = @ExampleObject(
                            value = "[{ \"productName\": \"Book\", \"price\": \"12.49\", \"quantity\": \"2\", " +
                                    " \"isImported\": \"false\", \"isExempt\": \"true\" }]")))
            @Valid @RequestBody List<ArticleDTO> articleDTO) {

         if(articleDTO.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input provided");
        ReceiptDTO responseBody = shoppingBasketService.calculateReceipt(articleDTO);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);

    }

}
