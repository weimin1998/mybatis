package com.weimin.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

// type ：指定要拦截那个对象；
// method：拦截对象的那个方法；
// args：要拦截的方法的参数列表，因为方法可能重载；
@Intercepts(
        {
                @Signature(
                        type = StatementHandler.class,
                        method = "parameterize",
                        args = {Statement.class}
                )
        }
)
public class TestPlugin implements Interceptor {

    // 拦截目标方法的执行
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("TestPlugin intercept().....");
        // 执行目标方法；
        Object proceed = invocation.proceed();
        return proceed;
    }

    // 包装目标对象
    public Object plugin(Object target) {
        System.out.println("TestPlugin plugin().....");
        Object wrap = Plugin.wrap(target, this);
        System.out.println("TestPlugin plugin()..... " + wrap);
        return wrap;
    }

    // 将插件注册是的property属性设置进来
    public void setProperties(Properties properties) {
        System.out.println("TestPlugin setProperties().....");
        System.out.println(properties);
    }
}
