package com.FacutraExpress.apiFactura.Controllers;

import com.FacutraExpress.apiFactura.Models.Entities.Item;
import com.FacutraExpress.apiFactura.Service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemsController {
    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("{idBill}")
    public ResponseEntity<List<Item>> getItemsWhitIdBill(@PathVariable Long idBill){
        return new ResponseEntity<>(itemService.getItemWhitIdBill(idBill), HttpStatus.OK);
    }

    @GetMapping("total/{idBill}")
    public ResponseEntity<Double> getTotalItems(@PathVariable Long idBill){
        return new ResponseEntity<>(itemService.getTotalItems(idBill), HttpStatus.OK);
    }
}
