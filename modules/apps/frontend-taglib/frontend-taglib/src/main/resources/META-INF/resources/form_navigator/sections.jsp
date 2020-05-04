<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/form_navigator/init.jsp" %>

<%
List<FormNavigatorEntry<Object>> formNavigatorEntries = (List<FormNavigatorEntry<Object>>)request.getAttribute(FormNavigatorWebKeys.FORM_NAVIGATOR_ENTRIES);
%>

<liferay-frontend:fieldset-group>

	<%
	final FormNavigatorEntry formNavigatorEntry = formNavigatorEntries.get(0);

	String sectionId = namespace + _getSectionId(formNavigatorEntry.getKey());

	String errorSection = null;
	%>

	<!-- Begin fragment <%= sectionId %> -->

	<liferay-frontend:fieldset
		collapsible="<%= formNavigatorEntries.size() > 1 %>"
		cssClass="<%= fieldSetCssClass %>"
		id="<%= _getSectionId(formNavigatorEntry.getKey()) %>"
		label="<%= (formNavigatorEntries.size() > 1) ? formNavigatorEntry.getLabel(locale) : StringPool.BLANK %>"
	>

		<%
		PortalIncludeUtil.include(
			pageContext,
			new PortalIncludeUtil.HTMLRenderer() {

				public void renderHTML(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
					formNavigatorEntry.include(request, response);
				}

			});

		errorSection = (String)request.getAttribute(WebKeys.ERROR_SECTION);

		if (Objects.equals(formNavigatorEntry.getKey(), errorSection)) {
			request.setAttribute(WebKeys.ERROR_SECTION, null);
		}
		%>

	</liferay-frontend:fieldset>

	<!-- End fragment <%= sectionId %> -->

	<%
	for (int i = 1; i < formNavigatorEntries.size(); i++) {
		final FormNavigatorEntry curFormNavigatorEntry = formNavigatorEntries.get(i);

		sectionId = namespace + _getSectionId(curFormNavigatorEntry.getKey());
	%>

		<!-- Begin fragment <%= sectionId %> -->

		<liferay-frontend:fieldset
			collapsed="<%= true %>"
			collapsible="<%= true %>"
			cssClass="<%= fieldSetCssClass %>"
			id="<%= _getSectionId(curFormNavigatorEntry.getKey()) %>"
			label="<%= curFormNavigatorEntry.getLabel(locale) %>"
		>

			<%
			PortalIncludeUtil.include(
				pageContext,
				new PortalIncludeUtil.HTMLRenderer() {

					public void renderHTML(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
						curFormNavigatorEntry.include(request, response);
					}

				});
			%>

		</liferay-frontend:fieldset>

		<!-- End fragment <%= sectionId %> -->

	<%
		String curErrorSection = (String)request.getAttribute(WebKeys.ERROR_SECTION);

		if (Objects.equals(_getSectionId(curFormNavigatorEntry.getKey()), _getSectionId(curErrorSection))) {
			errorSection = curErrorSection;

			request.setAttribute(WebKeys.ERROR_SECTION, null);
		}
	}
	%>

	<%
	if (Validator.isNotNull(errorSection)) {
		String currentTab = (String)request.getAttribute(FormNavigatorWebKeys.CURRENT_TAB);

		request.setAttribute(FormNavigatorWebKeys.ERROR_TAB, currentTab);
	%>

		<aui:script sandbox="<%= true %>">
			var focusField;

			var sectionContent = document.querySelector(
				'#<%= _getSectionId(errorSection) %>Content'
			);

			<%
			String focusField = (String)request.getAttribute("liferay-ui:error:focusField");
			%>

			<c:choose>
				<c:when test="<%= Validator.isNotNull(focusField) %>">
					focusField = sectionContent.querySelector(
						'#<portlet:namespace /><%= focusField %>'
					);
				</c:when>
				<c:otherwise>
					focusField = sectionContent.querySelector('input:not([type="hidden"]).field');
				</c:otherwise>
			</c:choose>

			Liferay.once('<portlet:namespace />formReady', function(event) {
				if (!sectionContent.classList.contains('show')) {
					if (focusField) {
						Liferay.on('liferay.collapse.shown', function(event) {
							var panelId = event.panel.getAttribute('id');

							if (panelId === sectionContent.getAttribute('id')) {
								Liferay.Util.focusFormField(focusField);
							}
						});
					}

					Liferay.CollapseProvider.show({panel: sectionContent});
				}
				else if (focusField) {
					Liferay.Util.focusFormField(focusField);
				}
			});
		</aui:script>

	<%
	}
	%>

</liferay-frontend:fieldset-group>