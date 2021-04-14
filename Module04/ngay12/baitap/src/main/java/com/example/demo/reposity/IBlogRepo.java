package com.example.demo.reposity;


import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IBlogRepo extends JpaRepository<Blog,Integer> {
    @Query(value = "SELECT * FROM blog where title like %:keyword%",nativeQuery = true)
    List<Blog> findAllByTitle(  @Param("keyword") String keyword);

    List<Blog> findByOrderByTitleDesc( );
}
