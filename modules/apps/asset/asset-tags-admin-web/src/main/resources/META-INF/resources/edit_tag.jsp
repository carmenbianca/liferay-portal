<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

if (Validator.isNull(redirect)) {
	PortletURL portletURL = renderResponse.createRenderURL();

	redirect = portletURL.toString();
}

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle(assetTagsDisplayContext.getAssetTitle());
%>

<portlet:actionURL name="editTag" var="editTagURL">
	<portlet:param name="mvcPath" value="/edit_tag.jsp" />
</portlet:actionURL>

<liferay-frontend:edit-form
	action="<%= editTagURL %>"
	method="post"
	name="fm"
>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<liferay-frontend:edit-form-body>
		<liferay-ui:error exception="<%= AssetTagException.class %>">

			<%
			AssetTagException ate = (AssetTagException)errorException;
			%>

			<c:choose>
				<c:when test="<%= ate.getType() == AssetTagException.INVALID_CHARACTER %>">
					<liferay-ui:message arguments='<%= new String[] {"tag-name", StringUtil.merge(AssetHelper.INVALID_CHARACTERS, StringPool.SPACE)} %>' key="the-x-cannot-contain-the-following-invalid-characters-x" />
				</c:when>
				<c:when test="<%= ate.getType() == AssetTagException.MAX_LENGTH %>">
					<liferay-ui:message arguments='<%= new String[] {"tag-name", String.valueOf(ModelHintsUtil.getMaxLength(AssetTag.class.getName(), "name"))} %>' key="the-x-cannot-contain-more-than-x-characters" />
				</c:when>
			</c:choose>
		</liferay-ui:error>

		<liferay-ui:error exception="<%= AssetTagNameException.class %>" message="tag-name-cannot-be-an-empty-string" />

		<liferay-ui:error exception="<%= DuplicateTagException.class %>" message="a-tag-with-that-name-already-exists" />

		<aui:model-context bean="<%= assetTagsDisplayContext.getTag() %>" model="<%= AssetTag.class %>" />

		<liferay-frontend:fieldset-group>
			<liferay-frontend:fieldset>
				<aui:input name="tagId" type="hidden" value="<%= assetTagsDisplayContext.getTagId() %>" />

				<aui:input autoFocus="<%= true %>" cssClass="tag-name" name="name" placeholder="name" />
			</liferay-frontend:fieldset>
		</liferay-frontend:fieldset-group>
	</liferay-frontend:edit-form-body>

	<liferay-frontend:edit-form-footer>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</liferay-frontend:edit-form-footer>
</liferay-frontend:edit-form>