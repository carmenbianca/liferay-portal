<%--
/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/document_library/init.jsp" %>

<aui:script use="aui-base,uploader">
	if (!A.UA.ios && A.Uploader.TYPE != 'none') {
		var uploadMultipleDocumentsIcon = A.all(
			'.upload-multiple-documents:hidden'
		);

		uploadMultipleDocumentsIcon.show();
	}
</aui:script>