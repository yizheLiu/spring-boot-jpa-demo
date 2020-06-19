/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusco.entity;

import com.cusco.enums.RecordState;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 * 激活码组别
 *
 * @author huqin
 */
@Entity
@Table(name = "activation_code_groups")
@Data
public class ActivationCodeGroup implements Serializable, Cloneable {

    private static final long serialVersionUID = 8859538438201429266L;

    @Override
    public ActivationCodeGroup clone() {
        try {
            ActivationCodeGroup m = (ActivationCodeGroup) super.clone();
            return m;
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    /**
     * 组别ID
     */
    @Id
    @Column(length = 19)
    private Long groupId;
    /**
     * 组别名称
     */
    @Column(length = 32)
    private String groupName;
    /**
     * 备注
     */
    @Column(length = 512)
    private String groupDesc;
    /**
     * 记录状态
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
    @Column(length = 64)
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

}
