/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.rest.internal.spi.bearer.token.provider;

import com.liferay.oauth2.provider.rest.spi.bearer.token.provider.BearerTokenProvider;
import com.liferay.oauth2.provider.rest.spi.bearer.token.provider.BearerTokenProviderAccessor;
import com.liferay.oauth2.provider.scope.liferay.ScopedServiceTrackerMap;
import com.liferay.oauth2.provider.scope.liferay.ScopedServiceTrackerMapFactory;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Tomas Polesovsky
 */
@Component(immediate = true, service = BearerTokenProviderAccessor.class)
public class DefaultBearerTokenProviderAccessor
	implements BearerTokenProviderAccessor {

	@Override
	public BearerTokenProvider getBearerTokenProvider(
		long companyId, String clientId) {

		return _scopedServiceTrackerMap.getService(companyId, clientId);
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_scopedServiceTrackerMap = _scopedServiceTrackerMapFactory.create(
			bundleContext, BearerTokenProvider.class,
			"liferay.oauth2.client.id", () -> _defaultBearerTokenProvider);
	}

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY, target = "(name=default)"
	)
	private volatile BearerTokenProvider _defaultBearerTokenProvider;

	private ScopedServiceTrackerMap<BearerTokenProvider>
		_scopedServiceTrackerMap;

	@Reference
	private ScopedServiceTrackerMapFactory _scopedServiceTrackerMapFactory;

}