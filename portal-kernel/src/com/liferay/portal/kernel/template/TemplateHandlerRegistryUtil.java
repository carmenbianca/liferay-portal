/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.template;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.util.List;

/**
 * @author Juan Fernández
 */
public class TemplateHandlerRegistryUtil {

	public static long[] getClassNameIds() {
		return _templateHandlerRegistry.getClassNameIds();
	}

	public static TemplateHandler getTemplateHandler(long classNameId) {
		return _templateHandlerRegistry.getTemplateHandler(classNameId);
	}

	public static TemplateHandler getTemplateHandler(String className) {
		return _templateHandlerRegistry.getTemplateHandler(className);
	}

	public static List<TemplateHandler> getTemplateHandlers() {
		return _templateHandlerRegistry.getTemplateHandlers();
	}

	private static volatile TemplateHandlerRegistry _templateHandlerRegistry =
		ServiceProxyFactory.newServiceTrackedInstance(
			TemplateHandlerRegistry.class, TemplateHandlerRegistryUtil.class,
			"_templateHandlerRegistry", false);

}