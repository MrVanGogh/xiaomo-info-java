package info.xiaomo.application.service.impl;

import info.xiaomo.application.dao.LinkDao;
import info.xiaomo.application.model.LinkModel;
import info.xiaomo.application.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 2016/4/11 19:50
 * @Copyright(©) 2015 by xiaomo.
 **/
@Service
public class LinkServiceImpl implements LinkService {

    private final LinkDao dao;

    @Autowired
    public LinkServiceImpl(LinkDao dao) {
        this.dao = dao;
    }

    @Override
    public LinkModel findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public LinkModel findByName(String name) {
        return dao.findLinkByName(name);
    }

    @Override
    public Page<LinkModel> findAll(int start, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "order");
        return dao.findAll(new PageRequest(start - 1, pageSize, sort));
    }

    @Override
    public List<LinkModel> findAll() {
        return dao.findAll();
    }

    @Override
    public LinkModel add(LinkModel model) {
        return dao.save(model);
    }

    @Override
    public LinkModel update(LinkModel model) {
        LinkModel updateModel = dao.findOne(model.getId());
        if (model.getName() != null) {
            updateModel.setName(model.getName());
        }
        if (model.getUrl() != null) {
            updateModel.setUrl(model.getUrl());
        }
        if (model.getPosition() > 0) {
            updateModel.setPosition(model.getPosition());
        }
        return dao.save(updateModel);
    }

    @Override
    public LinkModel delete(Long id) {
        LinkModel model = dao.findOne(id);
        if (model != null) {
            dao.delete(id);
        }
        return model;
    }
}
