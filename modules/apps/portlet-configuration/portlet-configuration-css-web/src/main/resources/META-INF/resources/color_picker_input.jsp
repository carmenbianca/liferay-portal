<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String color = ParamUtil.getString(request, "color");
String label = ParamUtil.getString(request, "label");
String name = ParamUtil.getString(request, "name");
%>

<div>
	<div class="form-group">
		<input name="<%= name %>" type="hidden" value="#<%= color %>" />

		<div class="clay-color-picker">
			<label><%= label %></label>

			<div class="clay-color input-group">
				<div class="input-group-item input-group-item-shrink input-group-prepend">
					<div class="input-group-text">
						<button class="btn clay-color-btn dropdown-toggle" style="border-width: 0px; height: 28px; width: 28px;" title="<%= color %>" type="button" />
					</div>
				</div>

				<div class="input-group-append input-group-item">
					<input class="form-control input-group-inset input-group-inset-before" type="text" />

					<label class="input-group-inset-item input-group-inset-item-before"><%= color %></label>
				</div>
			</div>
		</div>
	</div>

	<%
	Map<String, Object> data = HashMapBuilder.<String, Object>put(
		"color", color
	).put(
		"label", label
	).put(
		"name", name
	).build();
	%>

	<react:component
		data="<%= data %>"
		module="js/ColorPickerInput.es"
		servletContext="<%= application %>"
	/>
</div>