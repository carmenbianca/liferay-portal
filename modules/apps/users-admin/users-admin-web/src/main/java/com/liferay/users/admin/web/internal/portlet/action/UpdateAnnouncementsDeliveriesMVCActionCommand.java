/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.portlet.action;

import com.liferay.announcements.kernel.model.AnnouncementsDelivery;
import com.liferay.announcements.kernel.model.AnnouncementsEntryConstants;
import com.liferay.announcements.kernel.service.AnnouncementsDeliveryLocalService;
import com.liferay.announcements.kernel.service.AnnouncementsDeliveryService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.announcements.model.impl.AnnouncementsDeliveryImpl;
import com.liferay.users.admin.constants.UsersAdminPortletKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + UsersAdminPortletKeys.MY_ACCOUNT,
		"javax.portlet.name=" + UsersAdminPortletKeys.MY_ORGANIZATIONS,
		"javax.portlet.name=" + UsersAdminPortletKeys.USERS_ADMIN,
		"mvc.command.name=/users_admin/update_announcements_deliveries"
	},
	service = MVCActionCommand.class
)
public class UpdateAnnouncementsDeliveriesMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		User user = _portal.getSelectedUser(actionRequest);

		List<AnnouncementsDelivery> announcementsDeliveries =
			getAnnouncementsDeliveries(actionRequest, user);

		for (AnnouncementsDelivery announcementsDelivery :
				announcementsDeliveries) {

			_announcementsDeliveryService.updateDelivery(
				user.getUserId(), announcementsDelivery.getType(),
				announcementsDelivery.isEmail(), announcementsDelivery.isSms());
		}

		String redirect = _portal.escapeRedirect(
			ParamUtil.getString(actionRequest, "redirect"));

		if (Validator.isNotNull(redirect)) {
			sendRedirect(actionRequest, actionResponse, redirect);
		}
	}

	protected List<AnnouncementsDelivery> getAnnouncementsDeliveries(
		ActionRequest actionRequest) {

		List<AnnouncementsDelivery> announcementsDeliveries = new ArrayList<>();

		for (String type : AnnouncementsEntryConstants.TYPES) {
			boolean email = ParamUtil.getBoolean(
				actionRequest, "announcementsType" + type + "Email");
			boolean sms = ParamUtil.getBoolean(
				actionRequest, "announcementsType" + type + "Sms");

			AnnouncementsDelivery announcementsDelivery =
				new AnnouncementsDeliveryImpl();

			announcementsDelivery.setType(type);
			announcementsDelivery.setEmail(email);
			announcementsDelivery.setSms(sms);

			announcementsDeliveries.add(announcementsDelivery);
		}

		return announcementsDeliveries;
	}

	protected List<AnnouncementsDelivery> getAnnouncementsDeliveries(
			ActionRequest actionRequest, User user)
		throws Exception {

		String email = actionRequest.getParameter(
			"announcementsType" + AnnouncementsEntryConstants.TYPES[0] +
				"Email");

		if (email == null) {
			return _announcementsDeliveryLocalService.getUserDeliveries(
				user.getUserId());
		}

		return getAnnouncementsDeliveries(actionRequest);
	}

	@Reference
	private AnnouncementsDeliveryLocalService
		_announcementsDeliveryLocalService;

	@Reference
	private AnnouncementsDeliveryService _announcementsDeliveryService;

	@Reference
	private Portal _portal;

}