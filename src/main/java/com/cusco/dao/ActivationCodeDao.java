/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusco.dao;

import com.cusco.entity.ActivationCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author liuyz
 */
public interface ActivationCodeDao extends JpaRepository<ActivationCode, String> {

}
