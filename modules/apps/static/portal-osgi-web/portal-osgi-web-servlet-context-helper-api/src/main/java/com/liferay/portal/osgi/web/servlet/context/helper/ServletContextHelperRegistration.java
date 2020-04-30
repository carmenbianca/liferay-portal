/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.context.helper;

import com.liferay.portal.osgi.web.servlet.context.helper.definition.WebXMLDefinition;

import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Raymond Augé
 */
@ProviderType
public interface ServletContextHelperRegistration {

	public void close();

	public Set<Class<?>> getAnnotatedClasses();

	public Set<Class<?>> getClasses();

	public ServletContext getServletContext();

	public WebXMLDefinition getWebXMLDefinition();

	public boolean isWabShapedBundle();

	public void setProperties(Map<String, String> contextParameters);

}