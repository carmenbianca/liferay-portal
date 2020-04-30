<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/init.jsp" %>

<blockquote>
	<p>Badges help highlight important information such as notifications or new and unread messages. Badges have circular borders and are only used to specify a number.</p>
</blockquote>

<div class="row text-center">
	<div class="col-md-1">
		<clay:badge
			label="8"
		/>

		<div>Primary</div>
	</div>

	<div class="col-md-1">
		<clay:badge
			label="87"
			style="secondary"
		/>

		<div>Secondary</div>
	</div>

	<div class="col-md-1">
		<clay:badge
			label="91"
			style="info"
		/>

		<div>Info</div>
	</div>

	<div class="col-md-1">
		<clay:badge
			label="130"
			style="danger"
		/>

		<div>Error</div>
	</div>

	<div class="col-md-1">
		<clay:badge
			label="1111"
			style="success"
		/>

		<div>Success</div>
	</div>

	<div class="col-md-1">
		<clay:badge
			label="21"
			style="warning"
		/>

		<div>Warning</div>
	</div>
</div>