/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.plugin;

/**
 * @author Jorge Ferrer
 */
public class Screenshot {

	public String getLargeImageURL() {
		return _largeImageURL;
	}

	public String getThumbnailURL() {
		return _thumbnailURL;
	}

	public void setLargeImageURL(String largeImageURL) {
		_largeImageURL = largeImageURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		_thumbnailURL = thumbnailURL;
	}

	private String _largeImageURL;
	private String _thumbnailURL;

}