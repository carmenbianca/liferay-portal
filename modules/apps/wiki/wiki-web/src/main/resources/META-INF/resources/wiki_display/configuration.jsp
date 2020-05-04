<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/wiki_display/init.jsp" %>

<%
nodeId = ParamUtil.getLong(request, "nodeId", nodeId);

List<WikiNode> nodes = WikiNodeServiceUtil.getNodes(scopeGroupId);

boolean nodeInGroup = false;
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />

<liferay-frontend:edit-form
	action="<%= configurationActionURL %>"
	method="post"
	name="fm"
>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />

	<liferay-frontend:edit-form-body>
		<liferay-ui:error exception="<%= NoSuchNodeException.class %>" message="the-node-could-not-be-found" />

		<liferay-frontend:fieldset-group>
			<liferay-frontend:fieldset>
				<c:choose>
					<c:when test="<%= !nodes.isEmpty() %>">
						<aui:select label="node" name="preferences--nodeId--">
							<aui:option value="" />

							<%
							for (WikiNode node : nodes) {
								int pagesCount = WikiPageLocalServiceUtil.getPagesCount(node.getNodeId(), true);

								if (pagesCount == 0) {
									continue;
								}

								node = node.toEscapedModel();

								if (nodeId == node.getNodeId()) {
									nodeInGroup = true;
								}
							%>

								<aui:option label="<%= node.getName() %>" selected="<%= nodeId == node.getNodeId() %>" value="<%= node.getNodeId() %>" />

							<%
							}
							%>

						</aui:select>
					</c:when>
					<c:otherwise>
						<div class="alert alert-info">
							<liferay-ui:message key="there-are-no-available-nodes-for-selection" />
						</div>
					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when test="<%= nodeInGroup %>">
						<div id="<portlet:namespace />pageSelectorContainer">
							<aui:select label="page" name="preferences--title--">

								<%
								int total = WikiPageLocalServiceUtil.getPagesCount(nodeId, true);

								List pages = WikiPageLocalServiceUtil.getPages(nodeId, true, 0, total);

								for (int i = 0; i < pages.size(); i++) {
									WikiPage wikiPage = (WikiPage)pages.get(i);
								%>

									<aui:option label="<%= wikiPage.getTitle() %>" selected="<%= wikiPage.getTitle().equals(title) || (Validator.isNull(title) && wikiPage.getTitle().equals(wikiGroupServiceConfiguration.frontPageName())) %>" />

								<%
								}
								%>

							</aui:select>
						</div>
					</c:when>
					<c:otherwise>
						<aui:input name="preferences--title--" type="hidden" value="<%= wikiGroupServiceConfiguration.frontPageName() %>" />
					</c:otherwise>
				</c:choose>

				<script>
					var nodeIdSelect = document.getElementById('<portlet:namespace />nodeId');
					var pageSelectorContainer = document.getElementById(
						'<portlet:namespace />pageSelectorContainer'
					);

					if (nodeIdSelect) {
						var nodeId = nodeIdSelect.value;

						nodeIdSelect.addEventListener('change', function() {
							if (pageSelectorContainer) {
								if (nodeIdSelect.value === nodeId) {
									pageSelectorContainer.classList.remove('hide');
								}
								else {
									pageSelectorContainer.classList.add('hide');
								}
							}

							if (nodeIdSelect.value && nodeIdSelect.value !== nodeId) {
								var configurationRenderURL = Liferay.PortletURL.createURL(
									'<%= configurationRenderURL %>'
								);

								configurationRenderURL.setParameter('nodeId', nodeIdSelect.value);

								document.<portlet:namespace />fm.action = configurationRenderURL;
								document.<portlet:namespace />fm.submit();
							}
						});
					}
				</script>
			</liferay-frontend:fieldset>
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<aui:button disabled="<%= nodes.isEmpty() %>" type="submit" />

		<aui:button type="cancel" />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>