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
        GroupDto roleDto = roleService.getById(dto.getGroup().getId());
        return UserGroupMapper.toDto(repository.save(UserGroupMapper.toEntity(new UserGroup(), dto)), userDto, roleDto);
    }

    @Override
    public UserGroupDto getById(String id) {
        UserGroup userGroup = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(userGroup.getUserId());
        GroupDto groupDto = roleService.getById(userGroup.getGroupId());

        return UserGroupMapper.toDto(userGroup, userDto, groupDto);
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

    private Page<UserGroupDto> PageToDto(Page<UserGroup> userGroups) {
        List<String> userIds = userGroups.stream().map(UserGroup::getUserId).toList();
        List<String> groupIds = userGroups.stream().map(UserGroup::getGroupId).toList();

        List<UserDto> userDtoList = userService.getByIds(userIds);
        List<GroupDto> groupDtoList = roleService.getByIds(groupIds);

        return PageUtil.pageToDto(userGroups, (userRole -> {
            UserDto userDto = userDtoList.stream().filter(user -> user.getId().equals(userRole.getUserId())).findFirst().orElseThrow();
            GroupDto groupDto = groupDtoList.stream().filter(role -> role.getId().equals(userRole.getGroupId())).findFirst().orElseThrow();
            return UserGroupMapper.toDto(userRole, userDto, groupDto);
        }));
    }
}
