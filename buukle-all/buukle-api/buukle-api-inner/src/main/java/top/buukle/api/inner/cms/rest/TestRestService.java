package top.buukle.api.inner.cms.rest;


import top.buukle.daoEntity.mc.entity.User;

public interface TestRestService {
    User getUser(Integer id) throws Exception;
}