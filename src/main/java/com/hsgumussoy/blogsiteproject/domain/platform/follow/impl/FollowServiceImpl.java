package com.hsgumussoy.blogsiteproject.domain.platform.follow.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserDto;
import com.hsgumussoy.blogsiteproject.domain.auth.user.api.UserService;
import com.hsgumussoy.blogsiteproject.domain.platform.follow.api.FollowDto;
import com.hsgumussoy.blogsiteproject.domain.platform.follow.api.FollowService;
import com.hsgumussoy.blogsiteproject.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
    private final FollowRepository repository;
    private final UserService userService;

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Page<FollowDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }



    @Override
    public FollowDto getById(String id) {
        Follow follow = repository.findById(id).orElseThrow();
        UserDto followerDto = userService.getById(follow.getFollowerId());
        UserDto followedDto = userService.getById(follow.getFollowedId());

        return FollowMapper.toDto(follow, followerDto, followedDto);
    }

    @Override
    public FollowDto save(FollowDto dto) {
        UserDto followerDto = userService.getById(dto.getFollower().getId());
        UserDto followedDto = userService.getById(dto.getFollowed().getId());

        return FollowMapper.toDto(repository.save(FollowMapper.toEntity(new Follow(), dto)), followerDto, followedDto);
    }

    private Page<FollowDto> PageToDto(Page<Follow> follows) {
        List<String> followerIds = follows.stream().map(Follow::getFollowerId).toList();
        List<String> followedIds = follows.stream().map(Follow::getFollowedId).toList();

        List<UserDto> followerDtoList = userService.getByIds(followerIds);
        List<UserDto> followedDtoList = userService.getByIds(followedIds);

        return PageUtil.pageToDto(follows, (follow -> {
            UserDto followerDto = followerDtoList.stream().filter((follower -> follower.getId().equals(follow.getFollowerId()))).findFirst().orElseThrow();
            UserDto followedDto = followedDtoList.stream().filter((followed -> followed.getId().equals(follow.getFollowedId()))).findFirst().orElseThrow();

            return FollowMapper.toDto(follow , followerDto, followedDto);
        }));

    }
}
