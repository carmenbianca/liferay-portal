<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/checkbox/init.jsp" %>

<div class="custom-checkbox custom-control">
	<label>
		<input class="custom-control-input" data-qa-id="<%= name %>" id="<%= HtmlUtil.escape(domId) %>" <%= disabledString %> <%= checkedString %> type="checkbox" name="<%= HtmlUtil.escape(domName) %>" />

		<span class="custom-control-label">
			<%@ include file="/checkbox/extended_label.jspf" %>
		</span>
	</label>
</div>