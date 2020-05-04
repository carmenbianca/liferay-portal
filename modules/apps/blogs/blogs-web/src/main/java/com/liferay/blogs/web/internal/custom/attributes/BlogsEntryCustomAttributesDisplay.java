/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.custom.attributes;

import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.expando.kernel.model.BaseCustomAttributesDisplay;
import com.liferay.expando.kernel.model.CustomAttributesDisplay;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jorge Ferrer
 */
@Component(
	immediate = true, property = "javax.portlet.name=" + BlogsPortletKeys.BLOGS,
	service = CustomAttributesDisplay.class
)
public class BlogsEntryCustomAttributesDisplay
	extends BaseCustomAttributesDisplay {

	@Override
	public String getClassName() {
		return BlogsEntry.class.getName();
	}

}