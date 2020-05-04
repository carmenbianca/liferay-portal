/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.notifications.internal.notifications;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseModelUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.sharing.constants.SharingPortletKeys;
import com.liferay.sharing.model.SharingEntry;
import com.liferay.sharing.service.SharingEntryLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + SharingPortletKeys.SHARING,
	service = UserNotificationHandler.class
)
public class SharingUserNotificationHandler
	extends BaseModelUserNotificationHandler {

	public SharingUserNotificationHandler() {
		setPortletId(SharingPortletKeys.SHARING);
	}

	@Override
	protected String getBody(
			UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext)
		throws Exception {

		JSONObject userNotificationEventPayloadJSONObject =
			JSONFactoryUtil.createJSONObject(
				userNotificationEvent.getPayload());

		SharingEntry sharingEntry = _sharingEntryLocalService.fetchSharingEntry(
			userNotificationEventPayloadJSONObject.getLong("classPK"));

		if (sharingEntry == null) {
			_userNotificationEventLocalService.deleteUserNotificationEvent(
				userNotificationEvent.getUserNotificationEventId());

			return null;
		}

		AssetRenderer<?> assetRenderer = getAssetRenderer(
			sharingEntry.getClassName(), sharingEntry.getClassPK());

		if ((assetRenderer == null) ||
			_isInTrash(
				sharingEntry.getClassName(), sharingEntry.getClassPK())) {

			_userNotificationEventLocalService.deleteUserNotificationEvent(
				userNotificationEvent.getUserNotificationEventId());

			return null;
		}

		String message = userNotificationEventPayloadJSONObject.getString(
			"message");

		if (Validator.isNull(message)) {
			_userNotificationEventLocalService.deleteUserNotificationEvent(
				userNotificationEvent);
		}

		return message;
	}

	private boolean _isInTrash(String className, long classPK)
		throws PortalException {

		TrashHandler trashHandler = TrashHandlerRegistryUtil.getTrashHandler(
			className);

		if (trashHandler == null) {
			return false;
		}

		return trashHandler.isInTrash(classPK);
	}

	@Reference
	private SharingEntryLocalService _sharingEntryLocalService;

	@Reference
	private UserNotificationEventLocalService
		_userNotificationEventLocalService;

}