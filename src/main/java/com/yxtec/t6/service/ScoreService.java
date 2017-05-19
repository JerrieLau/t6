package com.yxtec.t6.service;

import com.yxtec.t6.model.Score;
import com.yxtec.t6.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author : <a href="mailto:jerrielau@qq.com">刘杰</a>
 * @version : 0.0.1
 * @date : 2017-05-17 23:30
 */
@Service
public class ScoreService {

    @Autowired
    private DbRepository dbRepository;

    @Transactional
    public void save(Score score) {
        dbRepository.saveOrUpdate(score);
    }

    public List<Score> list() {
        return dbRepository.queryAll();
    }

}
