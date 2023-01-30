package com.lizza.base.oval;

import com.google.common.collect.Lists;
import com.lizza.base.oval.param.PhraseEditParam;
import com.lizza.base.oval.param.WhenParam;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.expression.ExpressionLanguageGroovyImpl;
import org.junit.Test;

import java.util.List;

public class WhenTests {

    private static final Validator validator = new Validator();

    static {
        validator.getExpressionLanguageRegistry()
                 .registerExpressionLanguage("groovy",
                new ExpressionLanguageGroovyImpl());
    }

    @Test
    public void test1() throws Exception {
        WhenParam param = WhenParam.builder().sex("0").build();
        check(param);
        System.out.println("-----------");
        param.setMan("lizza");
        check(param);
    }

    @Test
    public void test2() throws Exception {
        PhraseEditParam param = PhraseEditParam.builder().build();
        param.setType("TEXT");
        PhraseEditParam.Content content = param.new Content();
        param.setContent(content);
        check(param);
        System.out.println("-----------");
        content.setImages(Lists.newArrayList());
        param.setContent(content);
        check(param);
    }

    private static void check(Object param) {
        List<ConstraintViolation> message = validator.validate(param);
        for (ConstraintViolation item : message) {
            String msg = item.getMessage().replaceAll(item.getValidatedObject().getClass().getCanonicalName() + ".", "");
            System.out.println(msg);
        }
    }
}


