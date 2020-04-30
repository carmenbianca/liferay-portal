/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.message.sender.internal.model.listener;

import com.liferay.analytics.message.sender.model.EntityModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rachael Koestartyo
 */
@Component(
	immediate = true, service = {EntityModelListener.class, ModelListener.class}
)
public class UserModelListener extends BaseEntityModelListener<User> {

	@Override
	public List<String> getAttributeNames() {
		return getUserAttributeNames();
	}

	@Override
	protected User getModel(long id) throws Exception {
		return userLocalService.getUser(id);
	}

	@Override
	protected String getPrimaryKeyName() {
		return "userId";
	}

	@Override
	protected boolean isExcluded(User user) {
		return isUserExcluded(user);
	}

}