package com.lc.bbs.dao;

import org.apache.ibatis.annotations.Param;

public interface CategoryDao {
    Integer addCategory(@Param("name") String name,
                        @Param("imageSrc") String imageSrc);
}
