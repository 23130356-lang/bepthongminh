package com.example.Webbepthongminh.service;

import com.example.Webbepthongminh.entity.User;
import com.example.Webbepthongminh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Service này được Spring Security sử dụng để tải thông tin người dùng từ MySQL
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Không tìm thấy người dùng: " + username);
        }

        // Lấy danh sách Roles và chuyển chúng thành GrantedAuthority
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            // Spring Security yêu cầu vai trò phải bắt đầu bằng "ROLE_"
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        // Tạo đối tượng UserDetails (đối tượng mà Spring Security sử dụng)
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(), // Mật khẩu đã được mã hóa (BCrypt)
                grantedAuthorities
        );
    }
}