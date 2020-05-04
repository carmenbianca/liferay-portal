/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.template.util;

import com.liferay.layout.util.template.LayoutConverter;
import com.liferay.layout.util.template.LayoutConverterRegistry;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = LayoutConverterRegistry.class)
public class LayoutConverterRegistryImpl implements LayoutConverterRegistry {

	@Override
	public LayoutConverter getLayoutConverter(String layoutTemplateId) {
		LayoutConverter layoutConverter = _layoutConverters.getService(
			layoutTemplateId);

		if (layoutConverter == null) {
			layoutConverter = _defaultLayoutConverter;
		}

		return layoutConverter;
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_layoutConverters = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, LayoutConverter.class, "layout.template.id");
	}

	@Reference(target = "(layout.template.id=default)")
	private LayoutConverter _defaultLayoutConverter;

	private ServiceTrackerMap<String, LayoutConverter> _layoutConverters;

}