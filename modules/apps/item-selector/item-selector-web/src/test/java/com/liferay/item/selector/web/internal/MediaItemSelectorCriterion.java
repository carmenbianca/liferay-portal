/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.web.internal;

import com.liferay.item.selector.BaseItemSelectorCriterion;

/**
 * @author Iván Zaera
 */
public class MediaItemSelectorCriterion extends BaseItemSelectorCriterion {

	public String getFileExtension() {
		return _fileExtension;
	}

	public long getMaxSize() {
		return _maxSize;
	}

	public void setFileExtension(String fileExtension) {
		_fileExtension = fileExtension;
	}

	public void setMaxSize(long maxSize) {
		_maxSize = maxSize;
	}

	private String _fileExtension = "*";
	private long _maxSize = -1;

}