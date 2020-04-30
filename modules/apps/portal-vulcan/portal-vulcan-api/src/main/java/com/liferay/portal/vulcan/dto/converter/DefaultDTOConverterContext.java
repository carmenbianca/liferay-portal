/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.dto.converter;

import com.liferay.portal.kernel.model.User;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.core.UriInfo;

/**
 * @author Rubén Pulido
 * @author Víctor Galán
 */
public class DefaultDTOConverterContext implements DTOConverterContext {

	public DefaultDTOConverterContext(
		boolean acceptAllLanguages, DTOConverterRegistry dtoConverterRegistry,
		Object id, Locale locale, UriInfo uriInfo, User user) {

		this(
			acceptAllLanguages, new HashMap<>(), dtoConverterRegistry, id,
			locale, uriInfo, user);
	}

	public DefaultDTOConverterContext(
		boolean acceptAllLanguages, Map<String, Map<String, String>> actions,
		DTOConverterRegistry dtoConverterRegistry, Object id, Locale locale,
		UriInfo uriInfo, User user) {

		_acceptAllLanguages = acceptAllLanguages;
		_actions = actions;
		_dtoConverterRegistry = dtoConverterRegistry;
		_id = id;
		_locale = locale;
		_uriInfo = uriInfo;
		_user = user;
	}

	public DefaultDTOConverterContext(
		DTOConverterRegistry dtoConverterRegistry, Object id, Locale locale,
		UriInfo uriInfo, User user) {

		this(false, dtoConverterRegistry, id, locale, uriInfo, user);
	}

	public DefaultDTOConverterContext(Object id, Locale locale) {
		this(id, locale, null, null);
	}

	public DefaultDTOConverterContext(
		Object id, Locale locale, UriInfo uriInfo) {

		this(id, locale, uriInfo, null);
	}

	public DefaultDTOConverterContext(
		Object id, Locale locale, UriInfo uriInfo, User user) {

		this(false, new HashMap<>(), null, id, locale, uriInfo, user);
	}

	@Override
	public Map<String, Map<String, String>> getActions() {
		return _actions;
	}

	@Override
	public DTOConverterRegistry getDTOConverterRegistry() {
		return _dtoConverterRegistry;
	}

	@Override
	public Object getId() {
		return _id;
	}

	@Override
	public Locale getLocale() {
		return _locale;
	}

	@Override
	public Optional<UriInfo> getUriInfoOptional() {
		return Optional.ofNullable(_uriInfo);
	}

	@Override
	public User getUser() {
		return _user;
	}

	@Override
	public long getUserId() {
		if (_user != null) {
			return _user.getUserId();
		}

		return 0;
	}

	@Override
	public boolean isAcceptAllLanguages() {
		return _acceptAllLanguages;
	}

	private final boolean _acceptAllLanguages;
	private final Map<String, Map<String, String>> _actions;
	private final DTOConverterRegistry _dtoConverterRegistry;
	private final Object _id;
	private final Locale _locale;
	private UriInfo _uriInfo;
	private final User _user;

}