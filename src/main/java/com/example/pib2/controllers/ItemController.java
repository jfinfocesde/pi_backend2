package com.example.pib2.controllers;

import com.example.pib2.models.dtos.ItemDTO;
import com.example.pib2.models.entities.Item;
import com.example.pib2.servicios.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/items")

public class ItemController {
    @Autowired
    private ItemService itemService;

    private ItemDTO toDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        dto.setQuantity(item.getQuantity());
        return dto;
    }

    private Item toEntity(ItemDTO dto) {
        Item item = new Item();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setQuantity(dto.getQuantity());
        return item;
    }



    @GetMapping
    public List<ItemDTO> getAll() {
        return itemService.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }



    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getById(@PathVariable Long id) {
        return itemService.findById(id)
                .map(item -> ResponseEntity.ok(toDTO(item)))
                .orElse(ResponseEntity.notFound().build());
    }



    @PostMapping
    public ItemDTO create(@RequestBody ItemDTO itemDTO) {
        Item item = toEntity(itemDTO);
        return toDTO(itemService.save(item));
    }



    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> update(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        return itemService.findById(id)
                .map(existing -> {
                    itemDTO.setId(id);
                    Item updated = toEntity(itemDTO);
                    return ResponseEntity.ok(toDTO(itemService.save(updated)));
                })
                .orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (itemService.findById(id).isPresent()) {
            itemService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
