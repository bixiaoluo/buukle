package top.buukle.provider.mc.service.impl;

import top.buukle.api.inner.mc.TestRestService;
import top.buukle.daoEntity.mc.dao.UserMapper;
import top.buukle.daoEntity.mc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Service
@Path("/pro")

public class TestRestServiceImpl implements TestRestService {

    @Resource
    private UserMapper userMapper;
    @GET
    @Path("/getUserById")
    @Override
    @Produces({MediaType.APPLICATION_JSON })
    @Consumes({MediaType.APPLICATION_JSON })
    public User getUser(@RequestParam Integer id) throws Exception {
        User user = userMapper.getUserById(id);
        return userMapper.getUserById(id);
    }
}
