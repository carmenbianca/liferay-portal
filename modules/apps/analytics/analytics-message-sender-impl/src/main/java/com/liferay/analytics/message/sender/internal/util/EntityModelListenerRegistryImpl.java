/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.message.sender.internal.util;

import com.liferay.analytics.message.sender.model.EntityModelListener;
import com.liferay.analytics.message.sender.util.EntityModelListenerRegistry;
import com.liferay.osgi.service.tracker.collections.map.ServiceReferenceMapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.model.BaseModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import java.util.Collection;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Rachael Koestartyo
 */
@Component(immediate = true, service = EntityModelListenerRegistry.class)
public class EntityModelListenerRegistryImpl
	implements EntityModelListenerRegistry {

	@Override
	public EntityModelListener getEntityModelListener(String className) {
		return _serviceTrackerMap.getService(className);
	}

	@Override
	public Collection<EntityModelListener> getEntityModelListeners() {
		return _serviceTrackerMap.values();
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, EntityModelListener.class, null,
			new EntityModelListenerServiceReferenceMapper());
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	private BundleContext _bundleContext;
	private ServiceTrackerMap<String, EntityModelListener> _serviceTrackerMap;

	private class EntityModelListenerServiceReferenceMapper
		<T extends BaseModel<T>>
			implements ServiceReferenceMapper<String, EntityModelListener<T>> {

		@Override
		public void map(
			ServiceReference<EntityModelListener<T>> serviceReference,
			Emitter<String> emitter) {

			EntityModelListener entityModelListener = _bundleContext.getService(
				serviceReference);

			Class<?> clazz = _getParameterizedClass(
				entityModelListener.getClass());

			try {
				emitter.emit(clazz.getName());
			}
			finally {
				_bundleContext.ungetService(serviceReference);
			}
		}

		private Class<?> _getParameterizedClass(Class<?> clazz) {
			ParameterizedType parameterizedType =
				(ParameterizedType)clazz.getGenericSuperclass();

			Type[] types = parameterizedType.getActualTypeArguments();

			return (Class<?>)types[0];
		}

	}

}