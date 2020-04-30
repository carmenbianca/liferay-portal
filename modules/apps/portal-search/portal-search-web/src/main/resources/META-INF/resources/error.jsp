<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.security.auth.PrincipalException" %><%@
page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

<liferay-ui:header
	showBackURL="<%= false %>"
	title="error"
/>

<c:if test="<%= SessionErrors.contains(request, PrincipalException.getNestedClasses()) %>">
	<liferay-ui:message key="you-do-not-have-permission-to-view-this-page" />
</c:if>

<liferay-ui:error exception="<%= PrincipalException.class %>" message="you-do-not-have-permission-to-view-this-page" />