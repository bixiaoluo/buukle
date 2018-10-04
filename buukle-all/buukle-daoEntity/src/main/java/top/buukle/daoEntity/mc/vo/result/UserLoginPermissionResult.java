package top.buukle.daoEntity.mc.vo.result;

import top.buukle.daoEntity.mc.entity.*;
import top.buukle.daoEntity.mc.entity.*;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/30.
 * @Description :
 */
public class UserLoginPermissionResult {

    /** 当前用户基本信息*/
    private User user;

    /** 当前用户扩展信息*/
    private UserExp userExp;

    /** 当前用户角色列表*/
    private List<Role> roleList;

    /** 当前用户菜单列表*/
    private List<Module> moduleList;

    /** 当前用户按钮列表*/
    private List<Button> buttonList;

    /** 当前用户组别列表*/
    private List<Groups> groupList;

    /** 当前用户所辖用户列表*/
    private List<User> userList;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserExp getUserExp() {
        return userExp;
    }

    public void setUserExp(UserExp userExp) {
        this.userExp = userExp;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public List<Groups> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Groups> groupList) {
        this.groupList = groupList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Button> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<Button> buttonList) {
        this.buttonList = buttonList;
    }
}
