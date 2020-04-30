<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ItemSelectorURLViewDisplayContext itemSelectorURLViewDisplayContext = (ItemSelectorURLViewDisplayContext)request.getAttribute(ItemSelectorURLView.ITEM_SELECTOR_URL_VIEW_DISPLAY_CONTEXT);

Map<String, Object> data = HashMapBuilder.<String, Object>put(
	"eventName", itemSelectorURLViewDisplayContext.getItemSelectedEventName()
).build();
%>

<div class="lfr-form-content">
	<div class="sheet sheet-lg">
		<div class="panel-group panel-group-flush">
			<react:component
				data="<%= data %>"
				module="js/ItemSelectorUrl.es"
			/>
		</div>
	</div>
</div>