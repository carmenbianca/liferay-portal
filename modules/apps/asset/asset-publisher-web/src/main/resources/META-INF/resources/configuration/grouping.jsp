<%--
/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<aui:row id="grouping">
	<aui:col width="<%= 30 %>">

		<%
		long assetVocabularyId = GetterUtil.getLong(portletPreferences.getValue("assetVocabularyId", null));
		%>

		<aui:select label="group-by" name="preferences--assetVocabularyId--">
			<aui:option value="" />
			<aui:option label="asset-types" selected="<%= assetVocabularyId == -1 %>" value="-1" />

			<%
			Group companyGroup = company.getGroup();

			if (scopeGroupId != companyGroup.getGroupId()) {
				List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId, false);

				if (!assetVocabularies.isEmpty()) {
			%>

					<optgroup label="<liferay-ui:message key="vocabularies" />">

						<%
						for (AssetVocabulary assetVocabulary : assetVocabularies) {
						%>

							<aui:option label="<%= HtmlUtil.escape(assetVocabulary.getTitle(locale)) %>" selected="<%= assetVocabularyId == assetVocabulary.getVocabularyId() %>" value="<%= assetVocabulary.getVocabularyId() %>" />

						<%
						}
						%>

					</optgroup>

			<%
				}
			}
			%>

			<%
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil.getGroupVocabularies(companyGroup.getGroupId(), false);

			if (!assetVocabularies.isEmpty()) {
			%>

				<optgroup label="<liferay-ui:message key="vocabularies" /> (<liferay-ui:message key="global" />)">

					<%
					for (AssetVocabulary assetVocabulary : assetVocabularies) {
					%>

						<aui:option label="<%= HtmlUtil.escape(assetVocabulary.getTitle(locale)) %>" selected="<%= assetVocabularyId == assetVocabulary.getVocabularyId() %>" value="<%= assetVocabulary.getVocabularyId() %>" />

					<%
					}
					%>

				</optgroup>

			<%
			}
			%>

		</aui:select>
	</aui:col>
</aui:row>