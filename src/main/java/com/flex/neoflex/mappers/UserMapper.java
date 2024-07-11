//package com.flex.neoflex.mappers;
//
//import com.flex.neoflex.models.User;
//import org.springframework.stereotype.Component;
//
//import javax.swing.tree.RowMapper;
//import javax.swing.tree.TreePath;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Component
//public class UserMapper implements RowMapper<User> {
//
//	@Override
//	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//		return new User(
//				rs.getInt("id"),
//				rs.getString("name"),
//				rs.getString("lastname"),
//				rs.getInt("email")
//		);
//	}
//
//	@Override
//	public int[] getRowsForPaths(TreePath[] path) {
//		return new int[0];
//	}
//}