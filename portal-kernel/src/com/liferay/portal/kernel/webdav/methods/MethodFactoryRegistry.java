/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.webdav.methods;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public interface MethodFactoryRegistry {

	public MethodFactory getDefaultMethodFactory();

	public List<MethodFactory> getMethodFactories();

	public MethodFactory getMethodFactory(String className);

	public void registerMethodFactory(MethodFactory methodFactory);

	public void unregisterMethodFactory(MethodFactory methodFactory);

}