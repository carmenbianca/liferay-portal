<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<div class="row">
	<div class="col-md-4">
		<clay:vertical-card
			verticalCard="<%= new JournalDDMTemplateVerticalCard(journalContentDisplayContext.getDDMTemplate(), request) %>"
		/>
	</div>
</div>