package com.kosa.ucr.wishlist.control;

import com.kosa.ucr.control.Controller;
import com.kosa.ucr.wishlist.service.WishlistService;

public abstract class WishlistController implements Controller {
	protected WishlistService service;
	public WishlistController() {
		service = WishlistService.getInstance();
	} //singleton으로 맞추면서 만든 메서드 가져옴
}
