package com.he.scurity.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.he.scurity.dao.PermissionMapper;
import com.he.scurity.domain.security.vo.Permission;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author hewenchao
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年09月15日 17:55:00
 */
@Service
public class MyInvocationSecurityMetadataSourceService  implements
        FilterInvocationSecurityMetadataSource , InitializingBean {

    @Autowired
    private PermissionMapper permissionsMapper;

    private HashMap<String, Collection<ConfigAttribute>> map =null;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        //查找全部
        List<Permission> permissions = permissionsMapper.selectList(new QueryWrapper<>());
        for(Permission permission : permissions) {
            array = map.get(permission.getUrl());
            if(array == null){
                array = new ArrayList<>();
            }
            //权限名
            cfg = new SecurityConfig(permission.getName());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            array.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            map.put(permission.getUrl(), array);
        }

    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

                   //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
                //返回权限
                return map.get(resUrl);
            }
        }
        //未匹配到返回error标志位
        return  Arrays.asList(new SecurityConfig("error"));

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * @author hewenchao
     * @description 实例化bean从库中拉取所有权限数据，存在脏数据，仅作测试用
     * @Date: 2021/9/17 16:34
    * @return: void
     **/
    @Override
    public void afterPropertiesSet() throws Exception {
        loadResourceDefine();
    }
}