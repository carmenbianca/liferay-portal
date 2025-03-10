<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/admin/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long kaleoProcessId = ParamUtil.getLong(request, "kaleoProcessId");

KaleoProcess kaleoProcess = KaleoProcessServiceUtil.getKaleoProcess(kaleoProcessId);

long groupId = BeanParamUtil.getLong(kaleoProcess, request, "groupId", scopeGroupId);

long workflowTaskId = ParamUtil.getLong(request, "workflowTaskId");

WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(company.getCompanyId(), workflowTaskId);

KaleoProcessLink kaleoProcessLink = KaleoProcessLinkLocalServiceUtil.fetchKaleoProcessLink(kaleoProcessId, workflowTask.getName());

long ddmTemplateId = 0;

if (kaleoProcessLink != null) {
	DDMTemplate ddmTemplate = DDMTemplateLocalServiceUtil.fetchTemplate(kaleoProcessLink.getDDMTemplateId());

	if (ddmTemplate != null) {
		ddmTemplateId = ddmTemplate.getTemplateId();
	}
}

long ddlRecordId = ParamUtil.getLong(request, "ddlRecordId");

DDLRecord ddlRecord = DDLRecordLocalServiceUtil.getDDLRecord(ddlRecordId);

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

renderResponse.setTitle((ddlRecord != null) ? LanguageUtil.format(request, "edit-x", kaleoProcess.getName(locale), false) : LanguageUtil.format(request, "new-x", kaleoProcess.getName(locale), false));
%>

<portlet:actionURL name="updateDDLRecord" var="updateDDLRecordURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="kaleoProcessId" value="<%= String.valueOf(kaleoProcessId) %>" />
</portlet:actionURL>

<clay:container
	className="sidenav-container sidenav-right"
>
	<div class="lfr-form-content">
		<aui:form action="<%= updateDDLRecordURL %>" cssClass="lfr-dynamic-form" enctype="multipart/form-data" onSubmit='<%= "event.preventDefault(); submitForm(event.target);" %>'>
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
			<aui:input name="groupId" type="hidden" value="<%= String.valueOf(groupId) %>" />
			<aui:input name="ddlRecordId" type="hidden" value="<%= String.valueOf(ddlRecordId) %>" />
			<aui:input name="ddlRecordSetId" type="hidden" value="<%= String.valueOf(kaleoProcess.getDDLRecordSetId()) %>" />
			<aui:input name="ddmTemplateId" type="hidden" value="<%= String.valueOf(ddmTemplateId) %>" />
			<aui:input name="workflowAction" type="hidden" value="<%= WorkflowConstants.ACTION_SAVE_DRAFT %>" />
			<aui:input name="workflowTaskId" type="hidden" value="<%= String.valueOf(workflowTaskId) %>" />

			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset>

					<%
					long classNameId = 0;
					long classPK = 0;

					if (ddmTemplateId > 0) {
						classNameId = PortalUtil.getClassNameId(DDMTemplate.class);
						classPK = ddmTemplateId;
					}
					else {
						DDLRecordSet ddlRecordSet = kaleoProcess.getDDLRecordSet();

						DDMStructure ddmStructure = ddlRecordSet.getDDMStructure();

						classNameId = PortalUtil.getClassNameId(DDMStructure.class);
						classPK = ddmStructure.getStructureId();
					}
					%>

					<liferay-ddm:html
						classNameId="<%= classNameId %>"
						classPK="<%= classPK %>"
						ddmFormValues="<%= kaleoFormsAdminDisplayContext.getDDMFormValues(ddlRecord.getDDMStorageId()) %>"
						requestedLocale="<%= locale %>"
					/>
				</aui:fieldset>
			</aui:fieldset-group>

			<aui:button-row>
				<aui:button cssClass="btn-lg" name="saveButton" type="submit" value="save" />

				<aui:button cssClass="btn-lg" href="<%= redirect %>" name="cancelButton" type="cancel" />
			</aui:button-row>
		</aui:form>
	</div>
</clay:container>

<%
if (ddlRecord != null) {
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.format(request, "edit-x", kaleoProcess.getName(locale), false), currentURL);
}
else {
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.format(request, "add-x", kaleoProcess.getName(locale), false), currentURL);
}
%>