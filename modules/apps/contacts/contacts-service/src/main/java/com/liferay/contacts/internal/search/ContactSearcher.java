/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.contacts.internal.search;

import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.search.BaseSearcher;

import org.osgi.service.component.annotations.Component;

/**
 * @author Lucas Marques de Paula
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.portal.kernel.model.Contact",
	service = BaseSearcher.class
)
public class ContactSearcher extends BaseSearcher {

	public static final String CLASS_NAME = Contact.class.getName();

	public ContactSearcher() {
		setStagingAware(false);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}