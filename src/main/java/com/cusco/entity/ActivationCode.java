/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusco.entity;

import com.cusco.enums.RecordState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.*;
import lombok.Data;

/**
 * 激活码
 *
 * @author huqin
 */
@Entity
@Table(name = "activation_codes")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class ActivationCode implements Serializable, Cloneable {

    private static final long serialVersionUID = -8366072312720572246L;
    /**
     * 激活码
     */
    @Id
    @Column(length = 19)
    private String activationCode;
    /**
     * 备注
     */
    @Column( length = 512)
    private String codeDesc;
    /**
     * 组别Id
     */
    private String groupId;
    /**
     * 有效期
     */
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireTime;
    /**
     * 套餐Id
     */
    @Column(length = 64)
    private String packageId;
    /**
     * 是否激活
     */
    @Column()
    private boolean activated;
    /**
     * 激活时间
     */
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date activeTime;
    /**
     * 激活会员Id
     */
    @Column(length = 64)
    private String memberId;
    /**
     * 状态
     */
    @Column(length = 64)
    @Enumerated(EnumType.STRING)
    private RecordState recordState;
    /**
     * 创建时间
     */
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**
     * 创建人ID
     */
    @Column(length = 64)
    private String creatorId;
    /**
     * 创建人姓名
     */
    @Column( length = 64)
    private String creatorName;
    /**
     * 修改时间
     */
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;
    /**
     * 修改人ID
     */
    @Column(length = 64)
    private String modifierId;
    /**
     * 修改人姓名
     */
    @Column(length = 64)
    private String modifierName;

    @Override
    public ActivationCode clone() {
        try {
            ActivationCode m = (ActivationCode) super.clone();
            return m;
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
