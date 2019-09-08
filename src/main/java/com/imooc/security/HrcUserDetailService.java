package com.imooc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @ClassName: HrcUserDetailService  
 * @Description: 自定义密码验证
 * @author 郝若池
 * @date 2019年6月2日 下午5:20:04
 */
@Component
public class HrcUserDetailService implements UserDetailsService,SocialUserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 表单登录使用的用户信息
	 * @param username
     * @return
     * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		logger.info("用户名"+username);
		logger.info("密码"+passwordEncoder.encode("duanmeas321"));
		return new User(username, passwordEncoder.encode("duanmeas321"), true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

	/**
     * 社交登录使用的用户信息
	 * @param userid
     * @return
     * @throws UsernameNotFoundException
	 */
	@Override
	public SocialUserDetails loadUserByUserId(String userid) throws UsernameNotFoundException {
		logger.info("用户名"+userid);
		logger.info("密码"+passwordEncoder.encode("duanmeas321"));
		return new SocialUser(userid, passwordEncoder.encode("duanmeas321"), true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}
}
