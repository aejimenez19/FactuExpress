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
}
