/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.invitation.invite.members.internal.events;

import com.liferay.invitation.invite.members.service.MemberRequestLocalService;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(
	immediate = true, property = "key=" + PropsKeys.LOGIN_EVENTS_POST,
	service = LifecycleAction.class
)
public class LoginPostAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		try {
			String ppid = ParamUtil.getString(
				lifecycleEvent.getRequest(), "p_p_id");

			String portletNamespace = _portal.getPortletNamespace(ppid);

			String memberRequestKey = ParamUtil.getString(
				lifecycleEvent.getRequest(), portletNamespace.concat("key"));

			if (Validator.isNull(memberRequestKey)) {
				return;
			}

			User user = _portal.getUser(lifecycleEvent.getRequest());

			_memberRequestLocalService.updateMemberRequest(
				memberRequestKey, user.getUserId());
		}
		catch (Exception exception) {
			throw new ActionException(exception);
		}
	}

	@Reference(unbind = "-")
	protected void setMemberRequestLocalService(
		MemberRequestLocalService memberRequestLocalService) {

		_memberRequestLocalService = memberRequestLocalService;
	}

	@Reference(unbind = "-")
	protected void setPortal(Portal portal) {
		_portal = portal;
	}

	private MemberRequestLocalService _memberRequestLocalService;
	private Portal _portal;

}