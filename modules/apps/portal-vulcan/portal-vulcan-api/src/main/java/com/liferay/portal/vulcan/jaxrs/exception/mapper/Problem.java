/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.jaxrs.exception.mapper;

import javax.ws.rs.core.Response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Javier Gamarra
 */
@XmlRootElement(name = "Problem")
public class Problem {

	public Problem(Response.Status status, String title) {
		_status = status;
		_title = title;
	}

	public Problem(
		String detail, Response.Status status, String title, String type) {

		_detail = detail;
		_status = status;
		_title = title;
		_type = type;
	}

	public String getDetail() {
		return _detail;
	}

	public Response.Status getStatus() {
		return _status;
	}

	public String getTitle() {
		return _title;
	}

	public String getType() {
		return _type;
	}

	public void setDetail(String detail) {
		_detail = detail;
	}

	public void setStatus(Response.Status status) {
		_status = status;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _detail;
	private Response.Status _status;
	private String _title;
	private String _type;

}