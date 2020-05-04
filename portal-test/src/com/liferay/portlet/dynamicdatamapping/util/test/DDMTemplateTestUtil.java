/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.dynamicdatamapping.util.test;

import com.liferay.dynamic.data.mapping.kernel.DDMTemplate;
import com.liferay.dynamic.data.mapping.kernel.DDMTemplateManager;
import com.liferay.dynamic.data.mapping.kernel.DDMTemplateManagerUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.Locale;
import java.util.Map;

/**
 * @author Eudaldo Alonso
 * @author Rafael Praxedes
 */
public class DDMTemplateTestUtil {

	public static DDMTemplate addTemplate(
			long groupId, long classNameId, long classPK,
			long resourceClassNameId)
		throws Exception {

		return addTemplate(
			groupId, classNameId, classPK, resourceClassNameId,
			TemplateConstants.LANG_TYPE_VM, getSampleTemplateXSL(),
			LocaleUtil.getSiteDefault());
	}

	public static DDMTemplate addTemplate(
			long groupId, long classNameId, long classPK,
			long resourceClassNameId, String language, String script,
			Locale defaultLocale)
		throws Exception {

		Map<Locale, String> nameMap = HashMapBuilder.put(
			defaultLocale, "Test Template"
		).build();

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		return DDMTemplateManagerUtil.addTemplate(
			TestPropsValues.getUserId(), groupId, classNameId, classPK,
			resourceClassNameId, null, nameMap, null,
			DDMTemplateManager.TEMPLATE_TYPE_DISPLAY, null, language, script,
			false, false, null, null, serviceContext);
	}

	public static String getSampleTemplateXSL() {
		return "$name.getData()";
	}

}