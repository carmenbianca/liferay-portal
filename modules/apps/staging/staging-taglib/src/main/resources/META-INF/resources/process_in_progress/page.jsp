<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/process_in_progress/init.jsp" %>

<%
boolean processInProgress = (allProgressBarCountersTotal > 0) && (!Objects.equals(cmd, Constants.PUBLISH_TO_REMOTE) || (percentage < 100));
%>

<c:if test="<%= backgroundTaskStatus != null %>">
	<c:if test="<%= processInProgress %>">
		<div class="progress-group">
			<div class="progress">
				<div aria-valuemax="100" aria-valuemin="0" aria-valuenow="<%= percentage %>" class="progress-bar" role="progressbar" style="width: <%= percentage %>%;"></div>
			</div>

			<div class="progress-group-addon"><%= percentage %>%</div>
		</div>
	</c:if>

	<c:if test="<%= !listView %>">
		<c:choose>
			<c:when test="<%= Objects.equals(cmd, Constants.PUBLISH_TO_REMOTE) && (percentage == 100) %>">
				<div class="progress-current-item">
					<strong><liferay-ui:message key="please-wait-as-the-publication-processes-on-the-remote-site" /></strong>
				</div>
			</c:when>
			<c:when test="<%= Validator.isNotNull(shortenedStagedModelName) && Validator.isNotNull(localizedStagedModelType) %>">
				<div class="progress-current-item">
					<liferay-ui:message key="publishing" /><%= StringPool.TRIPLE_PERIOD %><%= localizedStagedModelType %> <em><%= HtmlUtil.escape(shortenedStagedModelName) %></em>
				</div>
			</c:when>
		</c:choose>
	</c:if>
</c:if>