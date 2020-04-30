/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface StyledDSField<T extends DSField<?>> extends DSField<T> {

	public Boolean getBold();

	public String getFont();

	public String getFontColor();

	public String getFontSize();

	public Integer getHeight();

	public Boolean getItalic();

	public Boolean getUnderline();

	public Integer getWidth();

}