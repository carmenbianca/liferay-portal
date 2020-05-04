<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
LayoutPrototype layoutPrototype = (LayoutPrototype)request.getAttribute("edit_layout_prototype.jsp-layoutPrototype");
String redirect = (String)request.getAttribute("edit_layout_prototype.jsp-redirect");

int mergeFailCount = SitesUtil.getMergeFailCount(layoutPrototype);
%>

<c:if test="<%= mergeFailCount > PropsValues.LAYOUT_PROTOTYPE_MERGE_FAIL_THRESHOLD %>">

	<%
	String randomNamespace = PortalUtil.generateRandomKey(request, "portlet_layout_prototypes_merge_alert") + StringPool.UNDERLINE;
	%>

	<span class="alert alert-warning">
		<liferay-ui:message arguments='<%= new Object[] {mergeFailCount, LanguageUtil.get(request, "page-template")} %>' key="the-propagation-of-changes-from-the-x-has-been-disabled-temporarily-after-x-errors" translateArguments="<%= false %>" />

		<liferay-ui:message arguments="page-template" key="click-reset-to-reset-the-failure-count-and-reenable-propagation" />

		<aui:button id='<%= randomNamespace + "resetButton" %>' useNamespace="<%= false %>" value="reset" />
	</span>

	<script>
		(function() {
			var resetButton = document.getElementById(
				'<%= randomNamespace %>resetButton'
			);

			if (resetButton) {
				resetButton.addEventListener('click', function(event) {
					<portlet:actionURL name="/layout_prototype/reset_merge_fail_count_and_merge" var="resetMergeFailCountURL">
						<portlet:param name="redirect" value="<%= redirect %>" />
						<portlet:param name="layoutPrototypeId" value="<%= String.valueOf(layoutPrototype.getLayoutPrototypeId()) %>" />
					</portlet:actionURL>

					submitForm(document.hrefFm, '<%= resetMergeFailCountURL %>');
				});
			}
		})();
	</script>
</c:if>