/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.engine.input.editor.common.internal.util;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Iván Zaera
 */
@Component(immediate = true, service = {})
public class WikiEngineInputEditorCommonComponentProvider {

	public static WikiEngineInputEditorCommonComponentProvider
		getWikiEngineInputEditorCommonComponentProvider() {

		return _wikiEngineInputEditorCommonComponentProvider;
	}

	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Activate
	protected void activate() {
		_wikiEngineInputEditorCommonComponentProvider = this;
	}

	@Deactivate
	protected void deactivate() {
		_wikiEngineInputEditorCommonComponentProvider = null;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.wiki.engine.input.editor.common)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static WikiEngineInputEditorCommonComponentProvider
		_wikiEngineInputEditorCommonComponentProvider;

	private ServletContext _servletContext;

}