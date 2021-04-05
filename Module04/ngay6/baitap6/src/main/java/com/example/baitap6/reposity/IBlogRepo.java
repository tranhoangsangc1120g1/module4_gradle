package com.example.baitap6.reposity;

import com.example.baitap6.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepo extends JpaRepository<Blog,Integer> {
}
