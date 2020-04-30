/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.layoutconfiguration.util;

import com.liferay.portal.kernel.layoutconfiguration.util.xml.RuntimeLogic;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.util.StringBundler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 * @author Shuyang Zhou
 */
@ProviderType
public interface RuntimePage {

	public StringBundler getProcessedTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String portletId,
			TemplateResource templateResource)
		throws Exception;

	public void processCustomizationSettings(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			TemplateResource templateResource)
		throws Exception;

	public void processCustomizationSettings(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			TemplateResource templateResource, String langType)
		throws Exception;

	public void processTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String portletId,
			TemplateResource templateResource)
		throws Exception;

	public void processTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String portletId,
			TemplateResource templateResource, String langType)
		throws Exception;

	public void processTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			TemplateResource templateResource)
		throws Exception;

	public void processTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			TemplateResource templateResource, String langType)
		throws Exception;

	public String processXML(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String content)
		throws Exception;

	public String processXML(
			HttpServletRequest httpServletRequest, String content,
			RuntimeLogic runtimeLogic)
		throws Exception;

}