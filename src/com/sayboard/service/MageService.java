package com.sayboard.service;

import com.sayboard.dao.MageDao;
import com.sayboard.domain.Mage;
import com.sayboard.exception.MsgException;

import java.util.List;


/**
 * @outhor moke
 * @date 2019-11-26
 */
public class MageService {
    MageDao mageDao = new MageDao();

    public void fabuMage(Mage mage,boolean flag) {
        if (flag){
            mageDao.addMage(mage);
        }else {
            throw new MsgException("此户名未注册");
        }
    }

    public void deleteMage(int deleteid) {
        mageDao.delMage(deleteid);
    }

    public List<Mage> xianshiByNameMag(String userName) {
        return mageDao.selectByNameMage(userName);
    }
}
