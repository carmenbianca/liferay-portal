/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.journal.constants.JournalConstants;
import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.journal.model.JournalFeed;
import com.liferay.journal.service.JournalFeedLocalService;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Preston Crary
 */
@Component(immediate = true, service = {})
public class JournalFeedModelResourcePermissionRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("model.class.name", JournalFeed.class.getName());

		_serviceRegistration = bundleContext.registerService(
			ModelResourcePermission.class,
			ModelResourcePermissionFactory.create(
				JournalFeed.class, JournalFeed::getId,
				_journalFeedLocalService::getJournalFeed,
				_portletResourcePermission,
				(modelResourcePermission, consumer) -> consumer.accept(
					new StagedModelPermissionLogic<>(
						_stagingPermission, JournalPortletKeys.JOURNAL,
						JournalFeed::getId))),
			properties);
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference
	private JournalFeedLocalService _journalFeedLocalService;

	@Reference(
		target = "(resource.name=" + JournalConstants.RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;

	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

	@Reference
	private StagingPermission _stagingPermission;

}