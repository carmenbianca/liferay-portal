/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upload;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Igor Spasic
 */
public class UploadException extends PortalException {

	public UploadException() {
	}

	public UploadException(String msg) {
		super(msg);
	}

	public UploadException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UploadException(Throwable cause) {
		super(cause);
	}

	public boolean isExceededFileSizeLimit() {
		return _exceededFileSizeLimit;
	}

	public boolean isExceededLiferayFileItemSizeLimit() {
		return _exceededLiferayFileItemSizeLimit;
	}

	public boolean isExceededUploadRequestSizeLimit() {
		return _exceededUploadRequestSizeLimit;
	}

	public void setExceededFileSizeLimit(boolean exceededFileSizeLimit) {
		_exceededFileSizeLimit = exceededFileSizeLimit;
	}

	public void setExceededLiferayFileItemSizeLimit(
		boolean exceededLiferayFileItemSizeLimit) {

		_exceededLiferayFileItemSizeLimit = exceededLiferayFileItemSizeLimit;
	}

	public void setExceededUploadRequestSizeLimit(
		boolean exceededUploadRequestSizeLimit) {

		_exceededUploadRequestSizeLimit = exceededUploadRequestSizeLimit;
	}

	private boolean _exceededFileSizeLimit;
	private boolean _exceededLiferayFileItemSizeLimit;
	private boolean _exceededUploadRequestSizeLimit;

}