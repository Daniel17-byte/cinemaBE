package com.example.cinemabe.services;

import com.example.cinemabe.models.WishList;
import com.example.cinemabe.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public WishList saveWishlist(WishList wishList) {
        return wishlistRepository.save(wishList);
    }

    public Optional<WishList> getWishlistById(Long id) {
        return wishlistRepository.findById(id);
    }

    public WishList updateWishlist(Long id, WishList wishList) {
        return wishlistRepository.save(wishList);
    }

    public void deleteWishlistById(Long id) {
        wishlistRepository.deleteById(id);
    }

    public List<WishList> getAllWishlists() {
        return wishlistRepository.findAll();
    }
}