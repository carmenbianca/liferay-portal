/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.web.internal.portlet.action;

import com.liferay.dynamic.data.mapping.constants.DDMPortletKeys;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.dynamic.data.mapping.model.DDMTemplateConstants;
import com.liferay.dynamic.data.mapping.service.DDMStructureService;
import com.liferay.dynamic.data.mapping.service.DDMTemplateService;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Barros
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DDMPortletKeys.DYNAMIC_DATA_MAPPING,
		"mvc.command.name=copyStructure"
	},
	service = MVCActionCommand.class
)
public class CopyStructureMVCActionCommand extends DDMBaseMVCActionCommand {

	protected DDMStructure copyStructure(ActionRequest actionRequest)
		throws Exception {

		long classPK = ParamUtil.getLong(actionRequest, "classPK");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			DDMStructure.class.getName(), actionRequest);

		DDMStructure structure = _ddmStructureService.copyStructure(
			classPK, nameMap, descriptionMap, serviceContext);

		copyTemplates(actionRequest, classPK, structure.getStructureId());

		return structure;
	}

	protected void copyTemplates(
			ActionRequest actionRequest, long oldClassPK, long newClassPK)
		throws Exception {

		long classNameId = _portal.getClassNameId(DDMStructure.class);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			DDMTemplate.class.getName(), actionRequest);

		long resourceClassNameId = ParamUtil.getLong(
			actionRequest, "resourceClassNameId");
		boolean copyDisplayTemplates = ParamUtil.getBoolean(
			actionRequest, "copyDisplayTemplates");

		if (copyDisplayTemplates) {
			_ddmTemplateService.copyTemplates(
				classNameId, oldClassPK, resourceClassNameId, newClassPK,
				DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY, serviceContext);
		}

		boolean copyFormTemplates = ParamUtil.getBoolean(
			actionRequest, "copyFormTemplates");

		if (copyFormTemplates) {
			_ddmTemplateService.copyTemplates(
				classNameId, oldClassPK, resourceClassNameId, newClassPK,
				DDMTemplateConstants.TEMPLATE_TYPE_FORM, serviceContext);
		}
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		DDMStructure structure = copyStructure(actionRequest);

		setRedirectAttribute(actionRequest, structure);
	}

	@Override
	protected String getSaveAndContinueRedirect(
			ActionRequest actionRequest, DDMStructure structure,
			String redirect)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		LiferayPortletURL portletURL = PortletURLFactoryUtil.create(
			actionRequest, themeDisplay.getPpid(), PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcPath", "/copy_structure");

		long classNameId = _portal.getClassNameId(DDMStructure.class);

		portletURL.setParameter(
			"classNameId", String.valueOf(classNameId), false);

		portletURL.setParameter(
			"classPK", String.valueOf(structure.getStructureId()), false);
		portletURL.setParameter(
			"copyFormTemplates",
			ParamUtil.getString(actionRequest, "copyFormTemplates"), false);
		portletURL.setParameter(
			"copyDisplayTemplates",
			ParamUtil.getString(actionRequest, "copyDisplayTemplates"), false);
		portletURL.setWindowState(actionRequest.getWindowState());

		return portletURL.toString();
	}

	@Reference(unbind = "-")
	protected void setDDMStructureService(
		DDMStructureService ddmStructureService) {

		_ddmStructureService = ddmStructureService;
	}

	@Reference(unbind = "-")
	protected void setDDMTemplateService(
		DDMTemplateService ddmTemplateService) {

		_ddmTemplateService = ddmTemplateService;
	}

	private DDMStructureService _ddmStructureService;
	private DDMTemplateService _ddmTemplateService;

	@Reference
	private Portal _portal;

}