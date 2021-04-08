package com.example.demo.reposity;


import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IBlogRepo extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllByTitleContaining(Pageable pageable,String keyword);
}
