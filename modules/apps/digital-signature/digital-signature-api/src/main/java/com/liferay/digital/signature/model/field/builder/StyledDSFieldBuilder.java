/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field.builder;

import com.liferay.digital.signature.model.field.DSField;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface StyledDSFieldBuilder<T extends DSField<?>>
	extends DSFieldBuilder<T> {

	public <S> S setBold(Boolean bold);

	public <S> S setFont(String font);

	public <S> S setFontColor(String fontColor);

	public <S> S setFontSize(String fontSize);

	public <S> S setHeight(Integer height);

	public <S> S setItalic(Boolean italic);

	public <S> S setUnderline(Boolean underline);

	public <S> S setWidth(Integer width);

}