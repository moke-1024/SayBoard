package com.sayboard.dao;

import com.sayboard.domain.Mage;
import com.sayboard.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
