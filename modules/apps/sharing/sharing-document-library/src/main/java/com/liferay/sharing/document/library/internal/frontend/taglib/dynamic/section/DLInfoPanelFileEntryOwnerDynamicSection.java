/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.document.library.internal.frontend.taglib.dynamic.section;

import com.liferay.frontend.taglib.dynamic.section.DynamicSection;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sharing.configuration.SharingConfiguration;
import com.liferay.sharing.configuration.SharingConfigurationFactory;
import com.liferay.taglib.servlet.PipingServletResponse;

import java.io.ByteArrayOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = "name=com.liferay.document.library.web#/document_library/info_panel_file_entry.jsp#fileEntryOwner",
	service = DynamicSection.class
)
public class DLInfoPanelFileEntryOwnerDynamicSection implements DynamicSection {

	@Override
	public StringBundler modify(StringBundler sb, PageContext pageContext) {
		HttpServletRequest httpServletRequest =
			(HttpServletRequest)pageContext.getRequest();

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		SharingConfiguration sharingConfiguration =
			_sharingConfigurationFactory.getGroupSharingConfiguration(
				themeDisplay.getSiteGroup());

		if (!sharingConfiguration.isEnabled()) {
			return sb;
		}

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(
				"/META-INF/resources/dynamic_section" +
					"/info_panel_file_entry.jsp");

		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			HttpServletResponse httpServletResponse = new PipingServletResponse(
				(HttpServletResponse)pageContext.getResponse(), outputStream);

			requestDispatcher.include(
				pageContext.getRequest(), httpServletResponse);

			return new StringBundler(new String(outputStream.toByteArray()));
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.sharing.document.library)"
	)
	private ServletContext _servletContext;

	@Reference
	private SharingConfigurationFactory _sharingConfigurationFactory;

}