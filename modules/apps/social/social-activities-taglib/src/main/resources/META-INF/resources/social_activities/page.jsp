<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/social_activities/init.jsp" %>

<div class="taglib-social-activities">
	<c:if test="<%= feedEnabled && !activityDescriptors.isEmpty() %>">
		<div class="clearfix">
			<div class="float-right">
				<liferay-rss:rss
					delta="<%= feedDelta %>"
					displayStyle="<%= feedDisplayStyle %>"
					feedType="<%= feedType %>"
					message="<%= feedURLMessage %>"
					name="<%= feedTitle %>"
					resourceURL="<%= feedResourceURL %>"
					url="<%= feedURL %>"
				/>
			</div>
		</div>
	</c:if>

	<%
	ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

	boolean hasActivities = false;

	Date now = new Date();

	int daysBetween = -1;

	for (SocialActivityDescriptor activityDescriptor : activityDescriptors) {
		SocialActivityFeedEntry activityFeedEntry = activityDescriptor.interpret(selector, serviceContext);

		if (activityFeedEntry == null) {
			continue;
		}

		Date activityDate = new Date(activityDescriptor.getCreateDate());

		int curDaysBetween = DateUtil.getDaysBetween(activityDate, now, timeZone);
	%>

		<c:if test="<%= curDaysBetween > daysBetween %>">

			<%
			daysBetween = curDaysBetween;

			if (hasActivities) {
			%>

				</ul>

			<%
			}
			%>

			<ul class="list-unstyled">
				<li class="splitter">
					<c:choose>
						<c:when test="<%= curDaysBetween == 0 %>">
							<liferay-ui:message key="today" />
						</c:when>
						<c:when test="<%= curDaysBetween == 1 %>">
							<liferay-ui:message key="yesterday" />
						</c:when>
						<c:when test="<%= DateUtil.getYear(activityDate) == DateUtil.getYear(now) %>">
							<%= dateFormatDate.format(activityDescriptor.getCreateDate()) %>
						</c:when>
						<c:otherwise>
							<%= yearDateFormatDate.format(activityDescriptor.getCreateDate()) %>
						</c:otherwise>
					</c:choose>
				</li>
		</c:if>

		<li class="list-group-item">
			<div class="card card-horizontal">
				<div class="card-body">
					<div class="card-col-field">
						<liferay-ui:user-portrait
							userId="<%= activityDescriptor.getUserId() %>"
						/>
					</div>

					<div class="card-col-content card-col-gutters">
						<h5 class="text-default">
							<%= timeFormatDate.format(activityDescriptor.getCreateDate()) %>
						</h5>

						<%= activityFeedEntry.getTitle() %>

						<%= activityFeedEntry.getBody() %>
					</div>
				</div>
			</div>
		</li>

	<%
		if (!hasActivities) {
			hasActivities = true;
		}
	}
	%>

	<c:choose>
		<c:when test="<%= hasActivities %>">
			</ul>
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="there-are-no-recent-activities" />
		</c:otherwise>
	</c:choose>
</div>