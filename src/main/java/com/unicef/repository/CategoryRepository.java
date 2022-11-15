package com.unicef.repository;

import com.unicef.domain.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryRepository {
    public int save(Category category);
}
