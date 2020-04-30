<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.dynamic.data.mapping.form.web.internal.display.context.DDMFormViewFormInstanceRecordDisplayContext" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %>

<portlet:defineObjects />

<aui:script>
	Liferay.namespace('Forms').portletNamespace = '<portlet:namespace />';
</aui:script>