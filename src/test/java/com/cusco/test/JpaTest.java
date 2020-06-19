/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusco.test;

import com.cusco.Application;
import com.cusco.dao.ActivationCodeDao;
import com.cusco.entity.ActivationCode;
import com.cusco.enums.RecordState;
import com.cusco.util.ShortUUID;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author liuyz
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JpaTest {

    @Autowired
    private ActivationCodeDao activationCodeDao;

    @Test
    public void testSave() {
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
        activationCodeDao.save(code);
    }
}
