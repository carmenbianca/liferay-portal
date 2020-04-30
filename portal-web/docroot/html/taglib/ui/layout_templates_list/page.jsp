<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/html/taglib/init.jsp" %>

<%
String layoutTemplateId = (String)request.getAttribute("liferay-ui:layout-templates-list:layoutTemplateId");
String layoutTemplateIdPrefix = (String)request.getAttribute("liferay-ui:layout-templates-list:layoutTemplateIdPrefix");
List<LayoutTemplate> layoutTemplates = (List<LayoutTemplate>)request.getAttribute("liferay-ui:layout-templates-list:layoutTemplates");
%>

<div class="container-fluid lfr-page-layouts">
	<ul class="list-unstyled row">

		<%
		layoutTemplates = PluginUtil.restrictPlugins(layoutTemplates, user);

		for (int i = 0; i < layoutTemplates.size(); i++) {
			LayoutTemplate layoutTemplate = layoutTemplates.get(i);

			String templateId = layoutTemplate.getLayoutTemplateId();

			// LPS-90259

			if (templateId.equals("1_column_dynamic")) {
				continue;
			}
		%>

			<li class="col-lg-3 col-md-4 col-sm-6 lfr-layout-template">
				<div class="checkbox-card">
					<label class="d-block" for="<portlet:namespace /><%= layoutTemplateIdPrefix + "layoutTemplateId" + i %>">
						<aui:input checked="<%= layoutTemplateId.equals(layoutTemplate.getLayoutTemplateId()) %>" id='<%= layoutTemplateIdPrefix + "layoutTemplateId" + i %>' label="" name="layoutTemplateId" type="radio" value="<%= layoutTemplate.getLayoutTemplateId() %>" wrappedField="<%= true %>" />

						<div class="card card-horizontal">
							<div class="card-body card-row">
								<div class="autofit-col">
									<img alt="" class="layout-template-entry inline-item-before modify-linkm <%= layoutTemplateId.equals(layoutTemplate.getLayoutTemplateId()) ? "layout-selected" : StringPool.BLANK %>" height="28" onclick="document.getElementById('<portlet:namespace /><%= layoutTemplateIdPrefix + "layoutTemplateId" + i %>').checked = true;" src="<%= layoutTemplate.getStaticResourcePath() %><%= HtmlUtil.escapeAttribute(layoutTemplate.getThumbnailPath()) %>" width="28" />
								</div>

								<div class="autofit-col autofit-col-expand">
									<span class="text-truncate" title="<%= HtmlUtil.escape(layoutTemplate.getName(locale)) %>"><%= HtmlUtil.escape(layoutTemplate.getName(locale)) %></span>
								</div>
							</div>
						</div>
					</label>
				</div>
			</li>

		<%
		}
		%>

	</ul>
</div>