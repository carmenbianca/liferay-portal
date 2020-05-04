/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.xml;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public interface Document extends Branch, Cloneable {

	public Document addComment(String comment);

	public Document addDocumentType(
		String name, String publicId, String systemId);

	public Document clone();

	public DocumentType getDocumentType();

	public Element getRootElement();

	public String getXMLEncoding();

	public void setRootElement(Element rootElement);

	public void setXMLEncoding(String encoding);

}