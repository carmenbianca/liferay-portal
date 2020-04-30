/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.importer;

/**
 * @author Rubén Pulido
 */
public class LayoutPageTemplatesImporterResultEntry {

	public LayoutPageTemplatesImporterResultEntry(
		String name, int type, Status status) {

		_name = name;
		_type = type;
		_status = status;
	}

	public LayoutPageTemplatesImporterResultEntry(
		String name, int type, Status status, String errorMessage) {

		_name = name;
		_type = type;
		_status = status;
		_errorMessage = errorMessage;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #LayoutPageTemplatesImporterResultEntry(String, int, Status)}
	 */
	@Deprecated
	public LayoutPageTemplatesImporterResultEntry(String name, Status status) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #LayoutPageTemplatesImporterResultEntry(String, int, Status, String)}
	 */
	@Deprecated
	public LayoutPageTemplatesImporterResultEntry(
		String name, Status status, String errorMessage) {

		throw new UnsupportedOperationException();
	}

	public String getErrorMessage() {
		return _errorMessage;
	}

	public String getName() {
		return _name;
	}

	public Status getStatus() {
		return _status;
	}

	public int getType() {
		return _type;
	}

	public enum Status {

		IGNORED("ignored"), IMPORTED("imported"), INVALID("invalid");

		public String getLabel() {
			return _label;
		}

		private Status(String label) {
			_label = label;
		}

		private final String _label;

	}

	private String _errorMessage;
	private final String _name;
	private final Status _status;
	private int _type;

}