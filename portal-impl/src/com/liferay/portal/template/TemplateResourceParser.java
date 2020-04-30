/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template;

import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateResource;

/**
 * @author Tina Tian
 */
public interface TemplateResourceParser {

	public TemplateResource getTemplateResource(String templateId)
		throws TemplateException;

	public boolean isTemplateResourceValid(String templateId, String langType);

}