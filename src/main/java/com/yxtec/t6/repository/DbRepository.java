package com.yxtec.t6.repository;

import com.yxtec.t6.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author : <a href="mailto:jerrielau@qq.com">刘杰</a>
 * @version : 0.0.1
 * @date : 2017-05-17 22:42
 */
@Repository
public class DbRepository {

    private static final String sql = "replace into scores(id,sname,course,score) values(?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveOrUpdate(Score score) {
        jdbcTemplate.update(sql, score.getId(), score.getSname(), score.getCourse(), score.getScore());
    }

    public List<Score> queryAll() {
        return jdbcTemplate.query("select * from scores", new RowMapper<Score>() {
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Score.builder()
                        .id(rs.getLong("id"))
                        .sname(rs.getString("sname"))
                        .course(rs.getString("course"))
                        .score(rs.getFloat("score")).build();
            }
        });
    }

}
