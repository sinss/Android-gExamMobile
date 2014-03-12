package com.perfectidea.exam.enumeration;

public enum FavoriteCategory {
	all, favorite, error;

	public Integer toInt() {
		switch (this) {
		case all:
			return 0;
		case favorite:
			return 1;
		case error:
			return 2;
		default:
			return 1;
		}
	}
}
