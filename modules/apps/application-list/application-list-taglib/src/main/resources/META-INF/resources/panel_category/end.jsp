<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/panel_category/init.jsp" %>

<c:if test="<%= showBody %>">
	<liferay-application-list:panel-category-body
		panelApps="<%= panelApps %>"
		panelCategory="<%= panelCategory %>"
	/>
</c:if>

<c:if test="<%= !panelApps.isEmpty() && showHeader %>">
		</div>
	</div>

	<c:if test="<%= persistState %>">
		<aui:script position="auto">
			Liferay.on('liferay.collapse.hidden', function(event) {
				var panelId = event.panel.getAttribute('id');

				if (panelId === '<%= id %>') {
					Liferay.Util.Session.set(
						'<%= PanelCategory.class.getName() %><%= id %>',
						'closed'
					);
				}
			});

			Liferay.on('liferay.collapse.shown', function(event) {
				var panelId = event.panel.getAttribute('id');

				if (panelId === '<%= id %>') {
					Liferay.Util.Session.set(
						'<%= PanelCategory.class.getName() %><%= id %>',
						'open'
					);
				}
			});
		</aui:script>
	</c:if>
</c:if>