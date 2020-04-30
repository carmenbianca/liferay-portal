/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.dto.converter;

/**
 * @author Rubén Pulido
 * @author Víctor Galán
 */
public interface DTOConverter<E, D> {

	public String getContentType();

	public default E getObject(String externalReferenceCode) throws Exception {
		return null;
	}

	public default D toDTO(DTOConverterContext dtoConverterContext)
		throws Exception {

		E object = getObject(String.valueOf(dtoConverterContext.getId()));

		return toDTO(dtoConverterContext, object);
	}

	public default D toDTO(DTOConverterContext dtoConverterContext, E object)
		throws Exception {

		return null;
	}

	public default D toDTO(E object) throws Exception {
		return toDTO(null, object);
	}

}