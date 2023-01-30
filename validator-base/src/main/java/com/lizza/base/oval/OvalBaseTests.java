package com.lizza.base.oval;

import com.google.common.collect.Lists;
import com.lizza.base.oval.param.ListParam;
import com.lizza.base.oval.param.StringParam;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.junit.Test;

import java.util.List;

public class OvalBaseTests {

    private static final Validator validator = new Validator();

    /**
     * 字符串
     */
    @Test
    public void test1() throws Exception {
        StringParam param = StringParam.builder()
                                       .build();
        check(param);
        System.out.println("-----------");
        param.setName(" ");
        param.setId(" ");
        param.setDesc(" ");
        param.setJob("");
        param.setInfo("");
        check(param);
        System.out.println("-----------");
        param.setInfo("1234");
        check(param);
    }

    /**
     * 数组
     */
    @Test
    public void test2() throws Exception {
        ListParam param = ListParam.builder().build();
        check(param);
        System.out.println("-----------");
        param.setIds(Lists.newArrayList());
        param.setPhones(Lists.newArrayList());
        check(param);
        System.out.println("-----------");
    }

    private static void check(Object param) {
        List<ConstraintViolation> message = validator.validate(param);
        for (ConstraintViolation item : message) {
            String msg = item.getMessage().replaceAll(item.getValidatedObject().getClass().getCanonicalName() + ".", "");
            System.out.println(msg);
        }
    }
}
