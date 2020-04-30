<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<%
for (String servletContextName : ServletContextPool.keySet()) {
	ServletContext servletContext = ServletContextPool.get(servletContextName);

	if (Validator.isNull(servletContextName) || servletContextName.equals(PortalUtil.getPathContext())) {
		continue;
	}

	PortletApp portletApp = PortletLocalServiceUtil.getPortletApp(servletContextName);

	List<Portlet> portlets = portletApp.getPortlets();

	for (Portlet portlet : portlets) {
		PortletConfig portletConfig = PortletConfigFactoryUtil.create(portlet, servletContext);

		String invokerPortletName = portletConfig.getInitParameter(InvokerPortlet.INIT_INVOKER_PORTLET_NAME);

		if (invokerPortletName == null) {
			invokerPortletName = portletConfig.getPortletName();
		}

		String path = StringPool.SLASH.concat(invokerPortletName).concat("/invoke");

		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);

		if (requestDispatcher == null) {
			continue;
		}

		request.setAttribute(WebKeys.EXTEND_SESSION, Boolean.TRUE);

		try {
			requestDispatcher.include(request, response);
		}
		catch (Exception e) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to extend session for " + servletContextName);
			}
		}
	}
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("portal_web.docroot.html.portal.extend_session_jsp");
%>