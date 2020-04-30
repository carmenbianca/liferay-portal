/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.properties.connection;

import com.liferay.talend.ui.UIKeys;

import java.util.EnumSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.talend.daikon.properties.PropertiesImpl;
import org.talend.daikon.properties.presentation.Form;
import org.talend.daikon.properties.property.Property;
import org.talend.daikon.properties.property.PropertyFactory;

/**
 * @author Igor Beslic
 */
public class BasicAuthorizationProperties extends PropertiesImpl {

	public BasicAuthorizationProperties(String name) {
		super(name);

		password = PropertyFactory.newString("password");

		password.setFlags(
			EnumSet.of(
				Property.Flags.ENCRYPT, Property.Flags.SUPPRESS_LOGGING));

		userId = PropertyFactory.newString("userId");

		if (_logger.isTraceEnabled()) {
			_logger.trace("Instantiated " + System.identityHashCode(this));
		}
	}

	@Override
	public void setupLayout() {
		Form referenceForm = new Form(this, UIKeys.FORM_BASIC_AUTHORIZATION);

		referenceForm.addRow(userId);

		referenceForm.addColumn(password);

		if (_logger.isTraceEnabled()) {
			_logger.trace("Layout set " + System.identityHashCode(this));
		}
	}

	@Override
	public void setupProperties() {
		password.setValue(UIKeys.LIFERAY_DEFAULT_PASSWORD);
		userId.setValue(UIKeys.LIFERAY_DEFAULT_USER_ID);

		if (_logger.isTraceEnabled()) {
			_logger.trace("Properties set " + System.identityHashCode(this));
		}
	}

	public Property<String> password;
	public Property<String> userId;

	private static final Logger _logger = LoggerFactory.getLogger(
		BasicAuthorizationProperties.class);

}