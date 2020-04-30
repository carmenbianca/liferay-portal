<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/change_lists/init.jsp" %>

<liferay-portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/change_lists/view" />
</liferay-portlet:renderURL>

<%
CTEntryDiffDisplay ctEntryDiffDisplay = (CTEntryDiffDisplay)request.getAttribute(CTWebKeys.CT_ENTRY_DIFF_DISPLAY);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(backURL);
%>

<div class="change-lists-diff-table-wrapper">
	<table class="table table-autofit">
		<tr class="table-divider">
			<c:if test="<%= !ctEntryDiffDisplay.isChangeType(CTConstants.CT_CHANGE_TYPE_ADDITION) %>">
				<td class="change-lists-diff-td"><%= HtmlUtil.escape(ctEntryDiffDisplay.getLeftTitle()) %></td>
			</c:if>

			<c:if test="<%= !ctEntryDiffDisplay.isChangeType(CTConstants.CT_CHANGE_TYPE_DELETION) %>">
				<td class="change-lists-diff-td"><%= HtmlUtil.escape(ctEntryDiffDisplay.getRightTitle()) %></td>
			</c:if>
		</tr>
		<tr>
			<c:if test="<%= !ctEntryDiffDisplay.isChangeType(CTConstants.CT_CHANGE_TYPE_ADDITION) %>">
				<td class="change-lists-diff-td">

					<%
					ctEntryDiffDisplay.renderLeftCTRow();
					%>

				</td>
			</c:if>

			<c:if test="<%= !ctEntryDiffDisplay.isChangeType(CTConstants.CT_CHANGE_TYPE_DELETION) %>">
				<td class="change-lists-diff-td">

					<%
					ctEntryDiffDisplay.renderRightCTRow();
					%>

				</td>
			</c:if>
		</tr>
	</table>
</div>