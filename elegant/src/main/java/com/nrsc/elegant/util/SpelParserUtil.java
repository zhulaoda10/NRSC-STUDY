package com.nrsc.elegant.util;

import org.springframework.expression.Expression;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/***
 *  @author : Sun Chuan
 *  @date : 2019/12/1 23:36
 *  Description： 解析注解中el表达式对应值的工具类
 */
public class SpelParserUtil {
    private SpelParserUtil() {
    }

    private static ExpressionParser parser = new SpelExpressionParser();

    /***
     * @param key   el表达式字符串，占位符以#开头
     * @param paramsNames 形参名称，可以理解为占位符名称
     * @param args 参数值，可以理解为占位符真实值
     * @return 返回el表达式经过参数替换后的字符串
     */
    public static String getKey(String key, String[] paramsNames, Object[] args) {
        //将key字符串解析为el表达式
        Expression exp = parser.parseExpression(key);
        //初始化赋值上下文
        EvaluationContext context = new StandardEvaluationContext();
        if (args.length <= 0) {
            return null;
        }
        //将 形参 和 形参值 以配对的方式配置到赋值上下文中
        for (int i = 0; i < args.length; i++) {
            context.setVariable(paramsNames[i], args[i]);
        }
        //根据赋值上下文运算el表达式
        return exp.getValue(context, String.class);

    }


    public static void main(String[] args) {
        String key = "#id+''+#userCode";//e1表达式字符事
        String id = "001";
        String userCode = "xiaoming";
        // paramName赋值
        String[] paramsName = new String[]{"id", "userCode"};
        //args赋值
        Object[] _args = new Object[2];
        _args[0] = id;
        _args[1] = userCode;
        System.out.println(SpelParserUtil.getKey(key, paramsName, _args));
    }


}
