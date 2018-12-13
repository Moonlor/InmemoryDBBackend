package com.gc.inmemorydb.core.config.mybatis;


import com.apple.eawt.AppEvent;
import com.gc.inmemorydb.StaticCache;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.jdbc.PreparedStatementLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.ResultHandler;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = { Statement.class })
})
public class SqlCostInterceptor implements Interceptor{

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        String uid = "1";

        Object[] args = invocation.getArgs();
        for(int i=0;i<args.length;i++)
        {
            Object arg=args[i];
        }

        Object target = invocation.getTarget();
        StatementHandler statementHandler = (StatementHandler)target;

        long startTime = System.currentTimeMillis();
        try {

            BoundSql boundSql = statementHandler.getBoundSql();
            Object parameterObject = boundSql.getParameterObject();
            System.out.println(parameterObject.toString());
            Pattern pattern = Pattern.compile("(?<=sqlUid=)(\\S*)(?=,)");
            Matcher matcher = pattern.matcher(parameterObject.toString());
            if(matcher.find()){
                uid = matcher.group(0);
            }


            Object result = invocation.proceed();
            return result;
        } finally {
            long endTime = System.currentTimeMillis();
            long sqlCost = endTime - startTime;
            System.out.println("执行耗时 : [ " + sqlCost + "ms ] ");
            if(uid != "1"){
                StaticCache cache = new StaticCache();
                cache.setSqlCostUid(uid, String.valueOf(sqlCost));
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }


}
