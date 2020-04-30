<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/asset_tags_selector/init.jsp" %>

<%
Map<String, Object> data = (Map<String, Object>)request.getAttribute("liferay-asset:asset-tags-selector:data");

String inputName = (String)data.get("inputName");
List<Map<String, String>> selectedItems = (List<Map<String, String>>)data.get("selectedItems");
%>

<div>
	<div class="lfr-tags-selector-content">

		<%
		for (Map<String, String> selectedItem : selectedItems) {
		%>

			<input name="<%= inputName %>" type="hidden" value="<%= selectedItem.get("value") %>" />

		<%
		}
		%>

		<div class="form-group">
			<label>
				<liferay-ui:message key="tags" />
			</label>

			<div class="input-group input-group-stacked-sm-down">
				<div class="input-group-item">
					<div class="form-control form-control-tag-group">

						<%
						for (Map<String, String> selectedItem : selectedItems) {
						%>

							<clay:label
								closeable="<%= true %>"
								label='<%= selectedItem.get("label") %>'
							/>

						<%
						}
						%>

						<input class="form-control-inset" type="text" value="" />
					</div>
				</div>
			</div>
		</div>

		<button class="btn btn-secondary" type="button">
			<liferay-ui:message key="select" />
		</button>
	</div>

	<react:component
		data="<%= data %>"
		module="asset_tags_selector/AssetTagsSelectorTag.es"
	/>
</div>