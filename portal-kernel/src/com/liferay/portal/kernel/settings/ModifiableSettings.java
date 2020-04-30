/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

import java.io.IOException;

import java.util.Collection;

import javax.portlet.ValidatorException;

/**
 * @author Iván Zaera
 */
public interface ModifiableSettings extends Settings {

	public Collection<String> getModifiedKeys();

	public void reset();

	public void reset(String key);

	public ModifiableSettings setValue(String key, String value);

	public ModifiableSettings setValues(ModifiableSettings modifiableSettings);

	public ModifiableSettings setValues(String key, String[] values);

	public void store() throws IOException, ValidatorException;

}