/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.ehcache.internal.event;

import com.liferay.portal.cache.PortalCacheManagerListenerFactory;
import com.liferay.portal.cache.ehcache.internal.EhcacheConstants;
import com.liferay.portal.cache.ehcache.internal.EhcachePortalCacheManager;
import com.liferay.portal.kernel.cache.PortalCacheManagerListener;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.Validator;

import java.util.Properties;

import net.sf.ehcache.event.CacheManagerEventListenerFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = PortalCacheManagerListenerFactory.class)
public class EhcachePortalCacheManagerListenerFactory
	implements PortalCacheManagerListenerFactory
		<EhcachePortalCacheManager<?, ?>> {

	@Override
	public PortalCacheManagerListener create(
		EhcachePortalCacheManager<?, ?> ehcachePortalCacheManager,
		Properties properties) {

		String className = (String)properties.remove(
			EhcacheConstants.
				CACHE_MANAGER_LISTENER_PROPERTIES_KEY_FACTORY_CLASS_NAME);

		if (Validator.isNull(className)) {
			return null;
		}

		ClassLoader classLoader = (ClassLoader)properties.remove(
			EhcacheConstants.
				CACHE_MANAGER_LISTENER_PROPERTIES_KEY_FACTORY_CLASS_LOADER);

		if (classLoader == null) {
			return null;
		}

		try {
			CacheManagerEventListenerFactory cacheManagerEventListenerFactory =
				(CacheManagerEventListenerFactory)InstanceFactory.newInstance(
					classLoader, className);

			return new EhcachePortalCacheManagerListenerAdapter(
				cacheManagerEventListenerFactory.
					createCacheManagerEventListener(
						ehcachePortalCacheManager.getEhcacheManager(),
						properties));
		}
		catch (Exception exception) {
			throw new SystemException(
				"Unable to instantiate cache manager event listener " +
					className,
				exception);
		}
	}

}