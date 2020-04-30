/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * @author Brian Wing Shun Chan
 */
public class NullServletOutputStream extends ServletOutputStream {

	@Override
	public boolean isReady() {
		return true;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
	}

	@Override
	public void write(int b) {
	}

}