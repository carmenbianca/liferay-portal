/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.xstream;

import java.util.Iterator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Daniel Kocsis
 */
@ProviderType
public interface XStreamHierarchicalStreamReader {

	public void close();

	public String getAttribute(int index);

	public String getAttribute(String name);

	public int getAttributeCount();

	public String getAttributeName(int index);

	public Iterator<String> getAttributeNames();

	public String getNodeName();

	public String getValue();

	public boolean hasMoreChildren();

	public void moveDown();

	public void moveUp();

	public XStreamHierarchicalStreamReader underlyingReader();

}