package com.example.baitap7.reposity;

import com.example.baitap7.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepo extends JpaRepository<Blog,Integer> {
}
