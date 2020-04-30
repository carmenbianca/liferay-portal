/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.StyledDSField;

/**
 * @author Michael C. Han
 */
public abstract class StyledDSFieldImpl<T extends DSField<?>>
	extends DSFieldImpl<T> implements StyledDSField<T> {

	public StyledDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public Boolean getBold() {
		return _bold;
	}

	@Override
	public String getFont() {
		return _font;
	}

	@Override
	public String getFontColor() {
		return _fontColor;
	}

	@Override
	public String getFontSize() {
		return _fontSize;
	}

	@Override
	public Integer getHeight() {
		return _height;
	}

	@Override
	public Boolean getItalic() {
		return _italic;
	}

	@Override
	public Boolean getUnderline() {
		return _underline;
	}

	@Override
	public Integer getWidth() {
		return _width;
	}

	public void setBold(Boolean bold) {
		_bold = bold;
	}

	public void setFont(String font) {
		_font = font;
	}

	public void setFontColor(String fontColor) {
		_fontColor = fontColor;
	}

	public void setFontSize(String fontSize) {
		_fontSize = fontSize;
	}

	public void setHeight(Integer height) {
		_height = height;
	}

	public void setItalic(Boolean italic) {
		_italic = italic;
	}

	public void setUnderline(Boolean underline) {
		_underline = underline;
	}

	public void setWidth(Integer width) {
		_width = width;
	}

	private Boolean _bold;
	private String _font;
	private String _fontColor;
	private String _fontSize;
	private Integer _height;
	private Boolean _italic;
	private Boolean _underline;
	private Integer _width;

}