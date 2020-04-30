/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resource;

/**
 * @author Shuyang Zhou
 */
public class ContextClassLoaderResourceRetriever
	extends ClassLoaderResourceRetriever {

	public ContextClassLoaderResourceRetriever(String fileName) {
		super(Thread.currentThread().getContextClassLoader(), fileName);
	}

}