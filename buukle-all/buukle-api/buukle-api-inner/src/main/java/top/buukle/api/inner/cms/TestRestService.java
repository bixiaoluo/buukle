package top.buukle.api.inner.cms;


import top.buukle.daoEntity.mc.entity.User;

public interface TestRestService {
    User getUser(Integer id) throws Exception;
}
