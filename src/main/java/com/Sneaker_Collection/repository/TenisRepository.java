package com.Sneaker_Collection.repository;

import com.Sneaker_Collection.entity.Tenis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenisRepository extends JpaRepository<Tenis,Long> {
}