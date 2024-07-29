package com.hsgumussoy.blogsiteproject.domain.platform.group.web;


import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupMapper;
import com.hsgumussoy.blogsiteproject.domain.platform.group.api.GroupService;
import com.hsgumussoy.blogsiteproject.library.rest.BaseController;
import com.hsgumussoy.blogsiteproject.library.rest.MetaResponse;
import com.hsgumussoy.blogsiteproject.library.rest.PageResponse;
import com.hsgumussoy.blogsiteproject.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("groups")
@RequiredArgsConstructor
public class GroupController extends BaseController {
    private final GroupService service;
    @PostMapping
    private Response<GroupResponse> save(@RequestBody GroupRequest request){
        return respond(GroupMapper.toResponse(service.save(GroupMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    private Response<GroupResponse> get(@PathVariable String id){
        return respond(GroupMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<GroupResponse>> getAll(Pageable pageable){
        return respond(GroupMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("/{id}")
    private Response<GroupResponse> update(@PathVariable String id , @RequestBody GroupRequest request){
        return respond(GroupMapper.toResponse(service.update(id , GroupMapper.toDto(request))));
    }

}
