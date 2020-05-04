/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.reading.time.taglib.servlet.taglib;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.reading.time.message.ReadingTimeMessageProvider;
import com.liferay.reading.time.model.ReadingTimeEntry;
import com.liferay.reading.time.service.ReadingTimeEntryLocalServiceUtil;
import com.liferay.reading.time.taglib.internal.servlet.servlet.reading.time.ReadingTimeUtil;
import com.liferay.taglib.util.AttributesTagSupport;

import java.io.IOException;

import java.time.Duration;

import java.util.Optional;

import javax.portlet.RenderResponse;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTag;

/**
 * @author Alejandro Tardín
 */
public class ReadingTimeTag extends AttributesTagSupport implements BodyTag {

	@Override
	public int doEndTag() throws JspException {
		try {
			Optional<Duration> readingTimeDurationOptional =
				_getReadingTimeDurationOptional();

			Optional<String> tagOptional = readingTimeDurationOptional.flatMap(
				this::_buildTag);

			if (tagOptional.isPresent()) {
				JspWriter jspWriter = pageContext.getOut();

				jspWriter.write(tagOptional.get());
			}

			return EVAL_PAGE;
		}
		catch (IOException ioException) {
			throw new JspException(ioException);
		}
	}

	public void setDisplayStyle(String displayStyle) {
		_displayStyle = displayStyle;
	}

	public void setId(String id) {
		_id = id;
	}

	public void setModel(GroupedModel groupedModel) {
		_groupedModel = groupedModel;
	}

	private Optional<String> _buildTag(Duration readingTimeDuration) {
		String readingTimeMessage = _getReadingTimeMessage(readingTimeDuration);

		if (Validator.isNotNull(readingTimeMessage)) {
			StringBundler sb = new StringBundler(10);

			sb.append("<time class=\"reading-time\" datetime=\"");
			sb.append(String.valueOf(readingTimeDuration.getSeconds()));
			sb.append("s\"");

			if (Validator.isNotNull(_id)) {
				sb.append(" id=\"");
				sb.append(_getNamespace());
				sb.append(_id);
				sb.append("\"");
			}

			sb.append(">");
			sb.append(readingTimeMessage);
			sb.append("</time>");

			return Optional.of(sb.toString());
		}

		return Optional.empty();
	}

	private String _getNamespace() {
		RenderResponse renderResponse = (RenderResponse)request.getAttribute(
			JavaConstants.JAVAX_PORTLET_RESPONSE);

		return renderResponse.getNamespace();
	}

	private Optional<Duration> _getReadingTimeDurationOptional() {
		if (_groupedModel == null) {
			return Optional.of(Duration.ZERO);
		}

		ReadingTimeEntry readingTimeEntry =
			ReadingTimeEntryLocalServiceUtil.fetchOrAddReadingTimeEntry(
				_groupedModel);

		if (readingTimeEntry != null) {
			return Optional.of(
				Duration.ofMillis(readingTimeEntry.getReadingTime()));
		}

		return Optional.empty();
	}

	private String _getReadingTimeMessage(Duration readingTimeDuration) {
		ReadingTimeMessageProvider readingTimeMessageProvider =
			ReadingTimeUtil.getReadingTimeMessageProvider(_displayStyle);

		if (readingTimeMessageProvider == null) {
			return null;
		}

		return readingTimeMessageProvider.provide(
			readingTimeDuration, PortalUtil.getLocale(request));
	}

	private String _displayStyle = "simple";
	private GroupedModel _groupedModel;
	private String _id;

}