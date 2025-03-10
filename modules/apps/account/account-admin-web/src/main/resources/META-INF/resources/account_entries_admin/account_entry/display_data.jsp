<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
AccountEntryDisplay accountEntryDisplay = (AccountEntryDisplay)request.getAttribute(AccountWebKeys.ACCOUNT_ENTRY_DISPLAY);
%>

<div class="sheet-section">
	<h3 class="sheet-subtitle">
		<%= LanguageUtil.get(request, "account-display-data") %>
	</h3>

	<clay:row>
		<clay:col
			md="6"
		>
			<aui:field-wrapper cssClass="form-group lfr-input-text-container">
				<aui:input label="account-name" name="name" required="<%= true %>" type="text" value="<%= (accountEntryDisplay == null) ? StringPool.BLANK : accountEntryDisplay.getName() %>">
					<aui:validator name="maxLength"><%= ModelHintsUtil.getMaxLength(AccountEntry.class.getName(), "name") %></aui:validator>
				</aui:input>
			</aui:field-wrapper>
		</clay:col>

		<clay:col
			md="5"
		>
			<div class="text-center">
				<liferay-ui:logo-selector
					currentLogoURL='<%= ((accountEntryDisplay == null) || (accountEntryDisplay.getLogoId() == 0)) ? themeDisplay.getPathThemeImages() + "/lexicon/briefcase.svg" : accountEntryDisplay.getLogoURL(themeDisplay) %>'
					defaultLogo="<%= (accountEntryDisplay == null) || (accountEntryDisplay.getLogoId() == 0) %>"
					defaultLogoURL='<%= themeDisplay.getPathThemeImages() + "/lexicon/briefcase.svg" %>'
					tempImageFileName='<%= (accountEntryDisplay == null) ? "0" : String.valueOf(accountEntryDisplay.getAccountEntryId()) %>'
				/>
			</div>
		</clay:col>
	</clay:row>

	<aui:field-wrapper cssClass="form-group lfr-input-text-container">
		<aui:input name="description" type="textarea" value="<%= (accountEntryDisplay == null) ? StringPool.BLANK : accountEntryDisplay.getDescription() %>" />
	</aui:field-wrapper>

	<aui:field-wrapper cssClass="form-group lfr-input-text-container">
		<aui:input label="" labelOff="inactive" labelOn="active" name="active" type="toggle-switch" value="<%= (accountEntryDisplay == null) ? true : accountEntryDisplay.isActive() %>" />
	</aui:field-wrapper>
</div>