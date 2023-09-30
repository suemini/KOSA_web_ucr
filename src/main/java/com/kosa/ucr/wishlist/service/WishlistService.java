package com.kosa.ucr.wishlist.service;

import com.kosa.ucr.exception.AddException;
import com.kosa.ucr.exception.RemoveException;
import com.kosa.ucr.wishlist.dao.WishlistOracleMybatisRepository;
import com.kosa.ucr.wishlist.dao.WishlistRepository;

public class WishlistService {
	private WishlistRepository repository;
	//wishlistService singleton으로 맞춰줌
	private static WishlistService service = new WishlistService();
	private WishlistService() {
		repository = new WishlistOracleMybatisRepository();
	}
	public static WishlistService getInstance() {
		return service;
	}
	
	public void addWishlist(String coCode, int stuId) throws AddException {
		repository.insertWishlist(coCode, stuId);
	}
	
	public void removeWishlist(String coCode, int stuId) throws RemoveException{
		repository.deleteWishlist(coCode, stuId);
	}
}
