package com.FacutraExpress.apiFactura.Repository;

import com.FacutraExpress.apiFactura.Models.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Item, Long> {

    @Query(value = "select * from items where id_bill = ?1", nativeQuery = true)
    List<Item> findAllByIdBill(Long idBill);
}
