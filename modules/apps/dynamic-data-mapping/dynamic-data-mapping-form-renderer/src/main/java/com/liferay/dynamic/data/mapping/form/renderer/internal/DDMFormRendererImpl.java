/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.renderer.internal;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeServicesTracker;
import com.liferay.dynamic.data.mapping.form.renderer.DDMFormRenderer;
import com.liferay.dynamic.data.mapping.form.renderer.DDMFormRenderingContext;
import com.liferay.dynamic.data.mapping.form.renderer.DDMFormRenderingException;
import com.liferay.dynamic.data.mapping.form.renderer.DDMFormTemplateContextFactory;
import com.liferay.dynamic.data.mapping.form.renderer.internal.servlet.taglib.DDMFormFieldTypesDynamicInclude;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormLayout;
import com.liferay.dynamic.data.mapping.util.DDM;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.petra.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.servlet.taglib.DynamicIncludeUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.template.soy.renderer.ComponentDescriptor;
import com.liferay.portal.template.soy.renderer.SoyComponentRenderer;

import java.io.Writer;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marcellus Tavares
 */
@Component(immediate = true, service = DDMFormRenderer.class)
public class DDMFormRendererImpl implements DDMFormRenderer {

	@Override
	public String render(
			DDMForm ddmForm, DDMFormLayout ddmFormLayout,
			DDMFormRenderingContext ddmFormRenderingContext)
		throws DDMFormRenderingException {

		try {
			return doRender(ddmForm, ddmFormLayout, ddmFormRenderingContext);
		}
		catch (DDMFormRenderingException ddmFormRenderingException) {
			throw ddmFormRenderingException;
		}
		catch (Exception exception) {
			throw new DDMFormRenderingException(exception);
		}
	}

	@Override
	public String render(
			DDMForm ddmForm, DDMFormRenderingContext ddmFormRenderingContext)
		throws DDMFormRenderingException {

		try {
			return doRender(
				ddmForm, _ddm.getDefaultDDMFormLayout(ddmForm),
				ddmFormRenderingContext);
		}
		catch (DDMFormRenderingException ddmFormRenderingException) {
			throw ddmFormRenderingException;
		}
		catch (Exception exception) {
			throw new DDMFormRenderingException(exception);
		}
	}

	protected String doRender(
			DDMForm ddmForm, DDMFormLayout ddmFormLayout,
			DDMFormRenderingContext ddmFormRenderingContext)
		throws Exception {

		Set<String> dependencies = new HashSet<>();

		List<DDMFormFieldType> ddmFormFieldTypes =
			_ddmFormFieldTypeServicesTracker.getDDMFormFieldTypes();

		for (DDMFormFieldType ddmFormFieldType : ddmFormFieldTypes) {
			String moduleName = ddmFormFieldType.getModuleName();

			if (Validator.isNotNull(moduleName)) {
				if (ddmFormFieldType.isCustomDDMFormFieldType()) {
					dependencies.add(moduleName);
				}
				else {
					dependencies.add(
						_npmResolver.resolveModuleName(moduleName));
				}
			}
		}

		ComponentDescriptor componentDescriptor = new ComponentDescriptor(
			_TEMPLATE_NAMESPACE, _npmResolver.resolveModuleName(_MODULE_NAME),
			ddmFormRenderingContext.getContainerId(), dependencies);

		Writer writer = new UnsyncStringWriter();

		_soyComponentRenderer.renderSoyComponent(
			ddmFormRenderingContext.getHttpServletRequest(), writer,
			componentDescriptor,
			getContext(ddmForm, ddmFormLayout, ddmFormRenderingContext));

		DynamicIncludeUtil.include(
			ddmFormRenderingContext.getHttpServletRequest(),
			ddmFormRenderingContext.getHttpServletResponse(),
			DDMFormFieldTypesDynamicInclude.class.getName(), true);

		DynamicIncludeUtil.include(
			ddmFormRenderingContext.getHttpServletRequest(),
			ddmFormRenderingContext.getHttpServletResponse(),
			DDMFormRenderer.class.getName() + "#formRendered", true);

		return writer.toString();
	}

	protected Map<String, Object> getContext(
			DDMForm ddmForm, DDMFormLayout ddmFormLayout,
			DDMFormRenderingContext ddmFormRenderingContext)
		throws PortalException {

		Map<String, Object> ddmFormTemplateContext =
			_ddmFormTemplateContextFactory.create(
				ddmForm, ddmFormLayout, ddmFormRenderingContext);

		ddmFormTemplateContext.put("editable", false);

		ddmFormTemplateContext.remove("fieldTypes");

		HttpServletRequest httpServletRequest =
			ddmFormRenderingContext.getHttpServletRequest();

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		String pathThemeImages = themeDisplay.getPathThemeImages();

		String spriteMap = pathThemeImages.concat("/clay/icons.svg");

		ddmFormTemplateContext.put("spritemap", spriteMap);

		return ddmFormTemplateContext;
	}

	private static final String _MODULE_NAME =
		"dynamic-data-mapping-form-renderer/js/containers/Form/Form.es";

	private static final String _TEMPLATE_NAMESPACE = "FormRenderer.render";

	@Reference
	private DDM _ddm;

	@Reference
	private DDMFormFieldTypeServicesTracker _ddmFormFieldTypeServicesTracker;

	@Reference
	private DDMFormTemplateContextFactory _ddmFormTemplateContextFactory;

	@Reference
	private NPMResolver _npmResolver;

	@Reference
	private SoyComponentRenderer _soyComponentRenderer;

}