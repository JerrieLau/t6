package com.yxtec.t6.web;

import com.yxtec.t6.model.Score;
import com.yxtec.t6.service.ScoreService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/new", method = {RequestMethod.GET})
    public ModelAndView newPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST})
    public ModelAndView put(Score score) {
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
