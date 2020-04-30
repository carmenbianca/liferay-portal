/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.atom;

import java.io.InputStream;

/**
 * @author Igor Spasic
 */
public abstract class BaseMediaAtomCollectionAdapter<E>
	extends BaseAtomCollectionAdapter<E> {

	@Override
	public abstract String getMediaContentType(E entry);

	@Override
	public abstract String getMediaName(E entry) throws AtomException;

	@Override
	public abstract InputStream getMediaStream(E entry) throws AtomException;

	@Override
	protected abstract E doPostMedia(
			String mimeType, String slug, InputStream inputStream,
			AtomRequestContext atomRequestContext)
		throws Exception;

	@Override
	protected abstract void doPutMedia(
			E entry, String mimeType, String slug, InputStream inputStream,
			AtomRequestContext atomRequestContext)
		throws Exception;

}