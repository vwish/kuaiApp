package com.example.data;

import com.example.model.User;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "User.db";
	private static final int DATABASE_VERSION = 1;
	private static final String USER_TABLE = "Users";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		String userSql = "CREATE TABLE " + USER_TABLE + " ( userId text," + "userName text ," + "userpassword text," + "userPhonenumber text," + "userScore text," + "userAddress text," + "userImageUrl text," + "userRegistertime text" + ");";
		db.execSQL(userSql);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public void insertUser(User user) {
		SQLiteDatabase db = this.getWritableDatabase();

		String insertUserSql = "insert into " + USER_TABLE + " values ('" + user.getUserId() + "','" + user.getUserName() + "','" + user.getUserpassword() +

		"','" + user.getUserPhonenumber() + "','" + user.getUserScore() + "','" + user.getUserAddress() + "','" + user.getUserImageUrl() + "','" + user.getUserRegistertime() + "');";
		try {
			db.execSQL(insertUserSql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 删除其中的一条数据
	 */
	public void deleteItem() {
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			String sql = "delete from " + USER_TABLE;
			db.execSQL(sql);
		}
		catch (SQLException e) {
		}
	}

	/**
	 * 查询用户电话
	 * 
	 * @return
	 */
	public String queryphonenumber() {
		String name = null;
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery("select * from " + USER_TABLE, null);
			while (cursor.moveToNext()) {
				name = cursor.getString(0);// 获取第一列的值
			}
			cursor.close();
			db.close();
			return name;
		}
		catch (SQLException e) {
		}
		return name;
	}

	public int query() {
		try {
			SQLiteDatabase db = this.getWritableDatabase();
			String col[] = { "userId" };
			Cursor cursor = db.query(USER_TABLE, col, null, null, null, null, null);
			return cursor.getCount();
		}
		catch (SQLException e) {
			return 0;
		}
	}
}
