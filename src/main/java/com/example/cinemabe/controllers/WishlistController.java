package com.example.cinemabe.controllers;

import com.example.cinemabe.models.WishList;
import com.example.cinemabe.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {
    @Autowired
    private WishlistService wishListService;

    @GetMapping
    public ResponseEntity<List<WishList>> getAllWishLists() {
        List<WishList> wishLists = wishListService.getAllWishlists();
        return ResponseEntity.ok(wishLists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<WishList>> getWishListById(@PathVariable Long id) {
        Optional<WishList> wishList = wishListService.getWishlistById(id);
        return ResponseEntity.ok(wishList);
    }

    @PostMapping
    public ResponseEntity<WishList> createWishList(@RequestBody WishList wishList) {
        WishList createdWishList = wishListService.saveWishlist(wishList);
        return ResponseEntity.ok(createdWishList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WishList> updateWishList(@PathVariable Long id, @RequestBody WishList wishList) {
        WishList updatedWishList = wishListService.updateWishlist(id, wishList);
        return ResponseEntity.ok(updatedWishList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishList(@PathVariable Long id) {
        wishListService.deleteWishlistById(id);
        return ResponseEntity.noContent().build();
    }
}