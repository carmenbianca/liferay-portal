<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/sidebar_panel/init.jsp" %>

		</div>
	</div>
</div>

<c:if test="<%= (resourceURL != null) && Validator.isNotNull(searchContainerId) %>">
	<aui:script use="liferay-sidebar-panel">
		new Liferay.SidebarPanel({
			namespace: '<%= namespace %>',
			resourceUrl: '<%= resourceURL %>',
			searchContainerId: '<%= namespace + searchContainerId %>',
			targetNode: '#<%= namespace %>sidebarPanel',
		});
	</aui:script>
</c:if>