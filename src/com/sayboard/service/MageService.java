package com.sayboard.service;

import com.sayboard.dao.MageDao;
import com.sayboard.domain.Mage;

import java.util.ArrayList;

/**
 * @outhor moke
 * @date 2019-11-26
 */
public class MageService {
    MageDao mageDao = new MageDao();

    public void fabuMage(Mage mage) {
        mageDao.addMage(mage);
    }


    public ArrayList<Mage> xianshiMag() {
        return mageDao.selectMage();
    }
}
