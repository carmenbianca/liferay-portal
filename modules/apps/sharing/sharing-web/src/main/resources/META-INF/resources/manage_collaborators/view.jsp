<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/manage_collaborators/init.jsp" %>

<react:component
	data="<%= (Map<String, Object>)request.getAttribute(SharingWebKeys.SHARING_REACT_DATA) %>"
	module="manage_collaborators/js/ManageCollaborators.es"
/>