package com.jlj.shoppay.dao;

import com.jlj.shoppay.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
public interface CategoryMapper {
    Category findId(Integer id);
}
