/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.dto.converter;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.LocaleThreadLocal;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.core.UriInfo;

/**
 * @author Rubén Pulido
 * @author Víctor Galán
 */
public interface DTOConverterContext {

	public default Map<String, Map<String, String>> getActions() {
		return new HashMap<>();
	}

	public default DTOConverterRegistry getDTOConverterRegistry() {
		return null;
	}

	public default Object getId() {
		return null;
	}

	public default Locale getLocale() {
		return LocaleThreadLocal.getDefaultLocale();
	}

	public default Optional<UriInfo> getUriInfoOptional() {
		return Optional.empty();
	}

	public default User getUser() {
		return (User)PermissionThreadLocal.getPermissionChecker();
	}

	public default long getUserId() {
		User user = getUser();

		return user.getUserId();
	}

	public default boolean isAcceptAllLanguages() {
		return true;
	}

}