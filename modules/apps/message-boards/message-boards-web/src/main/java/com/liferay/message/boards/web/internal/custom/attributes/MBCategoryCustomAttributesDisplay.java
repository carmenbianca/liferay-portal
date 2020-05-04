/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.web.internal.custom.attributes;

import com.liferay.expando.kernel.model.BaseCustomAttributesDisplay;
import com.liferay.expando.kernel.model.CustomAttributesDisplay;
import com.liferay.message.boards.constants.MBPortletKeys;
import com.liferay.message.boards.model.MBCategory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jorge Ferrer
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + MBPortletKeys.MESSAGE_BOARDS,
	service = CustomAttributesDisplay.class
)
public class MBCategoryCustomAttributesDisplay
	extends BaseCustomAttributesDisplay {

	@Override
	public String getClassName() {
		return MBCategory.class.getName();
	}

}