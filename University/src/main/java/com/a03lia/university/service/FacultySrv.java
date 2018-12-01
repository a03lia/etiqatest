package com.a03lia.university.service;

import com.a03lia.university.model.Faculty;
import java.util.List;

/**
 *
 * @author a03lia
 */
public interface FacultySrv
{
    List<Faculty> all();
    void create(Faculty faculty);
    void update(Faculty faculty);
    void delete(String id);
}
