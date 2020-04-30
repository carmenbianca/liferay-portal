<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

Role role = (Role)objArray[0];
String target = (String)objArray[3];
Boolean supportsFilterByGroup = (Boolean)objArray[5];
long[] groupIdsArray = (long[])objArray[7];
List groupNames = (List)objArray[8];
String portletId = (String)objArray[9];
%>

<aui:input name='<%= "groupIds" + HtmlUtil.escapeAttribute(target) %>' type="hidden" value="<%= StringUtil.merge(groupIdsArray) %>" />
<aui:input name='<%= "groupNames" + HtmlUtil.escapeAttribute(target) %>' type="hidden" value='<%= StringUtil.merge(groupNames, "@@") %>' />

<div id="<portlet:namespace />groupDiv<%= HtmlUtil.escapeAttribute(target) %>">
	<span id="<portlet:namespace />groupHTML<%= HtmlUtil.escapeAttribute(target) %>">

		<%
		if (supportsFilterByGroup) {
			ItemSelector itemSelector = (ItemSelector)request.getAttribute(RolesAdminWebKeys.ITEM_SELECTOR);

			GroupItemSelectorCriterion groupItemSelectorCriterion = new GroupItemSelectorCriterion();

			groupItemSelectorCriterion.setAllowNavigation(false);
			groupItemSelectorCriterion.setDesiredItemSelectorReturnTypes(new URLItemSelectorReturnType());
			groupItemSelectorCriterion.setIncludeAllVisibleGroups(true);
			groupItemSelectorCriterion.setIncludeFormsSite(true);
			groupItemSelectorCriterion.setIncludeUserPersonalSite(true);
			groupItemSelectorCriterion.setPortletId(portletId);
			groupItemSelectorCriterion.setTarget(target);

			PortletURL itemSelectorURL = itemSelector.getItemSelectorURL(RequestBackedPortletURLFactoryUtil.create(liferayPortletRequest), liferayPortletResponse.getNamespace() + "selectGroup", groupItemSelectorCriterion);

			Map<String, Object> data = HashMapBuilder.<String, Object>put("itemSelectorURL", itemSelectorURL.toString()).put("target", target).build();
		%>

			<react:component
				data="<%= data %>"
				module="js/GroupLabels.es"
			/>

		<%
		}
		else if (role.getType() == RoleConstants.TYPE_REGULAR) {
		%>

			<liferay-ui:message key="all-sites-and-asset-libraries" />

		<%
		}
		%>

	</span>
</div>