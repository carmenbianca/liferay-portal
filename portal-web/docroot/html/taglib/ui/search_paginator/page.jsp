<%--
/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

String id = (String)request.getAttribute("liferay-ui:search:id");

if (Validator.isNull(id) && (searchContainer != null)) {
	id = searchContainer.getId(request, namespace);

	id = id.concat("PageIterator");
}

String type = (String)request.getAttribute("liferay-ui:search:type");

PortletURL iteratorURL = searchContainer.getIteratorURL();

if (iteratorURL != null) {
	iteratorURL.setParameter(searchContainer.getCurParam(), (String)null);
	iteratorURL.setParameter("resetCur", Boolean.FALSE.toString());
}
%>

<c:if test="<%= searchContainer.getTotal() > 0 %>">
	<liferay-ui:page-iterator
		cur="<%= searchContainer.getCur() %>"
		curParam="<%= searchContainer.getCurParam() %>"
		delta="<%= searchContainer.getDelta() %>"
		deltaConfigurable="<%= searchContainer.isDeltaConfigurable() %>"
		deltaParam="<%= searchContainer.getDeltaParam() %>"
		forcePost="<%= searchContainer.isForcePost() %>"
		id="<%= id %>"
		maxPages="<%= PropsValues.SEARCH_CONTAINER_PAGE_ITERATOR_MAX_PAGES %>"
		portletURL="<%= iteratorURL %>"
		total="<%= searchContainer.getTotal() %>"
		type="<%= type %>"
	/>
</c:if>