/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.cache.multiple.internal.portal.profile;

import com.liferay.portal.cache.PortalCacheReplicatorFactory;
import com.liferay.portal.cache.multiple.internal.ClusterLinkPortalCacheReplicatorFactory;
import com.liferay.portal.cache.multiple.internal.PortalCacheManagerUtil;
import com.liferay.portal.cache.multiple.internal.cluster.link.ClusterLinkPortalCacheClusterChannelFactory;
import com.liferay.portal.cache.multiple.internal.cluster.link.PortalCacheClusterLink;
import com.liferay.portal.cache.multiple.internal.cluster.link.messaging.ClusterLinkMessagingConfigurator;
import com.liferay.portal.cache.multiple.internal.cluster.link.messaging.ClusterLinkPortalCacheClusterListener;
import com.liferay.portal.kernel.cluster.ClusterLink;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.ProxyFactory;
import com.liferay.portal.profile.BaseDSModulePortalProfile;
import com.liferay.portal.profile.PortalProfile;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = PortalProfile.class)
public class ModulePortalProfile extends BaseDSModulePortalProfile {

	@Activate
	protected void activate(ComponentContext componentContext) {
		Set<String> supportedPortalProfileNames = null;

		if (_clusterLink.isEnabled()) {
			supportedPortalProfileNames = new HashSet<>();

			supportedPortalProfileNames.add(
				PortalProfile.PORTAL_PROFILE_NAME_CE);
			supportedPortalProfileNames.add(
				PortalProfile.PORTAL_PROFILE_NAME_DXP);
		}
		else {
			supportedPortalProfileNames = Collections.emptySet();

			BundleContext bundleContext = componentContext.getBundleContext();

			bundleContext.registerService(
				PortalCacheReplicatorFactory.class,
				ProxyFactory.newDummyInstance(
					PortalCacheReplicatorFactory.class),
				new HashMapDictionary<>());
		}

		init(
			componentContext, supportedPortalProfileNames,
			ClusterLinkMessagingConfigurator.class.getName(),
			ClusterLinkPortalCacheClusterChannelFactory.class.getName(),
			ClusterLinkPortalCacheClusterListener.class.getName(),
			ClusterLinkPortalCacheReplicatorFactory.class.getName(),
			PortalCacheClusterLink.class.getName(),
			PortalCacheManagerUtil.class.getName());
	}

	@Reference
	private ClusterLink _clusterLink;

}