<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/sites_admin/init.jsp" %>

<%
SharingConfiguration groupSharingConfiguration = (SharingConfiguration)request.getAttribute(SharingWebKeys.GROUP_SHARING_CONFIGURATION);
%>

<aui:input helpMessage="sharing-help" label="sharing-enabled" name="TypeSettingsProperties--sharingEnabled--" type="toggle-switch" value="<%= groupSharingConfiguration.isEnabled() %>" />