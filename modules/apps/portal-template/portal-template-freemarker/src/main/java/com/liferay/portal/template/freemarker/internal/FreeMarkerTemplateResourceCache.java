/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.freemarker.internal;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.SingleVMPool;
import com.liferay.portal.template.BaseTemplateResourceCache;
import com.liferay.portal.template.freemarker.configuration.FreeMarkerEngineConfiguration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tina Tian
 */
@Component(
	configurationPid = "com.liferay.portal.template.freemarker.configuration.FreeMarkerEngineConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
	service = FreeMarkerTemplateResourceCache.class
)
public class FreeMarkerTemplateResourceCache extends BaseTemplateResourceCache {

	@Activate
	protected void activate(Map<String, Object> properties) {
		FreeMarkerEngineConfiguration freeMarkerEngineConfiguration =
			ConfigurableUtil.createConfigurable(
				FreeMarkerEngineConfiguration.class, properties);

		init(
			freeMarkerEngineConfiguration.resourceModificationCheck(),
			_multiVMPool, _singleVMPool, _PORTAL_CACHE_NAME);
	}

	@Deactivate
	protected void deactivate() {
		destroy();
	}

	private static final String _PORTAL_CACHE_NAME =
		FreeMarkerTemplateResourceCache.class.getName();

	@Reference
	private MultiVMPool _multiVMPool;

	@Reference
	private SingleVMPool _singleVMPool;

}