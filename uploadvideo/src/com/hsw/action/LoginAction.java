package com.hsw.action;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hsw.entity.UserEntity;
import com.hsw.util.MyBatisUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String message;
	private UserEntity userEntity;
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		List<UserEntity> users = session.selectList("user1.get", userEntity);
		if(session!=null){
			session.close();
		}
		if(users.size()>0){
			System.out.println("登陆成功。");
			ActionContext.getContext().getSession().put("user", users.get(0));
			return SUCCESS;
		}
		System.out.println("用户名或密码错误。");
		message = "用户名或密码错误。";
		return INPUT;
	}

public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


public UserEntity getUserEntity() {
	return userEntity;
}
public void setUserEntity(UserEntity userEntity) {
	this.userEntity = userEntity;
}

}
