<%--
/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/ui/panel/init.jsp" %>

		</div>
	</div>
</div>

<c:if test="<%= collapsible && (panelCount == null) %>">
	<%@ include file="/html/taglib/ui/panel_container/javascript.jspf" %>
</c:if>