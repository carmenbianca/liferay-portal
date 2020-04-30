/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.template;

import java.io.Externalizable;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Tina Tian
 */
public interface TemplateResource extends Externalizable {

	public long getLastModified();

	public Reader getReader() throws IOException;

	public String getTemplateId();

}