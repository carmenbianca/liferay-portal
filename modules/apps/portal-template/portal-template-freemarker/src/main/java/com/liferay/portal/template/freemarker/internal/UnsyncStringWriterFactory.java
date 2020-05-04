/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.freemarker.internal;

import com.liferay.petra.io.unsync.UnsyncStringWriter;

import freemarker.ext.jsp.internal.WriterFactory;

import java.io.Writer;

/**
 * @author Preston Crary
 */
public class UnsyncStringWriterFactory implements WriterFactory {

	@Override
	public Writer createWriter() {
		return new UnsyncStringWriter();
	}

}