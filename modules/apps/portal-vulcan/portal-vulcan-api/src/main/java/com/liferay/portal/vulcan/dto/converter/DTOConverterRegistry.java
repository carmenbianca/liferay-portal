/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.dto.converter;

/**
 * @author Rubén Pulido
 * @author Víctor Galán
 */
public interface DTOConverterRegistry {

	public DTOConverter getDTOConverter(String dtoClassName);

}