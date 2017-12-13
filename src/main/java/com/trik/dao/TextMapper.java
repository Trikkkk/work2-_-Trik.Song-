package com.trik.dao;

import com.trik.entity.Text;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */

@Mapper
@Component
public interface TextMapper {
    List<Text> getAll();
    Text findTextById(int id);
    void update(String content);
    void delete(int id);
}
