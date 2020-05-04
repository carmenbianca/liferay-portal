/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.versioning;

import com.liferay.document.library.configuration.DLConfiguration;
import com.liferay.document.library.kernel.model.DLFileVersion;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.versioning.VersioningStrategy;
import com.liferay.document.library.versioning.VersioningPolicy;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerList;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerListFactory;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;
import java.util.Optional;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Adolfo Pérez
 */
@Component(
	configurationPid = "com.liferay.document.library.configuration.DLConfiguration",
	service = VersioningStrategy.class
)
public class VersioningPolicyVersioningStrategy implements VersioningStrategy {

	@Override
	public DLVersionNumberIncrease computeDLVersionNumberIncrease(
		DLFileVersion previousDLFileVersion, DLFileVersion nextDLFileVersion) {

		for (VersioningPolicy versioningPolicy : _serviceTrackerList) {
			Optional<DLVersionNumberIncrease> dlVersionNumberIncreaseOptional =
				versioningPolicy.computeDLVersionNumberIncrease(
					previousDLFileVersion, nextDLFileVersion);

			if (dlVersionNumberIncreaseOptional.isPresent()) {
				return dlVersionNumberIncreaseOptional.get();
			}
		}

		return DLVersionNumberIncrease.NONE;
	}

	@Override
	public boolean isOverridable() {
		return _dlConfiguration.versioningStrategyOverridable();
	}

	@Activate
	@Modified
	protected void activate(
		BundleContext bundleContext, Map<String, Object> properties) {

		_dlConfiguration = ConfigurableUtil.createConfigurable(
			DLConfiguration.class, properties);
		_serviceTrackerList = ServiceTrackerListFactory.open(
			bundleContext, VersioningPolicy.class);
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerList.close();
	}

	private volatile DLConfiguration _dlConfiguration;
	private ServiceTrackerList<VersioningPolicy, VersioningPolicy>
		_serviceTrackerList;

}