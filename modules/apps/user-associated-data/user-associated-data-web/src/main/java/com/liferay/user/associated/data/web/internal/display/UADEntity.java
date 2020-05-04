/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.web.internal.display;

import com.liferay.portal.kernel.util.KeyValuePair;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author William Newbury
 */
public class UADEntity<T> {

	public UADEntity(
		T entity, Serializable primaryKey, String editURL, boolean inTrash,
		Class<?> typeClass, boolean userOwned, String viewURL) {

		_entity = entity;
		_primaryKey = primaryKey;
		_editURL = editURL;
		_inTrash = inTrash;
		_typeClass = typeClass;
		_userOwned = userOwned;
		_viewURL = viewURL;
	}

	public void addColumnEntry(String key, Object value) {
		_columnEntries.add(new KeyValuePair(key, String.valueOf(value)));
	}

	public List<KeyValuePair> getColumnEntries() {
		if (_columnEntries.isEmpty()) {
			_columnEntries.add(
				new KeyValuePair("primaryKey", String.valueOf(_primaryKey)));
			_columnEntries.add(new KeyValuePair("editURL", _editURL));
		}

		return _columnEntries;
	}

	public Object getColumnEntry(String key) {
		for (KeyValuePair columnEntry : _columnEntries) {
			if (key.equals(columnEntry.getKey())) {
				return columnEntry.getValue();
			}
		}

		return null;
	}

	public String getEditURL() {
		return _editURL;
	}

	public T getEntity() {
		return _entity;
	}

	public Serializable getPrimaryKey() {
		return _primaryKey;
	}

	public Class<?> getTypeClass() {
		return _typeClass;
	}

	public String getViewURL() {
		return _viewURL;
	}

	public boolean isInTrash() {
		return _inTrash;
	}

	public boolean isUserOwned() {
		return _userOwned;
	}

	private final List<KeyValuePair> _columnEntries = new ArrayList<>();
	private final String _editURL;
	private final T _entity;
	private final boolean _inTrash;
	private final Serializable _primaryKey;
	private final Class<?> _typeClass;
	private final boolean _userOwned;
	private final String _viewURL;

}