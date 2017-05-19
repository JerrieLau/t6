package com.yxtec.t6.web;

import com.yxtec.t6.model.Score;
import com.yxtec.t6.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
        modelAndView.setViewName("list");
        List<Score> scores = scoreService.list();
        modelAndView.addObject("scores", scores);
        return modelAndView;
    }

    @RequestMapping(value = "/", method = {RequestMethod.PUT})
    public void put(Score score) {
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public void get(@PathVariable Long id) {
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public void delete(@PathVariable Long id) {
    }

}
