/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.model.listener;

import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarResourceLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.Portal;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Antonio Junior
 */
@Component(immediate = true, service = ModelListener.class)
public class UserModelListener extends BaseModelListener<User> {

	@Override
	public void onAfterUpdate(User user) throws ModelListenerException {
		try {
			long classNameId = _portal.getClassNameId(User.class);

			CalendarResource calendarResource =
				_calendarResourceLocalService.fetchCalendarResource(
					classNameId, user.getUserId());

			if (calendarResource == null) {
				return;
			}

			String name = calendarResource.getName(LocaleUtil.getSiteDefault());

			if (Objects.equals(name, user.getFullName())) {
				return;
			}

			if (user.isDefaultUser() && name.equals(GroupConstants.GUEST)) {
				return;
			}

			Map<Locale, String> nameMap = HashMapBuilder.put(
				LocaleUtil.getSiteDefault(), user.getFullName()
			).build();

			calendarResource.setNameMap(
				LocalizationUtil.populateLocalizationMap(
					nameMap,
					LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()),
					user.getGroupId()));

			_calendarResourceLocalService.updateCalendarResource(
				calendarResource);
		}
		catch (Exception exception) {
			throw new ModelListenerException(exception);
		}
	}

	@Reference
	private CalendarResourceLocalService _calendarResourceLocalService;

	@Reference
	private Portal _portal;

}