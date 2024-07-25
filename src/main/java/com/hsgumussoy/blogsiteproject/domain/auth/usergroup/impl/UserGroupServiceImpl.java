package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api.UserGroupDto;
import com.hsgumussoy.blogsiteproject.domain.auth.usergroup.api.UserGroupService;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupDto;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserGroupServiceImpl implements UserGroupService {
    private final UserGroupRepository repository;
    private final UserService userService;
    private final GroupService roleService;

    @Override
    public UserGroupDto save(UserGroupDto dto) {
        UserDto userDto = userService.getById(dto.getUser().getId());
        GroupDto roleDto = roleService.getById(dto.getRole().getId());
        return UserGroupMapper.toDto(repository.save(UserGroupMapper.toEntity(new UserGroup(), dto)), userDto, roleDto);
    }

    @Override
    public UserGroupDto getById(String id) {
        UserGroup userRole = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(userRole.getRoleId());
        GroupDto roleDto = roleService.getById(userRole.getRoleId());

        return UserGroupMapper.toDto(userRole, userDto, roleDto);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public UserGroupDto update(String id, UserGroupDto dto) {
        return null;
    }

    @Override
    public Page<UserGroupDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }

    private Page<UserGroupDto> PageToDto(Page<UserGroup> userRoles) {
        List<String> userIds = userRoles.stream().map(UserGroup::getUserId).toList();
        List<String> roleIds = userRoles.stream().map(UserGroup::getRoleId).toList();

        List<UserDto> userDtoList = userService.getByIds(userIds);
        List<GroupDto> roleDtoList = roleService.getByIds(roleIds);

        return PageUtil.pageToDto(userRoles, (userRole -> {
            UserDto userDto = userDtoList.stream().filter(user -> user.getId().equals(userRole.getUserId())).findFirst().orElseThrow();
            GroupDto roleDto = roleDtoList.stream().filter(role -> role.getId().equals(userRole.getRoleId())).findFirst().orElseThrow();
            return UserGroupMapper.toDto(userRole, userDto, roleDto);
        }));
    }
}
