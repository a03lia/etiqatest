package com.a03lia.university.service;

import com.a03lia.university.model.Major;
import java.util.List;

/**
 *
 * @author a03lia
 */
public interface MajorSrv
{
    List<Major> all();
    void create(Major major);
    void update(Major major);
    void delete(String id);
}
