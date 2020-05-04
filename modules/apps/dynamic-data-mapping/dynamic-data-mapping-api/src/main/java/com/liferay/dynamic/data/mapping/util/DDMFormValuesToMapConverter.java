/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import aQute.bnd.annotation.ProviderType;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Map;

/**
 * @author Leonardo Barros
 */
@ProviderType
public interface DDMFormValuesToMapConverter {

	public Map<String, Object> convert(
			DDMFormValues ddmFormValues, DDMStructure ddmStructure)
		throws PortalException;

}