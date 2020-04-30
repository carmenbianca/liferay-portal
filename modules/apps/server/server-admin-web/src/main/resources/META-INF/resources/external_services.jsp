<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<div class="server-admin-tabs">
	<aui:fieldset>
		<liferay-ui:panel-container
			extended="<%= true %>"
			id="adminExternalServicesPanelContainer"
			persistState="<%= true %>"
		>
			<liferay-ui:panel
				collapsible="<%= true %>"
				extended="<%= true %>"
				id="adminImageMagickConversionPanel"
				markupView="lexicon"
				persistState="<%= true %>"
				title="enabling-imagemagick-provides-document-preview-functionality"
			>
				<aui:input label="enabled" name="imageMagickEnabled" type="checkbox" value="<%= ImageMagickUtil.isEnabled() %>" />

				<aui:input cssClass="lfr-input-text-container" label="path" name="imageMagickPath" type="text" value="<%= ImageMagickUtil.getGlobalSearchPath() %>" />

				<aui:fieldset label="resource-limits">

					<%
					Properties resourceLimitsProperties = ImageMagickUtil.getResourceLimitsProperties();

					for (String label : _IMAGEMAGICK_RESOURCE_LIMIT_LABELS) {
						String name = "imageMagickLimit" + StringUtil.upperCaseFirstLetter(label);
					%>

						<aui:input cssClass="lfr-input-text-container" label="<%= label %>" name="<%= name %>" type="text" value="<%= resourceLimitsProperties.getProperty(label) %>" />

					<%
					}
					%>

				</aui:fieldset>
			</liferay-ui:panel>

			<liferay-ui:panel
				collapsible="<%= true %>"
				extended="<%= true %>"
				id="adminXugglerPanel"
				markupView="lexicon"
				persistState="<%= true %>"
				title="enabling-xuggler-provides-video-conversion-functionality"
			>
				<liferay-ui:error exception="<%= XugglerInstallException.class %>" targetNode="#controlMenuAlertsContainer">

					<%
					XugglerInstallException xie = (XugglerInstallException)errorException;
					%>

					<liferay-ui:message arguments="<%= xie.getMessage() %>" key="an-unexpected-error-occurred-while-installing-xuggler-x" translateArguments="<%= false %>" />
				</liferay-ui:error>

				<c:choose>
					<c:when test="<%= XugglerUtil.isNativeLibraryInstalled() %>">
						<div class="alert alert-info">
							<liferay-ui:message key="xuggler-installed" />
						</div>

						<aui:input label="enabled" name="xugglerEnabled" type="checkbox" value="<%= XugglerUtil.isEnabled() %>" />
					</c:when>
					<c:when test="<%= XugglerUtil.isNativeLibraryCopied() %>">
						<div class="alert alert-info">
							<liferay-ui:message key="xuggler-has-been-installed-you-need-to-reboot-your-server-to-apply-changes" />
						</div>
					</c:when>
					<c:otherwise>

						<%
						String xugglerHelp = LanguageUtil.format(request, "xuggler-help", "http://www.xuggle.com/xuggler/downloads", false);

						String[] xugglerOptions = PropsUtil.getArray(PropsKeys.XUGGLER_JAR_OPTIONS);

						String bitMode = OSDetector.getBitMode();

						String guess = StringPool.BLANK;

						if (Validator.isNotNull(bitMode) && (bitMode.equals("32") || bitMode.equals("64"))) {
							if (OSDetector.isApple()) {
								guess = bitMode + "-mac";
							}
							else if (OSDetector.isLinux()) {
								guess = bitMode + "-linux";
							}
							else if (OSDetector.isWindows()) {
								guess = bitMode + "-win";
							}

							if (Validator.isNotNull(guess)) {
								boolean found = false;

								for (String xugglerOption : xugglerOptions) {
									if (xugglerOption.equals(guess)) {
										found = true;

										break;
									}
								}

								if (!found) {
									guess = StringPool.BLANK;
								}
							}
						}
						%>

						<div class="alert alert-info">
							<liferay-ui:message key="<%= xugglerHelp %>" />
						</div>

						<aui:select label="jar-file" name="jarName">

							<%
							if (Validator.isNull(guess)) {
							%>

								<aui:option label="unknown" value="" />

							<%
							}

							for (String xugglerOption : xugglerOptions) {
								String jarFile = PropsUtil.get(PropsKeys.XUGGLER_JAR_FILE, new Filter(xugglerOption));
								String jarName = PropsUtil.get(PropsKeys.XUGGLER_JAR_NAME, new Filter(xugglerOption));
							%>

								<aui:option label='<%= jarName + " (" + jarFile + ")" %>' selected="<%= xugglerOption.equals(guess) %>" value="<%= jarFile %>" />

							<%
							}
							%>

						</aui:select>

						<aui:button-row>
							<aui:button cssClass="save-server-button" data-cmd="installXuggler" name="installXugglerButton" value="install" />
						</aui:button-row>
					</c:otherwise>
				</c:choose>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</aui:fieldset>
</div>

<aui:button-row>
	<aui:button cssClass="save-server-button" data-cmd="updateExternalServices" value="save" />
</aui:button-row>

<%!
private static final String[] _IMAGEMAGICK_RESOURCE_LIMIT_LABELS = {"area", "disk", "file", "map", "memory", "thread", "time"};
%>