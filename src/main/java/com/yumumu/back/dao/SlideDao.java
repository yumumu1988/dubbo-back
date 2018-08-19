package com.yumumu.back.dao;

import model.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SlideDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public Slide findSlideById(Integer id){
        String sql = "select * from slides where id = ?";
        List<Slide> slideList = jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<Slide>() {
            @Override
            public Slide mapRow(ResultSet resultSet, int i) throws SQLException {
                Slide slide = new Slide();
                slide.setId(resultSet.getInt("id"));
                return slide;
            }
        });

        if (slideList != null && slideList.size() == 1){
            return slideList.get(0);
        } else {
            return null;
        }
    }
}
