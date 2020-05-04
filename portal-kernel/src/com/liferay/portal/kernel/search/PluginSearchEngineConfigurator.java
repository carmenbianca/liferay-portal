/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;

/**
 * @author Michael C. Han
 */
public class PluginSearchEngineConfigurator
	extends BaseSearchEngineConfigurator {

	public void setDefaultSearchEngineId(String defaultSearchEngineId) {
		_defaultSearchEngineId = defaultSearchEngineId;
	}

	@Override
	protected String getDefaultSearchEngineId() {
		return _defaultSearchEngineId;
	}

	@Override
	protected IndexSearcher getIndexSearcher() {
		BeanLocator beanLocator = PortalBeanLocatorUtil.getBeanLocator();

		return (IndexSearcher)beanLocator.locate(
			IndexSearcherProxyBean.class.getName());
	}

	@Override
	protected IndexWriter getIndexWriter() {
		BeanLocator beanLocator = PortalBeanLocatorUtil.getBeanLocator();

		return (IndexWriter)beanLocator.locate(
			IndexWriterProxyBean.class.getName());
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getOperatingClassLoader()}
	 */
	@Deprecated
	@Override
	protected ClassLoader getOperatingClassloader() {
		return getOperatingClassLoader();
	}

	@Override
	protected ClassLoader getOperatingClassLoader() {
		return PortletClassLoaderUtil.getClassLoader();
	}

	@Override
	protected SearchEngineHelper getSearchEngineHelper() {
		return SearchEngineHelperUtil.getSearchEngineHelper();
	}

	private String _defaultSearchEngineId;

}