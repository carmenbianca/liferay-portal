/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upload.constants;

/**
 * @author Pei-Jung Lan
 */
public class LegacyUploadServletRequestPropsKeys {

	public static final String[] UPLOAD_SERVLET_REQUEST_IMPL_KEYS = {
		LegacyUploadServletRequestPropsKeys.
			UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE,
		LegacyUploadServletRequestPropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_TEMP_DIR
	};

	public static final String UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE =
		"com.liferay.portal.upload.UploadServletRequestImpl.max.size";

	public static final String UPLOAD_SERVLET_REQUEST_IMPL_TEMP_DIR =
		"com.liferay.portal.upload.UploadServletRequestImpl.temp.dir";

}