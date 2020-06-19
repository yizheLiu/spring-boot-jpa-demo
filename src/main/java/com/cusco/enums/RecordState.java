/*
 * RecordState.java
 * 
 * Copyright(c) 2007-2017 by Yingzhi Tech
 * All Rights Reserved
 * 
 * Created at 2017-03-29 14:23:31
 */
package com.cusco.enums;

/**
 *
 * @author Hu Qin
 */
public enum RecordState {
    NORMAL() {

        @Override
        public String toString() {
            return "正常";
        }
    },
    DELETED() {

        @Override
        public String toString() {
            return "已删除";
        }
    },
    DISABLED() {
        @Override
        public String toString() {
            return "已禁用";
        }
    }
}
