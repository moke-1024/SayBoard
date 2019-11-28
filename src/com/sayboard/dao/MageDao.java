package com.sayboard.dao;

import com.sayboard.domain.Mage;
import com.sayboard.utils.JDBCUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @outhor moke
 * @date 2019-11-26
 */
public class MageDao {

    public void addMage(Mage mage) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert into mage values(null,?,?,?,?)");
            ps.setString(1, mage.getSendname());
            ps.setString(2, mage.getTime());
            ps.setString(3, mage.getAcceptname());
            ps.setString(4, mage.getSay());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(conn,ps,null);
        }
    }

    public void delMage(int deleteid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("delete from mage where id = ?");
            ps.setInt(1, deleteid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
    }

    public List<Mage> selectByNameMage(String userName) {
        List mages = new ArrayList<Mage>();
        String allname = "所有人";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from mage where acceptname = ? or acceptname = ? ");
            ps.setString(1,userName);
            ps.setString(2,allname);
            rs = ps.executeQuery();
            while (rs.next()){
                Mage mage = new Mage();
                mage.setId(rs.getInt(1));
                mage.setSendname(rs.getString(2));
                mage.setTime(rs.getString(3));
                mage.setAcceptname(rs.getString(4));
                mage.setSay(rs.getString(5));
                mages.add(mage);
            }
            return mages;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(conn,ps,null);
        }
    }
}
