<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.util.HashMapBuilder" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.search.web.internal.custom.facet.configuration.CustomFacetPortletInstanceConfiguration" %><%@
page import="com.liferay.portal.search.web.internal.custom.facet.display.context.CustomFacetDisplayContext" %><%@
page import="com.liferay.portal.search.web.internal.custom.facet.display.context.CustomFacetTermDisplayContext" %>

<%@ page import="java.util.List" %><%@
page import="java.util.Map" %>

<portlet:defineObjects />

<%
CustomFacetDisplayContext customFacetDisplayContext = (CustomFacetDisplayContext)java.util.Objects.requireNonNull(request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT));

CustomFacetPortletInstanceConfiguration customFacetPortletInstanceConfiguration = customFacetDisplayContext.getCustomFacetPortletInstanceConfiguration();

Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"customFacetDisplayContext", customFacetDisplayContext
).put(
	"namespace", renderResponse.getNamespace()
).build();

List<CustomFacetTermDisplayContext> customFacetTermDisplayContexts = customFacetDisplayContext.getTermDisplayContexts();
%>

<c:choose>
	<c:when test="<%= customFacetDisplayContext.isRenderNothing() %>">
		<aui:input autocomplete="off" name="<%= HtmlUtil.escapeAttribute(customFacetDisplayContext.getParameterName()) %>" type="hidden" value="<%= customFacetDisplayContext.getParameterValue() %>" />
	</c:when>
	<c:otherwise>
		<aui:form method="post" name="fm">
			<aui:input autocomplete="off" name="<%= HtmlUtil.escapeAttribute(customFacetDisplayContext.getParameterName()) %>" type="hidden" value="<%= customFacetDisplayContext.getParameterValue() %>" />
			<aui:input cssClass="facet-parameter-name" name="facet-parameter-name" type="hidden" value="<%= customFacetDisplayContext.getParameterName() %>" />

			<liferay-ddm:template-renderer
				className="<%= CustomFacetTermDisplayContext.class.getName() %>"
				contextObjects="<%= contextObjects %>"
				displayStyle="<%= customFacetPortletInstanceConfiguration.displayStyle() %>"
				displayStyleGroupId="<%= customFacetDisplayContext.getDisplayStyleGroupId() %>"
				entries="<%= customFacetTermDisplayContexts %>"
			>
				<liferay-ui:panel-container
					extended="<%= true %>"
					id='<%= renderResponse.getNamespace() + "facetCustomPanelContainer" %>'
					markupView="lexicon"
					persistState="<%= true %>"
				>
					<liferay-ui:panel
						collapsible="<%= true %>"
						cssClass="search-facet"
						id='<%= renderResponse.getNamespace() + "facetCustomPanel" %>'
						markupView="lexicon"
						persistState="<%= true %>"
						title="<%= customFacetDisplayContext.getDisplayCaption() %>"
					>
						<aui:fieldset>
							<ul class="list-unstyled">

								<%
								int i = 0;

								for (CustomFacetTermDisplayContext customFacetTermDisplayContext : customFacetDisplayContext.getTermDisplayContexts()) {
									i++;
								%>

									<li class="facet-value">
										<div class="custom-checkbox custom-control">
											<label class="facet-checkbox-label" for="<portlet:namespace />term_<%= i %>">
												<input class="custom-control-input facet-term" data-term-id="<%= customFacetTermDisplayContext.getFieldName() %>" disabled id="<portlet:namespace />term_<%= i %>" name="<portlet:namespace />term_<%= i %>" onChange="Liferay.Search.FacetUtil.changeSelection(event);" type="checkbox" <%= customFacetTermDisplayContext.isSelected() ? "checked" : StringPool.BLANK %> />

												<span class="custom-control-label term-name <%= customFacetTermDisplayContext.isSelected() ? "facet-term-selected" : "facet-term-unselected" %>">
													<span class="custom-control-label-text"><%= HtmlUtil.escape(customFacetTermDisplayContext.getFieldName()) %></span>
												</span>

												<c:if test="<%= customFacetTermDisplayContext.isFrequencyVisible() %>">
													<small class="term-count">
														(<%= customFacetTermDisplayContext.getFrequency() %>)
													</small>
												</c:if>
											</label>
										</div>
									</li>

								<%
								}
								%>

							</ul>
						</aui:fieldset>

						<c:if test="<%= !customFacetDisplayContext.isNothingSelected() %>">
							<aui:button cssClass="btn-link btn-unstyled facet-clear-btn" onClick="Liferay.Search.FacetUtil.clearSelections(event);" value="clear" />
						</c:if>
					</liferay-ui:panel>
				</liferay-ui:panel-container>
			</liferay-ddm:template-renderer>
		</aui:form>
	</c:otherwise>
</c:choose>

<aui:script use="liferay-search-facet-util">
	var facetTerms = document.querySelectorAll(
		'#<portlet:namespace />fm .facet-term'
	);

	facetTerms.forEach(function(term) {
		Liferay.Util.toggleDisabled(term, false);
	});
</aui:script>