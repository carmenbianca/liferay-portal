/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.exportimport;

import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Michael C. Han
 * @author Marcellus Tavares
 */
public interface UserExporter {

	public void exportUser(
			Contact contact, Map<String, Serializable> contactExpandoAttributes)
		throws Exception;

	public void exportUser(
			long userId, long userGroupId, UserOperation userOperation)
		throws Exception;

	public void exportUser(
			User user, Map<String, Serializable> userExpandoAttributes)
		throws Exception;

}