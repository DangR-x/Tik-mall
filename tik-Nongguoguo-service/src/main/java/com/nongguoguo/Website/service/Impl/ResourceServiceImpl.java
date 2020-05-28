package com.nongguoguo.Website.service.Impl;

import com.nongguoguo.Website.domain.Resource;
import com.nongguoguo.Website.mapper.ResourceMapper;
import com.nongguoguo.Website.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public void insert(Resource t) {
        resourceMapper.insert(t);
    }

    @Override
    public void deleteById(Serializable id) {
        resourceMapper.deleteById(id);
    }

    @Override
    public void updateById(Resource t) {
        resourceMapper.updateById(t);
    }

    @Override
    public Resource selectById(Serializable id) {
        return resourceMapper.selectById(id);
    }

    @Override
    public List<Resource> selectAll() {
        return resourceMapper.selectAll();
    }

    @Override
    public List<Resource> getResourceByAminId(Long adminid) {
        return resourceMapper.getResourceByAminId(adminid);
    }


}
