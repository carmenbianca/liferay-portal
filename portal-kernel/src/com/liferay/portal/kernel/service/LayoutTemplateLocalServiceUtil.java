/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the local service utility for LayoutTemplate. This utility wraps
 * <code>com.liferay.portal.service.impl.LayoutTemplateLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutTemplateLocalService
 * @generated
 */
public class LayoutTemplateLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.LayoutTemplateLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static String getContent(
		String layoutTemplateId, boolean standard, String themeId) {

		return getService().getContent(layoutTemplateId, standard, themeId);
	}

	public static String getLangType(
		String layoutTemplateId, boolean standard, String themeId) {

		return getService().getLangType(layoutTemplateId, standard, themeId);
	}

	public static com.liferay.portal.kernel.model.LayoutTemplate
		getLayoutTemplate(
			String layoutTemplateId, boolean standard, String themeId) {

		return getService().getLayoutTemplate(
			layoutTemplateId, standard, themeId);
	}

	public static java.util.List<com.liferay.portal.kernel.model.LayoutTemplate>
		getLayoutTemplates() {

		return getService().getLayoutTemplates();
	}

	public static java.util.List<com.liferay.portal.kernel.model.LayoutTemplate>
		getLayoutTemplates(String themeId) {

		return getService().getLayoutTemplates(themeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.portal.kernel.model.LayoutTemplate>
		init(
			javax.servlet.ServletContext servletContext, String[] xmls,
			com.liferay.portal.kernel.plugin.PluginPackage pluginPackage) {

		return getService().init(servletContext, xmls, pluginPackage);
	}

	public static java.util.List<com.liferay.portal.kernel.model.LayoutTemplate>
		init(
			String servletContextName,
			javax.servlet.ServletContext servletContext, String[] xmls,
			com.liferay.portal.kernel.plugin.PluginPackage pluginPackage) {

		return getService().init(
			servletContextName, servletContext, xmls, pluginPackage);
	}

	public static void readLayoutTemplate(
		String servletContextName, javax.servlet.ServletContext servletContext,
		java.util.Set<com.liferay.portal.kernel.model.LayoutTemplate>
			layoutTemplates,
		com.liferay.portal.kernel.xml.Element element, boolean standard,
		String themeId,
		com.liferay.portal.kernel.plugin.PluginPackage pluginPackage) {

		getService().readLayoutTemplate(
			servletContextName, servletContext, layoutTemplates, element,
			standard, themeId, pluginPackage);
	}

	public static void uninstallLayoutTemplate(
		String layoutTemplateId, boolean standard) {

		getService().uninstallLayoutTemplate(layoutTemplateId, standard);
	}

	public static void uninstallLayoutTemplates(String themeId) {
		getService().uninstallLayoutTemplates(themeId);
	}

	public static LayoutTemplateLocalService getService() {
		if (_service == null) {
			_service = (LayoutTemplateLocalService)PortalBeanLocatorUtil.locate(
				LayoutTemplateLocalService.class.getName());
		}

		return _service;
	}

	private static LayoutTemplateLocalService _service;

}