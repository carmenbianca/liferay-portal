<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String languageId = LanguageUtil.getLanguageId(request);
%>

<div class="calendar-asset-full-content">

	<%
	String description = calendarBooking.getDescription(languageId);
	%>

	<c:if test="<%= Validator.isNotNull(description) %>">
		<div>
			<%= description %>
		</div>
	</c:if>

	<p>
		<liferay-ui:icon
			icon="user"
			markupView="lexicon"
			message="owner"
		/>

		<%
		Calendar calendar = calendarBooking.getCalendar();
		%>

		<strong><%= HtmlUtil.escape(calendar.getName(languageId)) %></strong>

		<%
		List<CalendarBooking> childCalendarBookings = calendarBooking.getChildCalendarBookings();
		%>

		<c:if test="<%= !childCalendarBookings.isEmpty() %>">
			<br />

			<liferay-ui:icon
				icon="globe"
				markupView="lexicon"
				message="resources"
			/>

			<liferay-ui:message key="resources" />:

			<%
			List<String> calendarResourcesNames = new ArrayList<String>();

			for (CalendarBooking childCalendarBooking : childCalendarBookings) {
				CalendarResource calendarResource = childCalendarBooking.getCalendarResource();

				calendarResourcesNames.add(calendarResource.getName(languageId));
			}
			%>

			<%= HtmlUtil.escape(StringUtil.merge(calendarResourcesNames, ", ")) %>
		</c:if>

		<c:if test="<%= calendarBooking.isRecurring() %>">
			<br /><br />

			<liferay-ui:icon
				icon="list"
				markupView="lexicon"
				message="recurring"
			/>

			<liferay-ui:message key="recurring" />
		</c:if>

		<br /><br />

		<liferay-ui:icon
			icon="calendar"
			markupView="lexicon"
			message="starts"
		/>

		<%
		java.util.Calendar startTimeJCalendar = JCalendarUtil.getJCalendar(calendarBooking.getStartTime(), user.getTimeZone());
		%>

		<liferay-ui:message key="starts" />: <%= dateFormatLongDate.format(startTimeJCalendar.getTime()) + ", " + dateFormatTime.format(startTimeJCalendar.getTime()) %>

		<br />

		<liferay-ui:icon
			icon="calendar"
			markupView="lexicon"
			message="ends"
		/>

		<%
		java.util.Calendar endTimeJCalendar = JCalendarUtil.getJCalendar(calendarBooking.getEndTime(), user.getTimeZone());
		%>

		<liferay-ui:message key="ends" />: <%= dateFormatLongDate.format(endTimeJCalendar.getTime()) + ", " + dateFormatTime.format(endTimeJCalendar.getTime()) %>

		<c:if test="<%= Validator.isNotNull(calendarBooking.getLocation()) %>">
			<br /><br />

			<liferay-ui:icon
				icon="geolocation"
				markupView="lexicon"
				message="location"
			/>

			<liferay-ui:message key="location" />: <a href="https://maps.google.com.br/maps?q=<%= HtmlUtil.escapeHREF(calendarBooking.getLocation()) %>" target="_blank"><%= HtmlUtil.escape(calendarBooking.getLocation()) %></a>
		</c:if>

		<liferay-expando:custom-attributes-available
			className="<%= CalendarBooking.class.getName() %>"
		>
			<liferay-expando:custom-attribute-list
				className="<%= CalendarBooking.class.getName() %>"
				classPK="<%= (calendarBooking != null) ? calendarBooking.getCalendarBookingId() : 0 %>"
				editable="<%= false %>"
				label="<%= true %>"
			/>
		</liferay-expando:custom-attributes-available>
	</p>
</div>

<br />