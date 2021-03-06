package com.yxtec.t6.web.controller;

import com.yxtec.t6.model.Score;
import com.yxtec.t6.service.ScoreService;
import com.yxtec.t6.web.token.Tokenizer;
import com.yxtec.t6.web.token.TokenizerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jerrie on 17-5-19.
 */

@Controller
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("all");
        List<Score> scores = scoreService.list();
        modelAndView.addObject("scores", scores);
        return modelAndView;
    }

    @Tokenizer(type = TokenizerType.CREATOR)
    @RequestMapping(value = "/new", method = {RequestMethod.GET})
    public ModelAndView newPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new");
        return modelAndView;
    }

    @Tokenizer(type = TokenizerType.VALIDATOR)
    @RequestMapping(value = "/", method = {RequestMethod.POST})
    public ModelAndView put(@Valid Score score) {
        scoreService.save(score);
        return list();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public void get(@PathVariable Long id) {
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public void delete(@PathVariable Long id) {
    }

}
