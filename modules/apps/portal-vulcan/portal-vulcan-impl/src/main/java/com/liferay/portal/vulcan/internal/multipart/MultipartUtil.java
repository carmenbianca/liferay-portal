/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.multipart;

import javax.servlet.http.Part;

import javax.ws.rs.core.HttpHeaders;

/**
 * @author Javier Gamarra
 */
public class MultipartUtil {

	public static String getFileName(Part part) {
		String header = part.getHeader(HttpHeaders.CONTENT_DISPOSITION);

		if (header == null) {
			return part.getName();
		}

		String string = "filename=\"";

		int index = header.indexOf(string);

		if (index == -1) {
			return null;
		}

		return header.substring(index + string.length(), header.length() - 1);
	}

}