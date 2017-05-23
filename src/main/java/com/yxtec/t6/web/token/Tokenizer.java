package com.yxtec.t6.web.token;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Token标识注解
 *
 * @author :<a href="mailto:liujie@ebnew.com">刘杰</a>
 * @date :2017-05-23 10:46:23
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Tokenizer {

    /**
     * Token生成器类型，比如uuid,md5
     *
     * @return the string
     * @author :<a href="mailto:liujie@ebnew.com">刘杰</a>
     * @date :2017-05-23 10:46:23
     */
    TokenGenerator generator() default TokenGenerator.UUID;

    /**
     * 类型，生成/验证.
     *
     * @return the string
     * @author :<a href="mailto:liujie@ebnew.com">刘杰</a>
     * @date :2017-05-23 10:48:31
     * @see TokenizerType
     */
    TokenizerType type() default TokenizerType.CREATOR;

}
