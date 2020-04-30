/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.internal.xstream;

import com.liferay.exportimport.kernel.xstream.XStreamHierarchicalStreamWriter;

import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author Daniel Kocsis
 */
public class XStreamHierarchicalStreamWriterAdapter
	implements XStreamHierarchicalStreamWriter {

	public XStreamHierarchicalStreamWriterAdapter(
		HierarchicalStreamWriter hierarchicalStreamWriter) {

		_hierarchicalStreamWriter = hierarchicalStreamWriter;
	}

	@Override
	public void addAttribute(String key, String value) {
		_hierarchicalStreamWriter.addAttribute(key, value);
	}

	@Override
	public void close() {
		_hierarchicalStreamWriter.close();
	}

	@Override
	public void endNode() {
		_hierarchicalStreamWriter.endNode();
	}

	@Override
	public void flush() {
		_hierarchicalStreamWriter.flush();
	}

	@Override
	public void setValue(String value) {
		_hierarchicalStreamWriter.setValue(value);
	}

	@Override
	public void startNode(String name) {
		_hierarchicalStreamWriter.startNode(name);
	}

	@Override
	public XStreamHierarchicalStreamWriterAdapter underlyingWriter() {
		return new XStreamHierarchicalStreamWriterAdapter(
			_hierarchicalStreamWriter.underlyingWriter());
	}

	private final HierarchicalStreamWriter _hierarchicalStreamWriter;

}