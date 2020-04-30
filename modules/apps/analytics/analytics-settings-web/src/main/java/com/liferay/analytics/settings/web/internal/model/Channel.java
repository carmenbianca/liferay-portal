/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.settings.web.internal.model;

/**
 * @author André Miranda
 */
public class Channel {

	public Channel(Long id, String name) {
		_id = id;
		_name = name;
	}

	public Long getId() {
		return _id;
	}

	public String getName() {
		return _name;
	}

	public void setId(Long id) {
		_id = id;
	}

	public void setName(String name) {
		_name = name;
	}

	private Long _id;
	private String _name;

}