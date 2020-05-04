/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.taglib.servlet.taglib;

import com.liferay.data.engine.renderer.DataLayoutRendererContext;
import com.liferay.data.engine.rest.dto.v2_0.DataDefinition;
import com.liferay.data.engine.rest.dto.v2_0.DataLayout;
import com.liferay.data.engine.taglib.servlet.taglib.base.BaseDataLayoutRendererTag;
import com.liferay.data.engine.taglib.servlet.taglib.util.DataLayoutTaglibUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.RenderResponse;

import javax.servlet.jsp.JspException;

/**
 * @author Jeyvison Nascimento
 */
public class DataLayoutRendererTag extends BaseDataLayoutRendererTag {

	@Override
	public int doStartTag() throws JspException {
		int result = super.doStartTag();

		setNamespacedAttribute(request, "content", _getContent());

		return result;
	}

	private String _getContent() {
		String content = StringPool.BLANK;

		try {
			DataLayoutRendererContext dataLayoutRendererContext =
				new DataLayoutRendererContext();

			dataLayoutRendererContext.setContainerId(getContainerId());

			if (Validator.isNotNull(getDataRecordId())) {
				dataLayoutRendererContext.setDataRecordValues(
					DataLayoutTaglibUtil.getDataRecordValues(
						getDataRecordId(), request));
			}
			else {
				dataLayoutRendererContext.setDataRecordValues(
					getDataRecordValues());
			}

			dataLayoutRendererContext.setHttpServletRequest(request);
			dataLayoutRendererContext.setHttpServletResponse(
				PortalUtil.getHttpServletResponse(
					(RenderResponse)request.getAttribute(
						JavaConstants.JAVAX_PORTLET_RESPONSE)));
			dataLayoutRendererContext.setPortletNamespace(getNamespace());

			if (Validator.isNotNull(getDataLayoutId())) {
				content = DataLayoutTaglibUtil.renderDataLayout(
					getDataLayoutId(), dataLayoutRendererContext);
			}
			else if (Validator.isNotNull(getDataDefinitionId())) {
				DataDefinition dataDefinition =
					DataLayoutTaglibUtil.getDataDefinition(
						getDataDefinitionId(), request);

				DataLayout dataLayout = dataDefinition.getDefaultDataLayout();

				if (dataLayout != null) {
					content = DataLayoutTaglibUtil.renderDataLayout(
						dataLayout.getId(), dataLayoutRendererContext);
				}
			}
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		return content;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DataLayoutRendererTag.class);

}