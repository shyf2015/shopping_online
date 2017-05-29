package com.hello.dao;

import com.hello.beans.Pager;
import com.hello.beans.Picture;

public interface PictureDao {
	Picture query(int goodsid);
	public void addPicture(Picture picture);
	public int getDataCount();
	public Pager getPager(int currPage, int pageSize);
	public void updatePicture(Picture picture);
	public Picture findPictureById(int pictureid);
	public void deletePicture(int pictureid);
}
