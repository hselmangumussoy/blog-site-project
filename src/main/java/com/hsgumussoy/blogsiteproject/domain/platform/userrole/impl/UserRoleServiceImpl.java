package com.hsgumussoy.blogsiteproject.domain.platform.userrole.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.role.api.RoleService;
import com.hsgumussoy.blogsiteproject.domain.platform.userrole.api.UserRoleDto;
import com.hsgumussoy.blogsiteproject.domain.platform.userrole.api.UserRoleService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository repository;
    private final UserService userService;
    private final RoleService roleService;

    @Override
    public UserRoleDto save(UserRoleDto dto) {
        UserDto userDto = userService.getById(dto.getUser().getId());
        RoleDto roleDto = roleService.getById(dto.getRole().getId());
        return UserRoleMapper.toDto(repository.save(UserRoleMapper.toEntity(new UserRole(), dto)), userDto, roleDto);
    }

    @Override
    public UserRoleDto getById(String id) {
        UserRole userRole = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(userRole.getRoleId());
        RoleDto roleDto = roleService.getById(userRole.getRoleId());

        return UserRoleMapper.toDto(userRole, userDto, roleDto);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public UserRoleDto update(String id, UserRoleDto dto) {
        return null;
    }

    @Override
    public Page<UserRoleDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }

    private Page<UserRoleDto> PageToDto(Page<UserRole> userRoles) {
        List<String> userIds = userRoles.stream().map(UserRole::getUserId).toList();
        List<String> roleIds = userRoles.stream().map(UserRole::getRoleId).toList();

        List<UserDto> userDtoList = userService.getByIds(userIds);
        List<RoleDto> roleDtoList = roleService.getByIds(roleIds);

        return PageUtil.pageToDto(userRoles, (userRole -> {
            UserDto userDto = userDtoList.stream().filter(user -> user.getId().equals(userRole.getUserId())).findFirst().orElseThrow();
            RoleDto roleDto = roleDtoList.stream().filter(role -> role.getId().equals(userRole.getRoleId())).findFirst().orElseThrow();
            return UserRoleMapper.toDto(userRole, userDto, roleDto);
        }));
    }
}
