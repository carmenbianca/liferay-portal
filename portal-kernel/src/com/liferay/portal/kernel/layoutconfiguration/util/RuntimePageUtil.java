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

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 * @author Shuyang Zhou
 */
public class RuntimePageUtil {

	public static StringBundler getProcessedTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String portletId,
			TemplateResource templateResource)
		throws Exception {

		return getRuntimePage().getProcessedTemplate(
			httpServletRequest, httpServletResponse, portletId,
			templateResource);
	}

	public static RuntimePage getRuntimePage() {
		return _runtimePage;
	}

	public static void processCustomizationSettings(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			TemplateResource templateResource)
		throws Exception {

		getRuntimePage().processCustomizationSettings(
			httpServletRequest, httpServletResponse, templateResource);
	}

	public static void processCustomizationSettings(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			TemplateResource templateResource, String langType)
		throws Exception {

		getRuntimePage().processCustomizationSettings(
			httpServletRequest, httpServletResponse, templateResource,
			langType);
	}

	public static void processTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String portletId,
			TemplateResource templateResource)
		throws Exception {

		getRuntimePage().processTemplate(
			httpServletRequest, httpServletResponse, portletId,
			templateResource);
	}

	public static void processTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String portletId,
			TemplateResource templateResource, String langType)
		throws Exception {

		getRuntimePage().processTemplate(
			httpServletRequest, httpServletResponse, portletId,
			templateResource, langType);
	}

	public static void processTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			TemplateResource templateResource)
		throws Exception {

		getRuntimePage().processTemplate(
			httpServletRequest, httpServletResponse, templateResource);
	}

	public static void processTemplate(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			TemplateResource templateResource, String langType)
		throws Exception {

		getRuntimePage().processTemplate(
			httpServletRequest, httpServletResponse, templateResource,
			langType);
	}

	public static String processXML(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String content)
		throws Exception {

		return getRuntimePage().processXML(
			httpServletRequest, httpServletResponse, content);
	}

	public static String processXML(
			HttpServletRequest httpServletRequest, String content,
			RuntimeLogic runtimeLogic)
		throws Exception {

		return getRuntimePage().processXML(
			httpServletRequest, content, runtimeLogic);
	}

	public void setRuntimePage(RuntimePage runtimePage) {
		_runtimePage = runtimePage;
	}

	private static RuntimePage _runtimePage;

}