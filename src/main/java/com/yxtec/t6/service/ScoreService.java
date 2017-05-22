package com.yxtec.t6.service;

import com.yxtec.t6.model.Score;
import com.yxtec.t6.repository.DbRepository;
import com.yxtec.t6.repository.JmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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

    @Autowired
    private JmsRepository jmsRepository;

    private AtomicLong atomicLong = new AtomicLong();

    @Transactional
    public void save(Score score) {
        if (score.getId() == null) {
            score.setId(atomicLong.addAndGet(1));
        }
        dbRepository.saveOrUpdate(score);
        jmsRepository.sendScoreMessage(score);
    }

    public List<Score> list() {
        return dbRepository.queryAll();
    }

}
