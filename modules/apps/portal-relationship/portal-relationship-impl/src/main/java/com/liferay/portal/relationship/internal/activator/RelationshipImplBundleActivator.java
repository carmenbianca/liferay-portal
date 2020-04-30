/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.relationship.internal.activator;

import com.liferay.portal.relationship.RelationshipManager;
import com.liferay.portal.relationship.RelationshipManagerUtil;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Máté Thurzó
 */
public class RelationshipImplBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		_serviceTracker =
			new ServiceTracker<RelationshipManager, RelationshipManager>(
				bundleContext, RelationshipManager.class.getName(), null) {

				@Override
				public RelationshipManager addingService(
					ServiceReference<RelationshipManager> serviceReference) {

					RelationshipManager relationshipManager =
						bundleContext.getService(serviceReference);

					RelationshipManagerUtil.setRelationshipManager(
						relationshipManager);

					return relationshipManager;
				}

			};

		_serviceTracker.open();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		_serviceTracker.close();
	}

	private ServiceTracker<RelationshipManager, RelationshipManager>
		_serviceTracker;

}