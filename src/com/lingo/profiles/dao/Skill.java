package com.lingo.profiles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lingo.profiles.bean.ListResult;
import com.lingo.profiles.bean.Result;
import com.lingo.profiles.bean.TResult;
import com.lingo.profiles.common.LingoLogger;

public class Skill {
	
	/**
	 * add skill info
	 * @param data
	 * @return
	 */
	public Result add(com.lingo.profiles.bean.Skill data)
	{
		LingoLogger.logger.info("dao level: add skill info start...");
		Result result = new Result();
		
		try
		{
			String sql = "insert into Profiles.Skill(PID,SCID,Title,Content,AddDate,UpdateDate) values(?,?,?,?,?,?);";
			Object [] objs = new Object[]{data.getPid(),data.getScid(),data.getTitle(),data.getContent(),new Date(), new Date()};
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		}
		catch(Exception e)
		{
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}
		
		LingoLogger.logger.info("dao level: add skill info end.");
		return result;
	}
	
	/**
	 * update skill info
	 * @param data
	 * @return
	 */
	public Result update(com.lingo.profiles.bean.Skill data)
	{
		LingoLogger.logger.info("dao level: update skill info start...");
		Result result = new Result();
		
		try
		{
			String sql = "update Profiles.Skill set SCID=?, Title=?,Content=?,UpdateDate=? where ID=?";
			Object [] objs = new Object[]{data.getScid(),data.getTitle(),data.getContent(),new Date(),data.getId()};
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		}
		catch(Exception e)
		{
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}
		
		LingoLogger.logger.info("dao level: update skill info end.");
		return result;		
	}
	
	/**
	 * delete skill info
	 * @param data
	 * @return
	 */
	public Result delete(com.lingo.profiles.bean.Skill data)
	{
		LingoLogger.logger.info("dao level: delete skill info start...");
		Result result = new Result();
		
		try
		{
			String sql = "delete from Profiles.Skill where ID=?";
			Object [] objs = new Object[]{data.getId()};
			int res = DBHelper.executeNonQuery(sql, objs);
			result.setResult(res);
		}
		catch(Exception e)
		{
			LingoLogger.logger.error(e.getMessage());
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		}
		
		LingoLogger.logger.info("dao level: delete skill info end.");
		return result;		
	}
	
	/**
	 * get skill model
	 * @param data
	 * @return
	 */
	public TResult<com.lingo.profiles.bean.Skill> getModel(com.lingo.profiles.bean.Skill data)
	{
		LingoLogger.logger.info("dao level: get skill model info start...");
		TResult<com.lingo.profiles.bean.Skill> result = new TResult<com.lingo.profiles.bean.Skill>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.Skill where ID=?";
			Object[] objs = new Object[] { data.getId() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			// if it has result
			if (rs.next()) {
				data.setPid(rs.getInt("PID"));
				data.setTitle(rs.getString("Title"));
				data.setContent(rs.getString("Content"));
				data.setScid(rs.getInt("SCID"));
				
				result.setResult(1);
				result.setT(data);
			} else {
				result.setResult(0);
				result.setMessage("not found record!");
			}
		} catch (SQLException e) {
			LingoLogger.logger.error(e);
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			LingoLogger.logger.error(e);
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		} finally {
			PoolManager.free(rs, pstmt, conn);
		}

		LingoLogger.logger.info("dao level: get skill model info end.");
		return result;
	}
	
	/**
	 * get skill list by pid
	 * @param data
	 * @return
	 */
	public ListResult<com.lingo.profiles.bean.Skill> getList(com.lingo.profiles.bean.Skill data)
	{
		LingoLogger.logger.info("dao level: get skill list info start...");
		ListResult<com.lingo.profiles.bean.Skill> result = new ListResult<com.lingo.profiles.bean.Skill>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Profiles.Skill where PID=?";
			Object[] objs = new Object[] { data.getPid() };

			conn = PoolManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			List<com.lingo.profiles.bean.Skill> list = new ArrayList<com.lingo.profiles.bean.Skill>();
			
			// if it has result
			while (rs.next()) {				
				int id = rs.getInt("ID");
				int scid = rs.getInt("SCID");
				String title = rs.getString("Title");
				String content = rs.getString("Content");
				com.lingo.profiles.bean.Skill skill = new com.lingo.profiles.bean.Skill(id, data.getPid(),scid, title, content);
				list.add(skill);
			}
			rs.close();
			result.setResult(1);
			result.setList(list);
			
		} catch (SQLException e) {
			LingoLogger.logger.error(e);
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		} catch (Exception e) {
			LingoLogger.logger.error(e);
			e.printStackTrace();
			result.setResult(0);
			result.setMessage(e.getMessage());
		} finally {
			PoolManager.free(rs, pstmt, conn);
		}
		
		LingoLogger.logger.info("dao level: get skill list info end.");
		return result;
	}
}
