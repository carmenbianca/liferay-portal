/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.internal.notification.recipient;

import com.liferay.osgi.service.tracker.collections.map.ServiceReferenceMapper;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.workflow.kaleo.definition.RecipientType;
import com.liferay.portal.workflow.kaleo.runtime.notification.recipient.NotificationRecipientBuilder;
import com.liferay.portal.workflow.kaleo.runtime.notification.recipient.NotificationRecipientBuilderRegistry;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, service = NotificationRecipientBuilderRegistry.class
)
public class DefaultNotificationRecipientBuilderRegistry
	implements NotificationRecipientBuilderRegistry {

	@Override
	public NotificationRecipientBuilder getNotificationRecipientBuilder(
		RecipientType recipientType) {

		NotificationRecipientBuilder notificationRecipientBuilder =
			_notificationRecipientBuilders.getService(recipientType);

		if (notificationRecipientBuilder == null) {
			throw new IllegalArgumentException(
				"No notification recipient builder for " + recipientType);
		}

		return notificationRecipientBuilder;
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_notificationRecipientBuilders =
			ServiceTrackerMapFactory.openSingleValueMap(
				bundleContext, NotificationRecipientBuilder.class, null,
				new ServiceReferenceMapper
					<RecipientType, NotificationRecipientBuilder>() {

					@Override
					public void map(
						ServiceReference<NotificationRecipientBuilder>
							serviceReference,
						ServiceReferenceMapper.Emitter<RecipientType> emitter) {

						Object value = serviceReference.getProperty(
							"recipient.type");

						if (Validator.isNull(value)) {
							throw new IllegalArgumentException(
								"The property \"recipient.type\" is invalid " +
									"for " + serviceReference);
						}

						emitter.emit(
							RecipientType.valueOf(String.valueOf(value)));
					}

				});
	}

	@Deactivate
	protected void deactivate() {
		_notificationRecipientBuilders.close();
	}

	private ServiceTrackerMap<RecipientType, NotificationRecipientBuilder>
		_notificationRecipientBuilders;

}