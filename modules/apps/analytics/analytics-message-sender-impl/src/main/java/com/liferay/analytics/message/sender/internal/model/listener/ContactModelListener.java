/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.message.sender.internal.model.listener;

import com.liferay.analytics.message.sender.model.EntityModelListener;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ContactLocalService;

import java.util.Arrays;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rachael Koestartyo
 */
@Component(
	immediate = true, service = {EntityModelListener.class, ModelListener.class}
)
public class ContactModelListener extends BaseEntityModelListener<Contact> {

	@Override
	public List<String> getAttributeNames() {
		return _attributeNames;
	}

	@Override
	protected Contact getModel(long id) throws Exception {
		return _contactLocalService.getContact(id);
	}

	@Override
	protected String getPrimaryKeyName() {
		return "contactId";
	}

	@Override
	protected boolean isExcluded(Contact contact) {
		return isUserExcluded(userLocalService.fetchUser(contact.getClassPK()));
	}

	private static final List<String> _attributeNames = Arrays.asList(
		"accountId", "birthday", "classNameId", "classPK", "companyId",
		"createDate", "emailAddress", "employeeNumber", "employeeStatusId",
		"facebookSn", "firstName", "hoursOfOperation", "jabberSn", "jobClass",
		"jobTitle", "lastName", "male", "middleName", "modifiedDate",
		"parentContactId", "prefixId", "skypeSn", "smsSn", "suffixId",
		"twitterSn", "userId", "userName");

	@Reference
	private ContactLocalService _contactLocalService;

}