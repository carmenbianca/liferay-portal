/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.jsonwebservice;

import java.lang.reflect.Method;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Igor Spasic
 */
public interface JSONWebServiceActionsManager {

	public Set<String> getContextNames();

	public JSONWebServiceAction getJSONWebServiceAction(
			HttpServletRequest httpServletRequest)
		throws NoSuchJSONWebServiceException;

	public JSONWebServiceAction getJSONWebServiceAction(
			HttpServletRequest httpServletRequest, String path, String method,
			Map<String, Object> parameters)
		throws NoSuchJSONWebServiceException;

	public JSONWebServiceActionMapping getJSONWebServiceActionMapping(
		String signature);

	public List<JSONWebServiceActionMapping> getJSONWebServiceActionMappings(
		String contextName);

	public int getJSONWebServiceActionsCount(String contextName);

	public JSONWebServiceNaming getJSONWebServiceNaming();

	public void registerJSONWebServiceAction(
		String contextName, String contextPath, Class<?> actionClass,
		Method actionMethod, String path, String method);

	public void registerJSONWebServiceAction(
		String contextName, String contextPath, Object actionObject,
		Class<?> actionClass, Method actionMethod, String path, String method);

	public int registerService(String contextPath, Object service);

	public int registerService(
		String contextName, String contextPath, Object service);

	public int registerService(
		String contextName, String contextPath, Object service,
		JSONWebServiceRegistrator jsonWebServiceRegistrator);

	public int registerServletContext(ServletContext servletContext);

	public int unregisterJSONWebServiceActions(Object actionObject);

	public int unregisterJSONWebServiceActions(String contextPath);

	public int unregisterServletContext(ServletContext servletContext);

}