package com.example.demo.service.impl;




import com.example.demo.model.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll( );
    void save(AttachService contract);
}
