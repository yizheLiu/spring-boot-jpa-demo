/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusco.controller;

import com.cusco.dao.ActivationCodeDao;
import com.cusco.entity.ActivationCode;
import com.cusco.enums.RecordState;
import com.cusco.util.ShortUUID;
import com.cusco.wrap.PageQueryParam;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liuyz
 */
@RestController
@RequestMapping("/code")
public class TestController {

    @Autowired
    private ActivationCodeDao activationCodeDao;

    @GetMapping("/add")
    @Transactional(rollbackOn = Exception.class)
    public void add() {
        ActivationCode code = new ActivationCode();
        code.setGroupId("groupId");
        code.setActivationCode(ShortUUID.generate());
        code.setCodeDesc("codeDesc");
        code.setExpireTime(new Date());
        code.setPackageId("packageId");
        code.setActivated(true);
        code.setActiveTime(new Date());
        code.setMemberId("memberId");
        code.setRecordState(RecordState.NORMAL);
        code.setCreateTime(new Date());
        code.setCreatorId("creatorId");
        code.setCreatorName("creatorName");
        code.setModifyTime(new Date());
        code.setModifierId("modifierId");
        code.setModifierName("modifierName");
        activationCodeDao.save(code);
    }

    @GetMapping("/getAll")
    public List<ActivationCode> getAll() {
        return activationCodeDao.findAll();
    }

    @GetMapping("/get/{id}")
    public ActivationCode get(@PathVariable String id) {
        return activationCodeDao.getOne(id);
    }

    @PostMapping("/getByPage")
    public Page<ActivationCode> getByPage(@RequestBody PageQueryParam param) {
        Pageable pageable = PageRequest.of(param.getCurPage() - 1, param.getPageSize(), Sort.by("createTime").descending());
        Page<ActivationCode> result = activationCodeDao.findAll(pageable);
        return result;
    }

    @GetMapping("/exists/{id}")
    public boolean exists(@PathVariable String id) {
        return activationCodeDao.existsById(id);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        activationCodeDao.deleteById(id);
    }

    // 局部更新：使用更新对象的非空值去覆盖待更新对象
    @PostMapping("/modify")
    @Transactional(rollbackOn = Exception.class)
    public ActivationCode modify(@RequestBody ActivationCode code) {
        ActivationCode old = get(code.getActivationCode());
        BeanUtils.copyProperties(code, old, getNullPropertyNames(code)); //使用更新对象的非空值去覆盖待更新对象
        return activationCodeDao.save(old);
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
