package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Entities.Item;
import com.FacutraExpress.apiFactura.Repository.ItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> getItemWhitIdBill(Long idBill) {
        return itemsRepository.findAllByIdBill(idBill);
    }


    public Double getTotalItems(Long idBill){
        List<Item> items = itemsRepository.findAllByIdBill(idBill);
        double total = (double) 0;
        for (Item item: items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}
