<%--
/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */
--%>

<%@ include file="/edit_form/init.jsp" %>

			<c:if test="<%= (checkboxNames != null) && !checkboxNames.isEmpty() %>">
				<aui:input name="checkboxNames" type="hidden" value="<%= StringUtil.merge(checkboxNames) %>" />
			</c:if>

			<c:if test="<%= Validator.isNotNull(onSubmit) %>">
				</fieldset>
			</c:if>
		</div>

	<c:if test="<%= !themeDisplay.isStatePopUp() %>">
		</div>
	</c:if>
</form>

<%
String fullName = namespace + HtmlUtil.escapeJS(name);
%>

<aui:script use="liferay-form">
	var config = {
		id: '<%= fullName %>',
		validateOnBlur: <%= validateOnBlur %>,
	};

	<c:if test="<%= validatorTagsMap != null %>">
		config.fieldRules = [];

		<%
		int i = 0;

		for (Map.Entry<String, List<ValidatorTag>> entry : validatorTagsMap.entrySet()) {
			String fieldName = entry.getKey();
			List<ValidatorTag> validatorTags = entry.getValue();

			for (ValidatorTag validatorTag : validatorTags) {
		%>

				config.fieldRules.push({
					body: <%= validatorTag.getBody() %>,
					custom: <%= validatorTag.isCustom() %>,
					errorMessage:
						'<%= UnicodeLanguageUtil.get(resourceBundle, validatorTag.getErrorMessage()) %>',
					fieldName: '<%= namespace + HtmlUtil.escapeJS(fieldName) %>',
					validatorName: '<%= validatorTag.getName() %>',
				});

		<%
				i++;
			}
		}
		%>

	</c:if>

	<c:if test="<%= Validator.isNotNull(onSubmit) %>">
		config.onSubmit = function(event) {
			<%= onSubmit %>;
		};
	</c:if>

	Liferay.Form.register(config);

	var onDestroyPortlet = function(event) {
		if (event.portletId === '<%= portletDisplay.getId() %>') {
			delete Liferay.Form._INSTANCES['<%= fullName %>'];
		}
	};

	Liferay.on('destroyPortlet', onDestroyPortlet);

	<c:if test="<%= Validator.isNotNull(onSubmit) %>">
		A.all('#<%= fullName %> .input-container').removeAttribute('disabled');
	</c:if>

	Liferay.fire('<portlet:namespace />formReady', {
		formName: '<%= fullName %>',
	});
</aui:script>