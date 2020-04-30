/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resource;

import java.io.InputStream;

/**
 * @author Shuyang Zhou
 */
public interface ResourceRetriever {

	public InputStream getInputStream();

}