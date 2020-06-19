/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusco.wrap;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author liuyz
 */
@Data
@NoArgsConstructor
public class PageQueryParam {

    private int pageSize = 10;
    private int curPage = 1;
    private String keywords;
}
