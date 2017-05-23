package com.yxtec.t6.web.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by jerrie on 17-5-23.
 */
public class TokenizerProcessHandlerInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenizerProcessHandlerInterceptor.class);

    public static final String SESSION_TOKEN_KEY_NAME = "APPLICATION__TOKEN";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            Tokenizer tokenizer = method.getMethodAnnotation(Tokenizer.class);
            if (tokenizer != null) {
                TokenizerType type = tokenizer.type();
                if (type.equals(TokenizerType.CREATOR)) {
                    TokenGenerator generator = tokenizer.generator();
                    if (generator.equals(TokenGenerator.UUID)) {
                        String token = UUID.randomUUID().toString();
                        HttpSession session = request.getSession(true);
                        session.setAttribute(SESSION_TOKEN_KEY_NAME, token);
                    }
                    //else //TODO
                } else if (type.equals(TokenizerType.VALIDATOR)) {
                    HttpSession session = request.getSession(true);
                    Object tokenObject = session.getAttribute(SESSION_TOKEN_KEY_NAME);
                    if (tokenObject != null && tokenObject instanceof String) {
                        String token = (String) tokenObject;
                        String token_param = request.getParameter(SESSION_TOKEN_KEY_NAME);

                        //移出Token，防止重复提交
                        session.removeAttribute(SESSION_TOKEN_KEY_NAME);

                        if (!token.equals(token_param)) {
                            throw new IllegalArgumentException("Token验证失败，请回退后刷新重试!");
                        }
                    } else {
                        LOGGER.error("从会话中获取出的token为{}，请检查前一页面是否放入token!", tokenObject);
                        throw new IllegalStateException("从会话过期，请回退后刷新重试!");
                    }
                }
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
