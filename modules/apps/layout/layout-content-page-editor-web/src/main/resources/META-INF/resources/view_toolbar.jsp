<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
ContentPageEditorDisplayContext contentPageEditorDisplayContext = (ContentPageEditorDisplayContext)request.getAttribute(ContentPageEditorWebKeys.LIFERAY_SHARED_CONTENT_PAGE_EDITOR_DISPLAY_CONTEXT);
%>

<div class="management-bar navbar navbar-expand-md page-editor__toolbar <%= contentPageEditorDisplayContext.isMasterLayout() ? "page-editor__toolbar--master-layout" : StringPool.BLANK %>" id="<%= contentPageEditorDisplayContext.getPortletNamespace() %>pageEditorToolbar">
	<div class="container-fluid container-fluid-max-xl">
		<ul class="navbar-nav">
		</ul>

		<ul class="navbar-nav">
			<li class="nav-item">
				<button class="btn btn-secondary btn-sm mr-3" disabled type="submit">
					<c:choose>
						<c:when test="<%= contentPageEditorDisplayContext.isConversionDraft() %>">
							<liferay-ui:message key="discard-conversion-draft" />
						</c:when>
						<c:when test="<%= contentPageEditorDisplayContext.isSingleSegmentsExperienceMode() %>">
							<liferay-ui:message key="discard-variant" />
						</c:when>
						<c:otherwise>
							<liferay-ui:message key="discard-draft" />
						</c:otherwise>
					</c:choose>
				</button>
			</li>
			<li class="nav-item">
				<button class="btn btn-primary btn-sm" disabled type="submit">
					<c:choose>
						<c:when test="<%= contentPageEditorDisplayContext.isMasterLayout() %>">
							<liferay-ui:message key="publish-master" />
						</c:when>
						<c:when test="<%= contentPageEditorDisplayContext.isSingleSegmentsExperienceMode() %>">
							<liferay-ui:message key="save-variant" />
						</c:when>
						<c:when test="<%= contentPageEditorDisplayContext.isWorkflowEnabled() %>">
							<liferay-ui:message key="submit-for-publication" />
						</c:when>
						<c:otherwise>
							<liferay-ui:message key="publish" />
						</c:otherwise>
					</c:choose>
				</button>
			</li>
		</ul>
	</div>
</div>