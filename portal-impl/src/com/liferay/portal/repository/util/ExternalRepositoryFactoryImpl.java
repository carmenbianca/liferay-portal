/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.repository.util;

import com.liferay.portal.kernel.repository.BaseRepository;
import com.liferay.portal.kernel.repository.proxy.BaseRepositoryProxyBean;
import com.liferay.portal.kernel.util.AggregateClassLoader;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyFactory;

/**
 * @author Adolfo Pérez
 * @author Mika Koivisto
 */
public class ExternalRepositoryFactoryImpl
	implements ExternalRepositoryFactory {

	public ExternalRepositoryFactoryImpl(String className) {
		_className = className;
	}

	public ExternalRepositoryFactoryImpl(
		String className, ClassLoader classLoader) {

		_className = className;

		_classLoader = AggregateClassLoader.getAggregateClassLoader(
			PortalClassLoaderUtil.getClassLoader(), classLoader);
	}

	@Override
	public BaseRepository getInstance() throws Exception {
		if (_classLoader == null) {
			return (BaseRepository)InstanceFactory.newInstance(_className);
		}

		BaseRepository baseRepository =
			(BaseRepository)ProxyFactory.newInstance(
				_classLoader, BaseRepository.class, _className);

		return new BaseRepositoryProxyBean(baseRepository, _classLoader);
	}

	private ClassLoader _classLoader;
	private final String _className;

}