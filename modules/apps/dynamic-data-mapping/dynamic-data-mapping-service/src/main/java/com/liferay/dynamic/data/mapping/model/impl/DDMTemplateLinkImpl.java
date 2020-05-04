/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.model.impl;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Marcellus Tavares
 */
public class DDMTemplateLinkImpl extends DDMTemplateLinkBaseImpl {

	@Override
	public DDMTemplate getTemplate() throws PortalException {
		return DDMTemplateLocalServiceUtil.getTemplate(getTemplateId());
	}

}