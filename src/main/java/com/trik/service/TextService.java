package com.trik.service;

import com.trik.entity.Text;

import java.util.List;

/**
 * Created by Trik.Song on 2017/12/12.
 */
public interface TextService {
    public List<Text> getAll();

    Text findTextById(Integer id);

    public void update (String content);

    public void delete(Integer id);
}
